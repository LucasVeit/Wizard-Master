package Model.DAO.New;

import Model.ConnectPostgre;
import Model.Mundo;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class MundoDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();

    public static ArrayList<Mundo> Listar(){
        ArrayList<Mundo> mundos = new ArrayList<>();
        String sql = "select * from Mundo";

        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {
                String nomeCampanha = resultado.getString("nomeCampanha");
                String nomePlano = resultado.getString("nomePlano");

                Mundo mundo = new Mundo(nomeCampanha, nomePlano);
                mundos.add(mundo);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista!");
            e.printStackTrace();
        }

        return mundos;
    }

    public static void Inserir(Mundo mundo){
        String sql = "insert into mundo (nomeCampanha, nomePlano)" +
                " VALUES" +
                "(?,?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mundo.getNomeCampanha());
            ps.setString(2, mundo.getNomePlano());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }
    }

    public static void Remover(Mundo mundo){
        String sql = "DELETE FROM mundo WHERE nomeCampanha = ? and nomePlano = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mundo.getNomeCampanha());
            ps.setString(2, mundo.getNomePlano());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }
}
