package Model.DAO;

import Controller.dataResultTableColumn;
import Controller.dataResultTableRow;
import Model.ConnectPostgre;
import Model.Deus;
import Model.Plano;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DeusDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();
    String sql = null;
    Statement declaracao;
    ResultSet resultado;


    public static dataResultTableColumn getAllColumnData() throws SQLException {
        ArrayList<String> columnNames = new ArrayList<>();
        try (
                Statement declaracao = con.createStatement();
                ResultSet resultado = declaracao.executeQuery("select * from Deus")) {


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

    public static Deus GetDeus(String nomeDeus){

        String sql = "select * from Deus where nomeDeus = '" + nomeDeus + "';";
        Deus deus = new Deus();
        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()) {
                int codigo = resultado.getInt("codigoDeus");
                String nome = resultado.getString("nomeDeus");
                String mitologia = resultado.getString("mitologia");
                String dominio = resultado.getString("dominio");
                String tendencia = resultado.getString("tendencia");
                String simbolo = resultado.getString("simbolo");
                String descricao = resultado.getString("descricao");
                deus = new Deus(codigo, nome, mitologia, dominio, tendencia, simbolo, descricao);
            }
        }catch(SQLException e){
            System.out.println("Error");
        }
        return deus;
    }

    public static Deus GetDeusID(int cod){

        String sql = "select * from Deus where codigoDeus = '" + cod + "';";
        Deus deus = new Deus();

        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()) {
                int codigo = resultado.getInt("codigoDeus");
                String nome = resultado.getString("nomeDeus");
                String mitologia = resultado.getString("mitologia");
                String dominio = resultado.getString("dominio");
                String tendencia = resultado.getString("tendencia");
                String simbolo = resultado.getString("simbolo");
                String descricao = resultado.getString("descricao");
                deus = new Deus(codigo, nome, mitologia, dominio, tendencia, simbolo, descricao);
            }
        }catch(SQLException e){
            System.out.println("Error");
        }
        return deus;
    }
    public static ArrayList<Deus> Listar(){
        ArrayList<Deus> deuses = new ArrayList<>();
        String sql = "select * from Deus";

        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()) {
                int codigo = resultado.getInt("codigoDeus");
                String nome = resultado.getString("nomeDeus");
                String mitologia = resultado.getString("mitologia");
                String dominio = resultado.getString("dominio");
                String tendencia = resultado.getString("tendencia");
                String simbolo = resultado.getString("simbolo");
                String descricao = resultado.getString("descricao");
                Deus deus = new Deus(codigo, nome, mitologia, dominio, tendencia, simbolo, descricao);

                deuses.add(deus);
            }
        }catch(SQLException e){
            System.out.println("Error");
        }

        return deuses;
    }

}
