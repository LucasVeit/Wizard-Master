package Model.DAO;

import Controller.dataResultTableColumn;
import Controller.dataResultTableRow;
import Model.ConnectPostgre;
import Model.Item.*;
import Model.Magia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();
    String sql = null;
    Statement declaracao;
    ResultSet resultado;


    public static dataResultTableColumn getAllColumnData() throws SQLException {
        ArrayList<String> columnNames = new ArrayList<>();
        try (
                Statement declaracao = con.createStatement();
                ResultSet resultado = declaracao.executeQuery("select * from Item")) {


            int columnCount = resultado.getMetaData().getColumnCount();

            for (int i = 1 ; i <= columnCount ; ++i) {
                columnNames.add(resultado.getMetaData().getColumnName(i));
            }
        }

        return new dataResultTableColumn(columnNames);
    }

    public static dataResultTableRow getAllRowData(String search, String category, String attribute, String type) throws SQLException {
        ArrayList<ArrayList<Object>> data = new ArrayList<>();
        String sql;
        if(type == "String")
            sql = "select * from " + category + " where " + attribute + " like '%" + search + "%';";
        else
            sql = "select * from " + category + " where " + attribute + "=" + search + ";";

        try(
                Statement declaracao = con.createStatement();
                ResultSet resultado = declaracao.executeQuery(sql)){

            while(resultado.next()) {
                ArrayList<Object> table = new ArrayList<>();
                for (int i = 1; i <= resultado.getMetaData().getColumnCount(); ++i) {
                    table.add(resultado.getObject(i));
                }
                data.add(table);
            }


        }catch(SQLException e) {
            System.out.println("Error");
        }

        return new dataResultTableRow(data);
    }

    public static ArrayList<Item> List(){
        ArrayList<Item> itens = new ArrayList<>();
        String sql = "select * from Item";
        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()){
                String nomeItem = resultado.getString("nomeItem");
                String descricao = resultado.getString("descricao");
                String categoria = resultado.getString("categoria");
                int custo = resultado.getInt("custo");
                String moeda = resultado.getString("moeda");
                float peso = resultado.getFloat("peso");

                Item item = new Item(nomeItem, descricao, categoria, custo, moeda, peso);

                itens.add(item);

            }

        }catch(SQLException e){
            System.out.println("Error");
        }
        return itens;
    }

    public static ArrayList<Item> Search(String search, String category, String attribute){
        ArrayList<Item> itens = new ArrayList<>();
        String sql;
        if(attribute == "custo" || attribute == "peso")
            sql = "select * from " + category + " where " + attribute + "=" + search + ";";
        else
            sql = "select * from " + category + " where " + attribute + " like '%" + search + "%';";

        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()){
                String nomeItem = resultado.getString("nomeItem");
                String descricao = resultado.getString("descricao");
                String categoria = resultado.getString("categoria");
                int custo = resultado.getInt("custo");
                String moeda = resultado.getString("moeda");
                float peso = resultado.getFloat("peso");

                Item item = new Item(nomeItem, descricao, categoria, custo, moeda, peso);

                itens.add(item);

            }

        }catch(SQLException e){
            System.out.println("Error");
        }
        return itens;
    }

    public static Arma getArma(String nomeItem){
        String sql = "select * from Arma where nomeItem = '" + nomeItem + "';";
        Arma arma = new Arma();
        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()) {
                String tipo = resultado.getString("tipo");
                String dano = resultado.getString("dano");
                ArrayList<PropriedadeArma> propriedadeArma = getPropriedadeArma(nomeItem);
                arma = new Arma(tipo, dano, propriedadeArma);
            }

        }catch(SQLException e){
            System.out.println("Error");
        }

        return arma;
    }

    public static ArrayList<PropriedadeArma> getPropriedadeArma(String nome){
        ArrayList<PropriedadeArma> propriedadearmas = new ArrayList<>();
        String sql = "select ArmaPropriedadeArma.nomePropriedade, PropriedadeArma.descricao as descricao, ArmaPropriedadeArma.descricao as descricaoArma " +
                "from ArmaPropriedadeArma " +
                "inner join PropriedadeArma on " +
                "ArmaPropriedadeArma.nomePropriedade = PropriedadeArma.nomePropriedade " +
                "where ArmaPropriedadeArma.nomeItem = '" + nome + "';";
        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()){
                String nomePropriedade = resultado.getString("nomepropriedade");
                String descricaoPropriedade = resultado.getString("descricao");
                String descricaoCaracteristica = resultado.getString("descricaoarma");
                PropriedadeArma propriedadeArma = new PropriedadeArma(nomePropriedade, descricaoPropriedade, descricaoCaracteristica);

                propriedadearmas.add(propriedadeArma);

            }

        }catch(SQLException e){
            System.out.println("Error");
        }
        return propriedadearmas;
    }

    public static Montaria getMontaria(String nomeItem){
        String sql = "select * from Montaria where nomeItem = '" + nomeItem + "';";
        Montaria montaria = new Montaria();

        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()) {
                float deslocamento = resultado.getFloat("deslocamento");
                float capacidadeCarga = resultado.getFloat("capacidadeCarga");
                montaria = new Montaria(deslocamento, capacidadeCarga);
            }

        }catch(SQLException e){
            System.out.println("Error");
        }
        return montaria;
    }

    public static ArmaduraEscudo getArmaduraEscudo(String nomeItem){
        String sql = "select * from ArmaduraEscudo where nomeItem = '" + nomeItem + "';";
        ArmaduraEscudo armaduraEscudo = new ArmaduraEscudo();
        System.out.println(sql);

        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()) {
                int classeArmadura = resultado.getInt("classeArmadura");
                boolean modificadorDes = resultado.getBoolean("modificadorDes");
                int maxModificador = resultado.getInt("maxModificador");
                int forcaNecessaria = resultado.getInt("forcaNecessaria");
                String tipo = resultado.getString("tipo");
                boolean furtividade = resultado.getBoolean("furtividade");

                sql = "select * from Tempo where tipo = '" + tipo.toString() + "';";
                Statement declaracao2 = con.createStatement();
                ResultSet resultado2 = declaracao2.executeQuery(sql);
                resultado2.next();

                int periodoEquipar = resultado2.getInt("equipar");
                int periodoDesequipar = resultado2.getInt("desequipar");
                String medidaPeriodo = resultado2.getString("medida");

                armaduraEscudo = new ArmaduraEscudo(classeArmadura, modificadorDes, maxModificador, forcaNecessaria, tipo, furtividade, periodoEquipar, periodoDesequipar, medidaPeriodo);
            }
        }catch(SQLException e){
            System.out.println("Error");
        }

        return armaduraEscudo;

    }

    public static ItemMagico getItemMagico(String nomeItem){
        String sql = "select * from ItemMagico where nomeItem = '" + nomeItem + "';";
        ItemMagico itemMagico = new ItemMagico();
        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()) {
                String tipo = resultado.getString("tipo");
                String raridade = resultado.getString("raridade");
                String requisito = resultado.getString("requisito");
                itemMagico = new ItemMagico(tipo, raridade, requisito);
            }
        }catch(SQLException e){
            System.out.println("Error");
        }
        return itemMagico;
    }

    public static ArrayList<String> ListNomeItens(){
        ArrayList<String> strings = new ArrayList<>();
        String sql = "select nomeItem from Item";
        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()){
                String nomeItem = resultado.getString("nomeItem");


                strings.add(nomeItem);
            }

        }catch(SQLException e){
            System.out.println("Error");
        }
        return strings;
    }
}