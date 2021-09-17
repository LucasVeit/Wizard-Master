package Model.DAO;

import Controller.dataResultTableColumn;
import Controller.dataResultTableRow;
import Model.ConnectPostgre;
import Model.Monstro.CaracteristicaMonstro;
import Model.Regra;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlanoDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();
    String sql = null;
    Statement declaracao;
    ResultSet resultado;


    public static dataResultTableColumn getAllColumnData() throws SQLException {
        ArrayList<String> columnNames = new ArrayList<>();
        try (
                Statement declaracao = con.createStatement();
                ResultSet resultado = declaracao.executeQuery("select * from Plano")) {


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

    public static ArrayList<Regra> ListRegras(String nomePlano){
        ArrayList<Regra> regras = new ArrayList<>();
        String sql = "select * from Regra where nomePlano = \'" + nomePlano + "\';";

        try{
            Statement declaracao = con.createStatement();
            ResultSet rs = declaracao.executeQuery(sql);

            while(rs.next()){
                String nome = rs.getString("nomeRegra");
                String descricao = rs.getString("descricao");

                Regra regra = new Regra(nome, descricao);
                regras.add(regra);
            }

        } catch(SQLException e){
            System.out.println("Error");
        }

        return regras;
    }
}
