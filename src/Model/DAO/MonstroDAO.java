package Model.DAO;

import Model.ConnectPostgre;
import Model.Monstro.*;

import java.sql.*;
import java.util.ArrayList;


public class MonstroDAO {
    Connection con = ConnectPostgre.ConnectDatabase();
    String sql = null;
    Statement declaracao;
    ResultSet resultado;

    public ArrayList<Monstro> List(){
        ArrayList<Monstro> monstros = new ArrayList<>();
        sql = "select * from Monstro";

        try{
            declaracao = con.createStatement();
            resultado = declaracao.executeQuery(sql);
            
            while(resultado.next()){
                String nomeMonstro = resultado.getString("nomeMonstro");
                String introducao = resultado.getString("introducao");
                String foto = resultado.getString("foto");
                String classeArmadura = resultado.getString("classeArmadura");
                String pontosVida = resultado.getString("pontosVida");
                String tendencia = resultado.getString("tendencia");
                float nivel = resultado.getFloat("nivel");
                int pontosExperiencia = resultado.getInt("pontosExperiencia");
                String formaCorporal = resultado.getString("formaCorporal");
                String tamanho = resultado.getString("tamanho");
                String descricaoLendaria = resultado.getString("descricaoAcaoLendaria");

                ArrayList<LoreMonstro> lore = ListLore(nomeMonstro);
                ArrayList<TracoEspecialMonstro> tracoEspecial = ListTraco(nomeMonstro);
                ArrayList<CaracteristicaMonstro> caracteristica = ListCaracteristica(nomeMonstro);
                ArrayList<AcaoMonstro> acao = ListAcao(nomeMonstro);
                ArrayList<AcaoLendariaMonstro> acaoLendaria = listAcaoLendaria(nomeMonstro);
                int constituicao = getHabilidade("Constituição", nomeMonstro);
                int carisma = getHabilidade("Carisma", nomeMonstro);
                int destreza = getHabilidade("Destreza", nomeMonstro);
                int forca = getHabilidade("Força", nomeMonstro);
                int inteligencia = getHabilidade("Inteligência", nomeMonstro);
                int sabedoria = getHabilidade("Sabedoria", nomeMonstro);

                Monstro monstro = new Monstro(nomeMonstro, introducao, foto, classeArmadura, pontosVida,
                         tendencia, nivel, pontosExperiencia, formaCorporal, tamanho, descricaoLendaria, lore,
                         tracoEspecial, caracteristica, acao, acaoLendaria, constituicao, carisma, destreza, forca, inteligencia, sabedoria);
                 monstros.add(monstro);
            }

        } catch(SQLException e){
            System.out.println("Error");
        }
        
        return monstros;
    }

    public int getHabilidade(String habilidade, String nomeMonstro){
        sql = "select * from MonstroHabilidade where nomeMonstro = \'" + nomeMonstro + "\' and nomeHabilidade = \'" + habilidade + "\'";
        int pontosHabilidade = 0;

        try{
            declaracao = con.createStatement();
            ResultSet rs = declaracao.executeQuery(sql);

            while(rs.next()){
                pontosHabilidade  = rs.getInt("valor");

            }

        } catch(SQLException e){
            System.out.println("Error");
        }

        return pontosHabilidade;

    }

    public ArrayList<LoreMonstro> ListLore(String nomeMonstro){
        ArrayList<LoreMonstro> lores = new ArrayList<>();
        sql = "select * from Lore where nomeMonstro = \'" + nomeMonstro + "\';";

        try{
            declaracao = con.createStatement();
            ResultSet rs = declaracao.executeQuery(sql);

            while(rs.next()){
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                LoreMonstro lore = new LoreMonstro(nome, descricao);
                lores.add(lore);
            }

        } catch (SQLException e){
            System.out.println("Error");
        }

        return lores;
    }

    public ArrayList<TracoEspecialMonstro> ListTraco(String nomeMonstro){
        ArrayList<TracoEspecialMonstro> tracosEspeciais = new ArrayList<>();
        sql = "select * from TracoEspecialMonstro where nomeMonstro = \'" + nomeMonstro + "\';";

        try{
            declaracao = con.createStatement();
            ResultSet rs = declaracao.executeQuery(sql);

            while(rs.next()){
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");

                TracoEspecialMonstro tracoEspecial = new TracoEspecialMonstro(nome, descricao);
                tracosEspeciais.add(tracoEspecial);
            }
        } catch(SQLException e){
            System.out.println("Error");
        }

        return tracosEspeciais;
    }

    public ArrayList<CaracteristicaMonstro> ListCaracteristica(String nomeMonstro){
        ArrayList<CaracteristicaMonstro> caracteristicas = new ArrayList<>();
        sql = "select * from CaracteristicaMonstro where nomeMonstro = \'" + nomeMonstro + "\';";

        try{
            declaracao = con.createStatement();
            ResultSet rs = declaracao.executeQuery(sql);

            while(rs.next()){
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");

                CaracteristicaMonstro caracteristica = new CaracteristicaMonstro(nome, descricao);
                caracteristicas.add(caracteristica);
            }

        } catch(SQLException e){
            System.out.println("Error");
        }

        return caracteristicas;

    }

    public ArrayList<AcaoMonstro> ListAcao(String nomeMonstro){
        ArrayList<AcaoMonstro> acoes = new ArrayList<>();
        sql = "select * from Acao where nomeMonstro = \'" + nomeMonstro + "\';";

        try{
            declaracao = con.createStatement();
            ResultSet rs = declaracao.executeQuery(sql);

            while(rs.next()){
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");

                AcaoMonstro acao = new AcaoMonstro(nome, descricao);
                acoes.add(acao);
            }

        } catch(SQLException e){
            System.out.println("Error");
        }

        return acoes;

    }

    public ArrayList<AcaoLendariaMonstro> listAcaoLendaria(String nomeMonstro){
        ArrayList<AcaoLendariaMonstro> acoes = new ArrayList<>();
        sql = "select * from AcaoLendaria where nomeMonstro = \'" + nomeMonstro + "\';";

        try{
            declaracao = con.createStatement();
            ResultSet rs = declaracao.executeQuery(sql);

            while(rs.next()){
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");

                AcaoLendariaMonstro acao = new AcaoLendariaMonstro(nome, descricao);
                acoes.add(acao);
            }

        } catch(SQLException e){
            System.out.println("Error");
        }

        return acoes;

    }
}
