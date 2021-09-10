package Model.DAO;

import Model.ConnectPostgre;
import Model.Magia;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.*;
import java.util.ArrayList;

public final class MagiaDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();

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

    public static ArrayList<Magia> SearchByText(String search, String category, String attribute){
        ArrayList<Magia> magias = new ArrayList<>();
        String sql = "select * from " + category + " where " + attribute + " like '%" + search + "%';";

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
