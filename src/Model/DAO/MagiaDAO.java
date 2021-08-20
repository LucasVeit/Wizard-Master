package Model.DAO;

import Model.ConnectPostgre;
import Model.Magia;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.*;
import java.util.ArrayList;

public class MagiaDAO {
    Connection con = ConnectPostgre.ConnectDatabase();
    String sql = null;
    Statement declaracao;
    ResultSet resultado;

    public ArrayList<Magia> List(){
        ArrayList<Magia> magias = new ArrayList<>();
        sql = "select * from Magia";

        try{
            declaracao = con.createStatement();
            resultado = declaracao.executeQuery(sql);

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
