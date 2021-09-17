package Model.DAO.New;

import Model.Faccao;
import Model.ConnectPostgre;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class FaccaoDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();
    //String sql = null;
    //Statement declaracao;
    //ResultSet resultado;

    public static ArrayList<Faccao> Listar(){
        ArrayList<Faccao> faccoes = new ArrayList<>();
        String sql = "select * from Faccao";

        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {
                int codigo = resultado.getInt("codigoFaccao");
                String nomeFaccao = resultado.getString("nomeFaccao");
                String nomeCampanha = resultado.getString("nomeCampanha");
                int populacao = resultado.getInt("populacao");
                String formaGoverno = resultado.getString("formaGoverno");
                String descricao = resultado.getString("descricao");

                Faccao faccao = new Faccao(codigo, nomeFaccao, nomeCampanha, populacao, formaGoverno, descricao);
                faccoes.add(faccao);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista!");
            e.printStackTrace();
        }

        return faccoes;
    }

    public static void Inserir(Faccao faccao){
        String sql = "insert into faccao (nomeFaccao, nomeCampanha, populacao, formaGoverno, descricao)" +
                "VALUES" +
                "(?,?,?,?,?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, faccao.getNomeFaccao());
            ps.setString(2, faccao.getNomeCampanha());
            ps.setInt(3, faccao.getPopulacao());
            ps.setString(4, faccao.getFormaGoverno());
            ps.setString(5, faccao.getDescricao());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }
    }

    public static void Atualizar(Faccao faccao){
        String sql = "UPDATE faccao SET nomeFaccao = ?, nomeCampanha = ?, populacao = ?, formaGoverno = ?, descricao = ?" +
                " WHERE codigoFaccao = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, faccao.getNomeFaccao());
            ps.setString(2, faccao.getNomeCampanha());
            ps.setInt(3, faccao.getPopulacao());
            ps.setString(4, faccao.getFormaGoverno());
            ps.setString(5, faccao.getDescricao());
            ps.setInt(6, faccao.getCodigo());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            e.printStackTrace();
        }
    }

    public static void Remover(Faccao faccao){
        String sql = "DELETE FROM faccao WHERE codigoFaccao = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, faccao.getCodigo());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }
}
