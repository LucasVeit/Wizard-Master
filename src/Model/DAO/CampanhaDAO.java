package Model.DAO;

import Controller.CampanhaAtualController;
import Model.Campanha;
import Model.ConnectPostgre;
import Model.Lider;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class CampanhaDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();

    public static void start(){
        String sql = "select * from Campanha limit 1";

        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {

                String nome = resultado.getString("nomeCampanha");
                String descricao = resultado.getString("descricao");

                Campanha campanha = new Campanha("", "");
                CampanhaAtualController.setCampanhaAtual(campanha);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista!");
            e.printStackTrace();
        }
    }
    public static ArrayList<Campanha> Listar(){
        ArrayList<Campanha> campanhas = new ArrayList<>();
        String sql = "select * from Campanha";

        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {
                String nome = resultado.getString("nomeCampanha");
                String descricao = resultado.getString("descricao");

                Campanha campanha = new Campanha(nome, descricao);
                campanhas.add(campanha);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista!");
            e.printStackTrace();
        }

        return campanhas;
    }

    public static void Inserir(Campanha campanha){
        String sql = "insert into Campanha (nomeCampanha, descricao)" +
                " VALUES" +
                "(?,?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, campanha.getNome());
            ps.setString(2, campanha.getDescricao());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Seja Bem-vindo ao mundo de D&D!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }
    }

    public static void Atualizar(Campanha campanha){
        String sql = "UPDATE Campanha SET descricao = ?" +
                " WHERE nomeCampanha = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, campanha.getDescricao());
            ps.setString(2, campanha.getNome());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            e.printStackTrace();
        }
    }

}
