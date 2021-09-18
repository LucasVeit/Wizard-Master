package Model.DAO.New;

import Model.ConnectPostgre;
import Model.Lider;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class LiderDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();

    public static ArrayList<Lider> Listar(){
        ArrayList<Lider> lideres = new ArrayList<>();
        String sql = "select * from Lider";

        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {
                int codigo = resultado.getInt("codigoLider");
                String nomeLider = resultado.getString("nomeLider");
                String descricao = resultado.getString("descricao");
                String nomeCampanha = resultado.getString("nomeCampanha");

                Lider lider = new Lider(codigo, nomeLider, descricao, nomeCampanha);
                lideres.add(lider);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista!");
            e.printStackTrace();
        }

        return lideres;
    }

    public static void Inserir(Lider lider){
        String sql = "insert into lider (nomeLider, descricao, nomeCampanha)" +
                " VALUES" +
                "(?,?,?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lider.getNomeLider());
            ps.setString(2, lider.getDescricao());
            ps.setString(3, lider.getNomeCampanha());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }
    }

    public static void Atualizar(Lider lider){
        String sql = "UPDATE lider SET nomeLider = ?,  descricao = ?, nomeCampanha = ?" +
                " WHERE codigoLider = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lider.getNomeLider());
            ps.setString(2, lider.getDescricao());
            ps.setString(3, lider.getNomeCampanha());
            ps.setInt(4, lider.getCodigoLider());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            e.printStackTrace();
        }
    }

    public static void Remover(Lider lider){
        String sql = "delete from lider where codigoLider = ?";

        RemoverID(lider.getCodigoLider(), "Faccao", "Lider");
        RemoverID(lider.getCodigoLider(), "Cidade", "Lider");
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, lider.getCodigoLider());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }

    public static void RemoverID(int id, String nomeTabela, String nomeCampo){
        String sql = "delete from Lider" + nomeTabela + "  WHERE codigo" + nomeCampo + " = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Lider GetLider(String nome, String campanha){
        Lider lider = new Lider();
        String sql = "select * from Lider where nomeLider = '" + nome + "' and nomeCampanha = '" + campanha + "';";
        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {
                int codigo = resultado.getInt("codigoLider");
                String nomeLider = resultado.getString("nomeLider");
                String descricao = resultado.getString("descricao");
                String nomeCampanha = resultado.getString("nomeCampanha");

                lider = new Lider(codigo, nomeLider, descricao, nomeCampanha);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista!");
            e.printStackTrace();
        }

        return lider;

    }
}
