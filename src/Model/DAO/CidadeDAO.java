package Model.DAO;

import Controller.CampanhaAtualController;
import Model.Cidade;
import Model.ConnectPostgre;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class CidadeDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();

    public static ArrayList<Cidade> Listar(){
        ArrayList<Cidade> cidades = new ArrayList<>();
        String sql = "select * from Cidade where nomeCampanha = '" + CampanhaAtualController.getCampanhaAtual().getNome() + "';";

        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {
                int codigo = resultado.getInt("codigoCidade");
                String nomeCidade = resultado.getString("nomeCidade");
                String nomeCampanha = resultado.getString("nomeCampanha");
                String comercio = resultado.getString("comercio");
                String clima = resultado.getString("clima");
                String vegetacao = resultado.getString("vegetacao");
                int populacao = resultado.getInt("populacao");
                String formaGoverno = resultado.getString("formaGoverno");
                String descricao = resultado.getString("descricao");

                Cidade cidade = new Cidade(codigo, nomeCidade, nomeCampanha, comercio, clima, vegetacao, populacao, formaGoverno, descricao);
                cidades.add(cidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cidades;
    }

    public static void Inserir(Cidade cidade){
        String sql = "insert into cidade (nomeCidade, nomeCampanha, comercio, clima, vegetacao, populacao, formaGoverno, descricao)" +
                "VALUES" +
                "(?,?,?,?,?,?,?,?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cidade.getNomeCidade());
            ps.setString(2, cidade.getNomeCampanha());
            ps.setString(3, cidade.getComercio());
            ps.setString(4, cidade.getClima());
            ps.setString(5, cidade.getVegetacao());
            ps.setInt(6, cidade.getPopulacao());
            ps.setString(7, cidade.getFormaGoverno());
            ps.setString(8, cidade.getDescricao());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }
    }

    public static void Atualizar(Cidade cidade){
        String sql = "update cidade set nomeCidade = ?, nomeCampanha = ?, comercio = ?, clima = ?, vegetacao = ?, populacao = ?, formaGoverno = ?, descricao = ?" +
                " where codigoCidade = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cidade.getNomeCidade());
            ps.setString(2, cidade.getNomeCampanha());
            ps.setString(3, cidade.getComercio());
            ps.setString(4, cidade.getClima());
            ps.setString(5, cidade.getVegetacao());
            ps.setInt(6, cidade.getPopulacao());
            ps.setString(7, cidade.getFormaGoverno());
            ps.setString(8, cidade.getDescricao());
            ps.setInt(9, cidade.getCodigo());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            e.printStackTrace();
        }
    }

    public static void Remover(Cidade cidade){
        String sql = "delete from cidade where codigoCidade = ?";

        LiderDAO.RemoverID(cidade.getCodigo(), "Cidade", "Cidade");

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cidade.getCodigo());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }


    public static ArrayList<String> ListarLiderCidade(Cidade cidade){
        ArrayList<String> lideres = new ArrayList<>();
        String sql = "select nomeLider from (select * from liderCidade where codigoCidade = "+ cidade.getCodigo() + ") as liderCidade " +
                "inner join lider " +
                "on lider.codigoLider = liderCidade.codigoLider;";

        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {
                String nomeLider = resultado.getString("nomeLider");
                lideres.add(nomeLider);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista!");
            e.printStackTrace();
        }

        return lideres;
    }

    public static void InserirLider(Cidade cidade, String lider){
        String sql = "insert into LiderCidade (codigoCidade, codigoLider)" +
                " VALUES" +
                "(?,?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cidade.getCodigo());
            ps.setInt(2, LiderDAO.GetLider(lider, cidade.getNomeCampanha()).getCodigoLider());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }
    }

    public static void RemoverLider(Cidade cidade, String lider){
        String sql = "delete from LiderCidade where codigoCidade = ? and codigoLider = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cidade.getCodigo());
            ps.setInt(2, LiderDAO.GetLider(lider, cidade.getNomeCampanha()).getCodigoLider());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }
}
