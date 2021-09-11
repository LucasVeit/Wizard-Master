package Model.DAO;

import Model.ConnectPostgre;
import Model.Item.*;
import Model.Magia;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();

    public static ArrayList<Item> List(){
        ArrayList<Item> itens = new ArrayList<>();
        String sql = "select * from Item";
        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()){
                SimpleStringProperty nomeItem = new SimpleStringProperty(resultado.getString("nomeItem"));
                SimpleStringProperty descricao = new SimpleStringProperty(resultado.getString("descricao"));;
                SimpleStringProperty categoria = new SimpleStringProperty(resultado.getString("categoria"));;
                SimpleIntegerProperty custo = new SimpleIntegerProperty(resultado.getInt("custo"));;
                SimpleStringProperty moeda = new SimpleStringProperty(resultado.getString("moeda"));;
                SimpleFloatProperty peso = new SimpleFloatProperty(resultado.getFloat("peso"));;

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
                SimpleStringProperty nomeItem = new SimpleStringProperty(resultado.getString("nomeItem"));
                SimpleStringProperty descricao = new SimpleStringProperty(resultado.getString("descricao"));;
                SimpleStringProperty categoria = new SimpleStringProperty(resultado.getString("categoria"));;
                SimpleIntegerProperty custo = new SimpleIntegerProperty(resultado.getInt("custo"));;
                SimpleStringProperty moeda = new SimpleStringProperty(resultado.getString("moeda"));;
                SimpleFloatProperty peso = new SimpleFloatProperty(resultado.getFloat("peso"));;

                Item item = new Item(nomeItem, descricao, categoria, custo, moeda, peso);

                itens.add(item);

            }

        }catch(SQLException e){
            System.out.println("Error");
        }
        return itens;
    }

    public static Arma getArma(Item item){
        String sql = "select * from Arma where nomeItem = " + item.getNomeItem() + ";";
        Arma arma = new Arma();
        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            SimpleStringProperty tipo = new SimpleStringProperty(resultado.getString("tipo"));;
            SimpleStringProperty dano = new SimpleStringProperty(resultado.getString("dano"));;
            ArrayList<PropriedadeArma> propriedadeArma = getPropriedadeArma(item.getNomeItem());
            arma = new Arma(item, tipo, dano, propriedadeArma);

        }catch(SQLException e){
            System.out.println("Error");
        }

        return arma;


    }

    public static ArrayList<PropriedadeArma> getPropriedadeArma(String nome){
        ArrayList<PropriedadeArma> propriedadearmas = new ArrayList<>();
        String sql = "select * from ArmaPropriedadeArma " +
                "inner join PropriedadeArma on" +
                "ArmaPropriedadeArma.nomePropriedade = PropriedadeArma.nomePropriedade" +
                "where ArmaPropriedadeArma.nomeItem = " + nome + ";";

        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()){
                SimpleStringProperty nomePropriedade = new SimpleStringProperty(resultado.getString("ArmaPropriedadeArma.nomePropriedade"));;
                SimpleStringProperty descricaoPropriedade = new SimpleStringProperty(resultado.getString("PropriedadeArma.descricao"));;
                SimpleStringProperty descricaoCaracteristica = new SimpleStringProperty(resultado.getString("ArmaPropriedadeArma.descricao"));;

                PropriedadeArma propriedadeArma = new PropriedadeArma(nomePropriedade, descricaoPropriedade, descricaoCaracteristica);

                propriedadearmas.add(propriedadeArma);

            }

        }catch(SQLException e){
            System.out.println("Error");
        }
        return propriedadearmas;
    }

    public static Montaria getMontaria(Item item){
        String sql = "select * from Montaria where nomeItem = " + item.getNomeItem() + ";";
        Montaria montaria = new Montaria();
        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            resultado.next();
            SimpleFloatProperty deslocamento = new SimpleFloatProperty(resultado.getFloat("deslocamento"));
            SimpleFloatProperty capacidadeCarga = new SimpleFloatProperty(resultado.getFloat("capacidadeCarga"));
            montaria = new Montaria(item, deslocamento, capacidadeCarga);


        }catch(SQLException e){
            System.out.println("Error");
        }
        return montaria;
    }

    public static ArmaduraEscudo getArmaduraEscudo(Item item){
        String sql = "select * from ArmaduraEscudo where nomeItem = " + item.getNomeItem() + ";";
        ArmaduraEscudo armaduraEscudo = new ArmaduraEscudo();

        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            resultado.next();
            SimpleIntegerProperty classeArmadura = new SimpleIntegerProperty(resultado.getInt("classeArmadura"));
            SimpleBooleanProperty modificadorDes = new SimpleBooleanProperty(resultado.getBoolean("modificadorDes"));
            SimpleIntegerProperty maxModificador = new SimpleIntegerProperty(resultado.getInt("maxModificador"));
            SimpleIntegerProperty forcaNecessaria = new SimpleIntegerProperty(resultado.getInt("forcaNecessaria"));
            SimpleStringProperty tipo = new SimpleStringProperty(resultado.getString("tipo"));
            SimpleBooleanProperty furtividade =  new SimpleBooleanProperty(resultado.getBoolean("furtividade"));

            sql = "select * from Tempo where tipo = " + tipo.toString() + ";";
            Statement declaracao2 = con.createStatement();
            ResultSet resultado2 = declaracao2.executeQuery(sql);
            resultado2.next();

            SimpleIntegerProperty periodoEquipar =  new SimpleIntegerProperty(resultado2.getInt("equipar"));;
            SimpleIntegerProperty periodoDesequipar =  new SimpleIntegerProperty(resultado2.getInt("desequipar"));;
            SimpleStringProperty medidaPeriodo =  new SimpleStringProperty(resultado2.getString("medida"));;

            armaduraEscudo = new ArmaduraEscudo(item, classeArmadura, modificadorDes, maxModificador, forcaNecessaria, tipo, furtividade, periodoEquipar, periodoDesequipar, medidaPeriodo);

        }catch(SQLException e){
            System.out.println("Error");
        }

        return armaduraEscudo;

    }

    public static ItemMagico getItemMagico(Item item){
        String sql = "select * from ItemMagico where nomeItem = " + item.getNomeItem() + ";";
        ItemMagico itemMagico = new ItemMagico();
        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            resultado.next();
            SimpleStringProperty tipo = new SimpleStringProperty(resultado.getString("tipo"));
            SimpleStringProperty raridade = new SimpleStringProperty(resultado.getString("raridade"));;
            SimpleStringProperty requisito = new SimpleStringProperty(resultado.getString("requisito"));;
            itemMagico = new ItemMagico(item, tipo, raridade, requisito);

        }catch(SQLException e){
            System.out.println("Error");
        }
        return itemMagico;
    }
}