package Model.DAO;

import Controller.CampanhaAtualController;
import Model.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueriesDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();


    public static ArrayList<ListaLideres> Lideres(){
        ArrayList<ListaLideres> lista = new ArrayList<>();
        String sql = "select foo5.nomeLider as \"Lider\", sum(populacao) as \"Populacao\" from (select nomeLider, populacao from Lider join (select codigoLider, populacao from LiderCidade join (select codigoCidade, populacao from Cidade ) as foo on LiderCidade.codigoCidade = foo.codigoCidade) as foo2 on foo2.codigoLider = Lider.codigoLider union select nomeLider, populacao from Lider join ( select codigoLider, populacao from LiderFaccao join ( select codigoFaccao, populacao from Faccao) as foo3 on LiderFaccao.codigoFaccao = foo3.codigoFaccao ) as foo4 on foo4.codigoLider = Lider.codigoLider) as foo5 group by \"Lider\";";

        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {

                String nome = resultado.getString("Lider");
                int populacao = resultado.getInt("Populacao");

                ListaLideres lider = new ListaLideres(nome, populacao);
                lista.add(lider);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista!");
            e.printStackTrace();
        }

        return lista;
    }

    public static ArrayList<Desafios> Desafios(){
        ArrayList<Desafios> lista = new ArrayList<>();
        String sql = "select foo.nomeJogador as \"Jogador\", foo2.nomeMonstro as \"Mais forte que\", foo2.nomeHabilidade as \"Em\"  " +
                "from (select codigoPersonagem, nomeJogador  " +
                " from Personagem) as foo  " +
                "join  " +
                " (select PersonagemHabilidade.codigoPersonagem, MonstroHabilidade.nomeMonstro, PersonagemHabilidade.nomeHabilidade  " +
                " from PersonagemHabilidade join MonstroHabilidade  " +
                " on PersonagemHabilidade.nomeHabilidade = MonstroHabilidade.nomeHabilidade and  " +
                " PersonagemHabilidade.valor > MonstroHabilidade.valor) as foo2  " +
                "on foo.codigoPersonagem = foo2.codigoPersonagem  " +
                "order by \"Jogador\", \"Mais forte que\", \"Em\";  ";

        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {

                String jogador = resultado.getString("Jogador");
                String monstro = resultado.getString("Mais forte que");
                String habilidade = resultado.getString("Em");

                Desafios desafio = new Desafios(jogador, monstro, habilidade);
                lista.add(desafio);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista!");
            e.printStackTrace();
        }

        return lista;

    }

    public static ArrayList<Relatorio> Relatorio(){
        ArrayList<Relatorio> lista = new ArrayList<>();
        String sql = "select foo2.nomeCampanha, descricao, foo2.count as \"Qtde. de cidades\", foo2.min as \"Cidade com menor população\",\n" +
                "foo2.max as \"Cidade com maior população\", round(foo2.avg,2) as \"Média de população das cidades\", foo3.count as \"Qtde. de Líderes\"\n" +
                "from Campanha join (\n" +
                "\tselect nomeCampanha, count(nomeCidade), min(populacao), max(populacao), avg(populacao)\n" +
                "\tfrom Cidade\t\n" +
                "\tgroup by nomeCampanha\n" +
                ") as foo2 on foo2.nomeCampanha = Campanha.nomeCampanha\n" +
                "join(\n" +
                "\tselect nomeCampanha, count(nomeLider)\n" +
                "\tfrom Lider\n" +
                "\tgroup by nomeCampanha\n" +
                ") as foo3 on foo3.nomeCampanha = Campanha.nomeCampanha;";

        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {

                String nomeCampanha = resultado.getString("nomecampanha");
                String descricao = resultado.getString("descricao");
                int cidades = resultado.getInt("Qtde. de cidades");
                int cidadeMenorPopulacao = resultado.getInt("Cidade com menor população");
                int cidadeMaiorPopulacao = resultado.getInt("Cidade com maior população");
                float mediaPopulacao = resultado.getFloat("Média de população das cidades");
                int numeroLideres = resultado.getInt("Qtde. de Líderes");

                Relatorio relatorio = new Relatorio(nomeCampanha, descricao, cidades, cidadeMenorPopulacao, cidadeMaiorPopulacao, mediaPopulacao, numeroLideres);
                lista.add(relatorio);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista!");
            e.printStackTrace();
        }

        return lista;
    }

    public static ArrayList<Intervalo> Intervalo(int intervalo){
        ArrayList<Intervalo> lista = new ArrayList<>();
        String sql = "--Seleciona monstros de nivel similar ao nivel total do grupo\n" +
                "select nomeMonstro, nivel\n" +
                "from Monstro\n" +
                "where Monstro.nivel + " + intervalo + " > (\n" +
                "\tselect MAX(nivel) as \"Nivel do grupo\"\n" +
                "\tfrom PontosExperienciaNivel join \n" +
                "\t\t(select SUM(pontosExperiencia)\n" +
                "\t\tfrom Personagem\n" +
                "\t\twhere nomeCampanha = 'Lorin') as foo\n" +
                "\t\ton PontosExperienciaNivel.pontosExperiencia <= foo.sum\n" +
                "\t)\n" +
                "\tand \n" +
                "\tMonstro.nivel - " + intervalo + "  < (\n" +
                "\tselect MAX(nivel) as \"Nivel do grupo\"\n" +
                "\tfrom PontosExperienciaNivel join \n" +
                "\t\t(select SUM(pontosExperiencia)\n" +
                "\t\tfrom Personagem\n" +
                "\t\twhere nomeCampanha = 'Lorin') as foo\n" +
                "\t\ton PontosExperienciaNivel.pontosExperiencia <= foo.sum\n" +
                "\t);";
        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {

                String nome = resultado.getString("nomeMonstro");
                float nivel = resultado.getInt("nivel");

                Intervalo interval = new Intervalo(nome, nivel);
                lista.add(interval);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista!");
            e.printStackTrace();
        }

        return lista;
    }


}
