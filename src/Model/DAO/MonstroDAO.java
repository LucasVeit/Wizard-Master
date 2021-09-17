package Model.DAO;

import Controller.dataResultTableColumn;
import Controller.dataResultTableRow;
import Model.ConnectPostgre;
import Model.Monstro.*;

import java.sql.*;
import java.util.ArrayList;


public class MonstroDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();
    String sql = null;
    Statement declaracao;
    ResultSet resultado;


    public static dataResultTableColumn getAllColumnData() throws SQLException {
        ArrayList<String> columnNames = new ArrayList<>();
        try (
                Statement declaracao = con.createStatement();
                ResultSet resultado = declaracao.executeQuery("select * from Monstro")) {


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

    public ArrayList<Monstro> List(){
        ArrayList<Monstro> monstros = new ArrayList<>();
        sql = "select * from Monstro";

        try{
            declaracao = con.createStatement();
            resultado = declaracao.executeQuery(sql);
            
            while(resultado.next()){
                String nomeMonstro = resultado.getString("nomeMonstro");
                String descricao = resultado.getString("descricao");
                String foto = resultado.getString("foto");
                int classeArmadura = resultado.getInt("classeArmadura");
                int pontosVidaBase = resultado.getInt("pontosVidaBase");
                String tendencia = resultado.getString("tendencia");
                float nivel = resultado.getFloat("nivel");
                int pontosExperiencia = resultado.getInt("pontosExperiencia");
                String formaCorporal = resultado.getString("formaCorporal");
                String tamanho = resultado.getString("tamanho");
                float deslocamentoBase = resultado.getFloat("deslocamentoBase");

                int constituicao = getHabilidade("Constituição", nomeMonstro);
                int carisma = getHabilidade("Carisma", nomeMonstro);
                int destreza = getHabilidade("Destreza", nomeMonstro);
                int forca = getHabilidade("Força", nomeMonstro);
                int inteligencia = getHabilidade("Inteligência", nomeMonstro);
                int sabedoria = getHabilidade("Sabedoria", nomeMonstro);

                Monstro monstro = new Monstro(nomeMonstro, descricao, foto, classeArmadura, pontosVidaBase, tendencia, nivel, pontosExperiencia,
                formaCorporal, tamanho, deslocamentoBase, ListCaracteristica(nomeMonstro), constituicao, carisma, destreza, forca, inteligencia, sabedoria);
                 monstros.add(monstro);
            }

        } catch(SQLException e){
            System.out.println("Error");
        }
        
        return monstros;
    }

    public int getHabilidade(String habilidade, String nomeMonstro){
        sql = "select * from MonstroHabilidade where nomeMonstro = \'" + nomeMonstro + "\' and nomeHabilidade = \'" + habilidade + "\'";
        int pontosHabilidade = 0;

        try{
            declaracao = con.createStatement();
            ResultSet rs = declaracao.executeQuery(sql);

            while(rs.next()){
                pontosHabilidade  = rs.getInt("valor");

            }

        } catch(SQLException e){
            System.out.println("Error");
        }
        return pontosHabilidade;

    }

    public static ArrayList<CaracteristicaMonstro> ListCaracteristica(String nomeMonstro){
        ArrayList<CaracteristicaMonstro> caracteristicas = new ArrayList<>();
        String sql = "select * from CaracteristicaMonstro where nomeMonstro = \'" + nomeMonstro + "\';";

        try{
            Statement declaracao = con.createStatement();
            ResultSet rs = declaracao.executeQuery(sql);

            while(rs.next()){
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");

                CaracteristicaMonstro caracteristica = new CaracteristicaMonstro(nome, descricao);
                caracteristicas.add(caracteristica);
            }

        } catch(SQLException e){
            System.out.println("Error");
        }

        return caracteristicas;

    }
}
