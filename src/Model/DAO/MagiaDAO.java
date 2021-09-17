package Model.DAO;

import Controller.dataResultTableColumn;
import Controller.dataResultTableRow;
import Model.ConnectPostgre;
import Model.Magia;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.*;
import java.util.ArrayList;

public class MagiaDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();
    String sql = null;
    Statement declaracao;
    ResultSet resultado;


    public static dataResultTableColumn getAllColumnData() throws SQLException {
        ArrayList<String> columnNames = new ArrayList<>();
        try (
                Statement declaracao = con.createStatement();
                ResultSet resultado = declaracao.executeQuery("select * from Magia")) {


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


    public static ArrayList<Magia> List(){
        ArrayList<Magia> magias = new ArrayList<>();
        String sql = "select * from Magia";

        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()){

                SimpleStringProperty nomeMagia = new SimpleStringProperty(resultado.getString("nomeMagia"));
                SimpleStringProperty tipo = new SimpleStringProperty(resultado.getString("tipo"));
                SimpleIntegerProperty nivel = new SimpleIntegerProperty(resultado.getInt("nivel"));
                SimpleStringProperty descricao = new SimpleStringProperty(resultado.getString("descricao"));
                SimpleStringProperty duracao = new SimpleStringProperty(resultado.getString("duracao"));
                SimpleStringProperty componentes = new SimpleStringProperty(resultado.getString("componentes"));
                SimpleStringProperty alcance = new SimpleStringProperty(resultado.getString("alcance"));
                SimpleStringProperty tempoConjuracao = new SimpleStringProperty(resultado.getString("tempoConjuracao"));

                Magia magia = new Magia(nomeMagia, tipo, nivel, descricao, duracao, componentes, alcance, tempoConjuracao);

                magias.add(magia);

            }

        }catch(SQLException e){
            System.out.println("Error");
        }
        return magias;
    }

    public static ArrayList<Magia> Search(String search, String category, String attribute){
        ArrayList<Magia> magias = new ArrayList<>();
        String sql;
        if(attribute == "nivel")
            sql = "select * from " + category + " where " + attribute + "=" + search + ";";
        else
            sql = "select * from " + category + " where " + attribute + " like '%" + search + "%';";

        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()){
                SimpleStringProperty nomeMagia = new SimpleStringProperty(resultado.getString("nomeMagia"));
                SimpleStringProperty tipo = new SimpleStringProperty(resultado.getString("tipo"));
                SimpleIntegerProperty nivel = new SimpleIntegerProperty(resultado.getInt("nivel"));
                SimpleStringProperty descricao = new SimpleStringProperty(resultado.getString("descricao"));
                SimpleStringProperty duracao = new SimpleStringProperty(resultado.getString("duracao"));
                SimpleStringProperty componentes = new SimpleStringProperty(resultado.getString("componentes"));
                SimpleStringProperty alcance = new SimpleStringProperty(resultado.getString("alcance"));
                SimpleStringProperty tempoConjuracao = new SimpleStringProperty(resultado.getString("tempoConjuracao"));

                Magia magia = new Magia(nomeMagia, tipo, nivel, descricao, duracao, componentes, alcance, tempoConjuracao);

                magias.add(magia);

            }

        }catch(SQLException e){
            System.out.println("Error");
        }
        return magias;
    }

}
