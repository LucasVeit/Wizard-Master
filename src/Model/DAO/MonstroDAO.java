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
        sql = "select * from monstro";

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
                 String nivel = resultado.getString("nivel");
                 String pontosExperiencia = resultado.getString("pontosExperiencia");
                 String formaCorporal = resultado.getString("formaCorporal");
                 String tamanho = resultado.getString("tamanho");
                 String descricaoLendaria = resultado.getString("descricaoLendaria");

                 ArrayList<LoreMonstro> lore = ListLore(nomeMonstro);
                 ArrayList<TracoEspecialMonstro> tracoEspecial = ListTraco(nomeMonstro);
                 ArrayList<CaracteristicaMonstro> caracteristica = ListCaracteristica(nomeMonstro);
                 ArrayList<AcaoMonstro> acao = ListAcao(nomeMonstro);
                 ArrayList<AcaoLendariaMonstro> acaoLendaria = listAcaoLendaria(nomeMonstro);

                 Monstro monstro = new Monstro(nomeMonstro, introducao, foto, classeArmadura, pontosVida,
                         tendencia, nivel, pontosExperiencia, formaCorporal, tamanho, descricaoLendaria, lore,
                         tracoEspecial, caracteristica, acao, acaoLendaria);
                 monstros.add(monstro);
            }

        } catch(SQLException e){
            System.out.println("Error");
        }
        
        return monstros;
    }

    public ArrayList<LoreMonstro> ListLore(String nomeMonstro){
        ArrayList<LoreMonstro> lores = new ArrayList<>();
        sql = "select * from Lore where nomeMonstro = \"" + nomeMonstro + "\";";

        try{
            declaracao = con.createStatement();
            resultado = declaracao.executeQuery(sql);

            while(resultado.next()){
                String nome = resultado.getString("nome");
                String descricao = resultado.getString("descricao");

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
        sql = "select * from TracoEspecialMonstro where nomeMonstro = \"" + nomeMonstro + "\";";

        try{
            declaracao = con.createStatement();
            resultado = declaracao.executeQuery(sql);

            while(resultado.next()){
                String nome = resultado.getString("nome");
                String descricao = resultado.getString("descricao");

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
        sql = "select * from CaracteristicaMonstro where nomeMonstro = \"" + nomeMonstro + "\";";

        try{
            declaracao = con.createStatement();
            resultado = declaracao.executeQuery(sql);

            while(resultado.next()){
                String nome = resultado.getString("nome");
                String descricao = resultado.getString("descricao");

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
        sql = "select * from Acao where nomeMonstro = \"" + nomeMonstro + "\";";

        try{
            declaracao = con.createStatement();
            resultado = declaracao.executeQuery(sql);

            while(resultado.next()){
                String nome = resultado.getString("nome");
                String descricao = resultado.getString("descricao");

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
        sql = "select * from AcaoLendaria where nomeMonstro = \"" + nomeMonstro + "\";";

        try{
            declaracao = con.createStatement();
            resultado = declaracao.executeQuery(sql);

            while(resultado.next()){
                String nome = resultado.getString("nome");
                String descricao = resultado.getString("descricao");

                AcaoLendariaMonstro acao = new AcaoLendariaMonstro(nome, descricao);
                acoes.add(acao);
            }

        } catch(SQLException e){
            System.out.println("Error");
        }

        return acoes;

    }
}
