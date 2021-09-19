package Model.DAO;

import Controller.dataResultTableColumn;
import Controller.dataResultTableRow;
import Model.BonusTalento;
import Model.ConnectPostgre;
import Model.Regra;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TalentoDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();
    String sql = null;
    Statement declaracao;
    ResultSet resultado;


    public static dataResultTableColumn getAllColumnData() throws SQLException {
        ArrayList<String> columnNames = new ArrayList<>();
        try (
                Statement declaracao = con.createStatement();
                ResultSet resultado = declaracao.executeQuery("select * from Talento")) {


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

    public static ArrayList<BonusTalento> ListBonus(String nomeTalento){
        ArrayList<BonusTalento> bonusTalentos = new ArrayList<>();
        String sql = "select * from BonusTalento where nomeTalento = \'" + nomeTalento + "\';";

        try{
            Statement declaracao = con.createStatement();
            ResultSet rs = declaracao.executeQuery(sql);

            while(rs.next()){

                String nome = rs.getString("nomeTalento");
                String descricao = rs.getString("descricao");

                BonusTalento bonusTalento = new BonusTalento(nome, descricao);
                bonusTalentos.add(bonusTalento);
            }

        } catch(SQLException e){
            System.out.println("Error");
        }
        return bonusTalentos;
    }


    public static ArrayList<String> ListTalentos(){
        ArrayList<String> strings = new ArrayList<>();
        String sql = "select nomeTalento from Talento";
        try{
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()){
                String nome = resultado.getString("nomeTalento");

                strings.add(nome);
            }

        }catch(SQLException e){
            System.out.println("Error");
        }
        return strings;
    }
}
