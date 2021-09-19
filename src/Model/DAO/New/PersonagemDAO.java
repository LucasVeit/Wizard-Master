package Model.DAO.New;

import Model.Cidade;
import Model.ConnectPostgre;
import Model.Personagem.Personagem;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class PersonagemDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();

    public static ArrayList<Cidade> Listar(){
        ArrayList<Cidade> cidades = new ArrayList<>();
        String sql = "select * from Cidade";

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
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista!");
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

    public static void InserirItem(Personagem personagem, String nomeItem, int quant, boolean equip){
        String sql = "insert into PersonagemItem (codigoPersonagem, nomeItem, quantidade, equipado)" +
                " VALUES" +
                "(?, ?, ?, ?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomeItem);
            ps.setInt(3, quant);
            ps.setBoolean(4, equip);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }
    }

    public static void RemoverItem(Personagem personagem, String nomeItem){
        String sql = "delete from PersonagemItem where codigoPersonagem = ? and nomeItem = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomeItem);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }

    public static void InserirPericia(Personagem personagem, String nomePericia){
        String sql = "insert into PersonagemPericia (codigoPersonagem, nomePericia)" +
                " VALUES" +
                "(?, ?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomePericia);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }
    }

    public static void RemoverPericia(Personagem personagem, String nomePericia){
        String sql = "delete from PersonagemPericia where codigoPersonagem = ? and nomePericia = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomePericia);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }

    public static void InserirMagia(Personagem personagem, String nomeMagia){
        String sql = "insert into PersonagemMagia (codigoPersonagem, nomeMagia)" +
                " VALUES" +
                "(?, ?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomeMagia);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }
    }

    public static void RemoverMagia(Personagem personagem, String nomeMagia){
        String sql = "delete from PersonagemMagia where codigoPersonagem = ? and nomeMagia = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomeMagia);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }




}
