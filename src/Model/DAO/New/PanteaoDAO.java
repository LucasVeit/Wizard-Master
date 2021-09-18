package Model.DAO.New;

import Model.ConnectPostgre;
import Model.Panteao;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class PanteaoDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();

    public static ArrayList<Panteao> Listar(){
        ArrayList<Panteao> pantoes = new ArrayList<>();
        String sql = "select * from PanteaoCampanha";

        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {
                String nomeCampanha = resultado.getString("nomeCampanha");
                int codigoDeus = resultado.getInt("codigoDeus");

                Panteao panteao = new Panteao(nomeCampanha, codigoDeus);
                pantoes.add(panteao);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista!");
            e.printStackTrace();
        }

        return pantoes;
    }

    public static void Inserir(Panteao panteao){
        String sql = "insert into PanteaoCampanha (nomeCampanha, codigoDeus)" +
                " VALUES" +
                "(?,?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, panteao.getNomeCampanha());
            ps.setInt(2, panteao.getCodigoDeus());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }
    }

    public static void Remover(Panteao panteao){
        String sql = "DELETE FROM PanteaoCampanha WHERE nomeCampanha = ? and codigoDeus = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, panteao.getNomeCampanha());
            ps.setInt(2, panteao.getCodigoDeus());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }
}
