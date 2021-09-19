package Model.DAO;

import Controller.dataResultTableColumn;
import Controller.dataResultTableRow;
import Model.BonusTalento;
import Model.ConnectPostgre;
import Model.Raca;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SubRacaDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();
    String sql = null;
    Statement declaracao;
    ResultSet resultado;


    public static dataResultTableColumn getAllColumnData() throws SQLException {
        ArrayList<String> columnNames = new ArrayList<>();
        try (
                Statement declaracao = con.createStatement();
                ResultSet resultado = declaracao.executeQuery("select * from SubRaca")) {


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

    public static Raca GetRaca(String nomeRaca){
        Raca raca = null;
        String sql = "select * from Raca where nomeRaca = \'" + nomeRaca + "\';";

        try{
            Statement declaracao = con.createStatement();
            ResultSet rs = declaracao.executeQuery(sql);

            while(rs.next()){

                String nome = rs.getString("nomeRaca");
                String caminhoImagem = rs.getString("caminhoImagem");
                String descricao = rs.getString("descricao");
                raca = new Raca(nome, caminhoImagem, descricao);
            }

        } catch(SQLException e){
            System.out.println("Error");
        }
        return raca;
    }


    public static ArrayList<String> ListSubRaca(){
        ArrayList<String> subracas = new ArrayList<>();
        String sql = "select nomeSubRaca from SubRaca;";

        try{
            Statement declaracao = con.createStatement();
            ResultSet rs = declaracao.executeQuery(sql);

            while(rs.next()){

                String nome = rs.getString("nomeSubRaca");
                subracas.add(nome);
            }

        } catch(SQLException e){
            System.out.println("Error");
        }
        return subracas;
    }

    public static String GetEnderecoFoto(String nomeRaca){
        String foto = null;
        String sql = "select caminhoImagem from Raca where nomeRaca = \'" + nomeRaca + "\';";

        try{
            Statement declaracao = con.createStatement();
            ResultSet rs = declaracao.executeQuery(sql);

            while(rs.next()){
                foto = rs.getString("caminhoImagem");

            }

        } catch(SQLException e){
            System.out.println("Error");
        }

        return foto;

    }

}
