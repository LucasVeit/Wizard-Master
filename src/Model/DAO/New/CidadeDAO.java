package Model.DAO.New;

import Model.Cidade;
import Model.ConnectPostgre;
import Model.Monstro.CaracteristicaMonstro;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CidadeDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();
    //String sql = null;
    //Statement declaracao;
    //ResultSet resultado;

    public static ArrayList<Cidade> Listar(){
        ArrayList<Cidade> cidades = new ArrayList<>();
        String sql = "select * from Cidade";

        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {
                int codigo = resultado.getInt("codigoCidade");
                String nomeCidade = resultado.getString("nomeCidade");
                String comercio;
                String clima;
                String vegetacao;
                int populacao;
                String formaGoverno;
                String descricao;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista de clientes!");
            e.printStackTrace();
        }

        return cidades;




    }

    public static void Inserir(){

    }

    public static void Atualizar(){

    }

    public static void Remover(){

    }

}
