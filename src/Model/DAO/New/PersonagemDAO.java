package Model.DAO.New;

import Model.ConnectPostgre;
import Model.Personagem.Personagem;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class PersonagemDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();

    public static ArrayList<Personagem> Listar(){
        ArrayList<Personagem> personagens = new ArrayList<>();
        String sql = "select * from Personagem";

        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {

                int codigoAparencia = resultado.getInt("codigoAparencia");
                int codigoPersonagem = resultado.getInt("codigoPersonagem");
                String nomeJogador = resultado.getString("nomeJogador");
                String nomeCampanha = resultado.getString("nomeCampanha");
                String personagemSubRaca = resultado.getString("personagemSubRaca");
                String personagemClasse = resultado.getString("personagemClasse");
                int deus = resultado.getInt("codigodeus");
                String arquetipo = resultado.getString("arquetipo");
                String nomeAntecedente = resultado.getString("nomeAntecedente");
                String tendencia = resultado.getString("tendencia");
                int percepcaoPassiva = resultado.getInt("percepcaoPassiva");
                int numeroInspiracao = resultado.getInt("numeroInspiracao");
                int pontosVidaAtual = resultado.getInt("pontosVidaAtual");
                int pontosVidaTotal = resultado.getInt("pontosVidaTotal");
                int pontosExperiencia = resultado.getInt("pontosExperiencia");
                int capacidadeCarga = resultado.getInt("capacidadeCarga");
                int cobre = resultado.getInt("cobre");
                int prata = resultado.getInt("prata");
                int ouro = resultado.getInt("ouro");
                int platina = resultado.getInt("platina");
                int electro = resultado.getInt("electro");
                int classeArmadura = resultado.getInt("classeArmadura");
                float deslocamento = resultado.getFloat("deslocamento");
                String caracteristicaAdicional = resultado.getString("caracteristicaAdicional");
                String vinculo = resultado.getString("vinculo");
                String defeito = resultado.getString("defeito");
                String ideal = resultado.getString("ideal");
                String tracoPersonalidade = resultado.getString("tracoPersonalidade");
                int carisma = listarHabilidade(codigoPersonagem, "Carisma");
                int constituicao = listarHabilidade(codigoPersonagem, "Constituição");
                int forca = listarHabilidade(codigoPersonagem, "Força");
                int destreza = listarHabilidade(codigoPersonagem, "Destreza");
                int sabedoria = listarHabilidade(codigoPersonagem, "Sabedoria");
                int inteligencia = listarHabilidade(codigoPersonagem, "Inteligência");
                                String nomePersonagem = "";
                float altura = 0;
                float peso = 0;
                String corOlhos = "";
                int idade = 0;
                String corPele = "";
                String corCabelo = "";

                Personagem personagem = new Personagem(codigoAparencia, nomePersonagem, altura, peso, corOlhos, idade, corPele,
                        corCabelo, codigoPersonagem, nomeJogador, nomeCampanha, personagemSubRaca, personagemClasse, deus, arquetipo,
                        nomeAntecedente, tendencia, percepcaoPassiva, numeroInspiracao, pontosVidaAtual, pontosVidaTotal, pontosExperiencia,
                        capacidadeCarga, cobre, prata, ouro, platina, electro, classeArmadura, deslocamento, caracteristicaAdicional,
                        vinculo, defeito, ideal, tracoPersonalidade, carisma, constituicao, forca, destreza, sabedoria, inteligencia);
                personagens.add(personagem);

            }


            for(int i = 0; i < personagens.size(); i++){
                String sqlAparencia = "select * from Aparencia where codigoAparencia = " + personagens.get(i).getCodigoAparencia();

                Statement declaracaoAparencia = con.createStatement();
                ResultSet resultadoAparencia = declaracao.executeQuery(sqlAparencia);

                while(resultadoAparencia.next()){
                    personagens.get(i).setNomePersonagem(resultadoAparencia.getString("nomePersonagem"));
                    personagens.get(i).setAltura(resultadoAparencia.getFloat("altura"));
                    personagens.get(i).setPeso(resultadoAparencia.getFloat("peso"));
                    personagens.get(i).setCorOlhos(resultadoAparencia.getString("corOlhos"));
                    personagens.get(i).setIdade(resultadoAparencia.getInt("idade"));
                    personagens.get(i).setCorPele(resultadoAparencia.getString("corPele"));
                    personagens.get(i).setCorCabelo( resultadoAparencia.getString("corCabelo"));
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista!");
            e.printStackTrace();
        }

        return personagens;
    }

    public static void Inserir(Personagem personagem){
        String sql = "insert into Personagem (nomeJogador, nomeCampanha, personagemSubRaca, personagemClasse, codigoDeus, codigoAparencia, arquetipo, nomeAntecedente, " +
                "tendencia, percepcaoPassiva, numeroInspiracao, pontosVidaAtual, pontosVidaTotal, pontosExperiencia, capacidadeCarga, cobre, prata, ouro, platina" +
                ", electro, classeArmadura, deslocamento, caracteristicaAdicional, vinculo, defeito, ideal, tracoPersonalidade)" +
                "VALUES" +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        InserirAparencia(personagem.getNomePersonagem(), personagem.getAltura(), personagem.getPeso(), personagem.getCorOlhos(), personagem.getIdade(), personagem.getCorPele(), personagem.getCorCabelo());

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, personagem.getNomeJogador());
            ps.setString(2, personagem.getNomeCampanha());
            ps.setString(3, personagem.getPersonagemSubRaca());
            ps.setString(4, personagem.getPersonagemClasse());
            ps.setInt(5, personagem.getDeus());
            ps.setInt(6, GetCodigoAparencia());
            ps.setString(7, personagem.getArquetipo());
            ps.setString(8, personagem.getNomeAntecedente());
            ps.setString(9, personagem.getTendencia());
            ps.setInt(10, personagem.getPercepcaoPassiva());
            ps.setInt(11, personagem.getNumeroInspiracao());
            ps.setInt(12, personagem.getPontosVidaAtual());
            ps.setInt(13, personagem.getPontosVidaTotal());
            ps.setInt(14, personagem.getPontosExperiencia());
            ps.setInt(15, personagem.getCapacidadeCarga());
            ps.setInt(16, personagem.getCobre());
            ps.setInt(17, personagem.getPrata());
            ps.setInt(18, personagem.getOuro());
            ps.setInt(19, personagem.getPlatina());
            ps.setInt(20, personagem.getElectro());
            ps.setInt(21, personagem.getClasseArmadura());
            ps.setFloat(22, personagem.getDeslocamento());
            ps.setString(23, personagem.getCaracteristicaAdicional());
            ps.setString(24, personagem.getVinculo());
            ps.setString(25, personagem.getDefeito());
            ps.setString(26, personagem.getIdeal());
            ps.setString(27, personagem.getTracoPersonalidade());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Personagem Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Personagem!");
            e.printStackTrace();
        }

        personagem.setCodigoPersonagem(GetCodigoPersonagem());
        inserirHabilidade(personagem, "Carisma", personagem.getCarisma());
        inserirHabilidade(personagem, "Constituição", personagem.getConstituicao());
        inserirHabilidade(personagem, "Força", personagem.getForca());
        inserirHabilidade(personagem, "Destreza", personagem.getDestreza());
        inserirHabilidade(personagem, "Sabedoria", personagem.getSabedoria());
        inserirHabilidade(personagem, "Inteligência", personagem.getInteligencia());
    }

    public static void Atualizar(Personagem personagem){
        String sql = "update personagem set nomeJogador = ?, nomeCampanha = ?, personagemSubRaca = ?, personagemClasse = ?, codigoDeus = ?, codigoAparencia = ?, arquetipo = ?, nomeAntecedente = ?, " +
                "tendencia = ?, percepcaoPassiva = ?, numeroInspiracao = ?, pontosVidaAtual = ?, pontosVidaTotal = ?, pontosExperiencia = ?, capacidadeCarga = ?, cobre = ?, prata = ?, ouro = ?, platina = ?, " +
                "electro = ?, classeArmadura = ?, deslocamento = ?, caracteristicaAdicional = ?, vinculo = ?, defeito = ?, ideal = ?, tracoPersonalidade  = ?" +
                " where codigoPersonagem = ?";

        
        AtualizarAparencia(personagem.getNomePersonagem(), personagem.getAltura(), personagem.getPeso(), personagem.getCorOlhos(), personagem.getIdade(), personagem.getCorPele(), personagem.getCorCabelo(), personagem.getCodigoAparencia());
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, personagem.getNomeJogador());
            ps.setString(2, personagem.getNomeCampanha());
            ps.setString(3, personagem.getPersonagemSubRaca());
            ps.setString(4, personagem.getPersonagemClasse());
            ps.setInt(5, personagem.getDeus());
            ps.setInt(6, GetCodigoAparencia());
            ps.setString(7, personagem.getArquetipo());
            ps.setString(8, personagem.getNomeAntecedente());
            ps.setString(9, personagem.getTendencia());
            ps.setInt(10, personagem.getPercepcaoPassiva());
            ps.setInt(11, personagem.getNumeroInspiracao());
            ps.setInt(12, personagem.getPontosVidaAtual());
            ps.setInt(13, personagem.getPontosVidaTotal());
            ps.setInt(14, personagem.getPontosExperiencia());
            ps.setInt(15, personagem.getCapacidadeCarga());
            ps.setInt(16, personagem.getCobre());
            ps.setInt(17, personagem.getPrata());
            ps.setInt(18, personagem.getOuro());
            ps.setInt(19, personagem.getPlatina());
            ps.setInt(20, personagem.getElectro());
            ps.setInt(21, personagem.getClasseArmadura());
            ps.setFloat(22, personagem.getDeslocamento());
            ps.setString(23, personagem.getCaracteristicaAdicional());
            ps.setString(24, personagem.getVinculo());
            ps.setString(25, personagem.getDefeito());
            ps.setString(26, personagem.getIdeal());
            ps.setString(27, personagem.getTracoPersonalidade());
            ps.setInt(28, personagem.getCodigoPersonagem());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Personagem Atualizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar Personagem!");
            e.printStackTrace();
        }

        AtualizarHabilidade(personagem, "Carisma", personagem.getCarisma());
        AtualizarHabilidade(personagem, "Constituição", personagem.getConstituicao());
        AtualizarHabilidade(personagem, "Força", personagem.getForca());
        AtualizarHabilidade(personagem, "Destreza", personagem.getDestreza());
        AtualizarHabilidade(personagem, "Sabedoria", personagem.getSabedoria());
        AtualizarHabilidade(personagem, "Inteligência", personagem.getInteligencia());
    }

    public static void Remover(Personagem personagem){
        String sql = "delete from personagem where codigoPersonagem = ?";
        RemoverItens(personagem);
        RemoverPericias(personagem);
        RemoverMagias(personagem);
        RemoverTalentos(personagem);
        removerHabilidade(personagem);

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Personagem Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Personagem!");
            e.printStackTrace();
        }

        RemoverAparencia(personagem);
    }

    public static void InserirAparencia(String nomePersonagem, float altura, float peso, String corOlhos, int idade,
                                        String corPele, String corCabelo){
        String sql = "insert into Aparencia (nomePersonagem, altura, peso, corOlhos, idade, corPele, corCabelo)" +
                "VALUES" +
                "(?,?,?,?,?,?,?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nomePersonagem);
            ps.setFloat(2, altura);
            ps.setFloat(3, peso);
            ps.setString(4, corOlhos);
            ps.setInt(5, idade);
            ps.setString(6, corPele);
            ps.setString(7, corCabelo);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            e.printStackTrace();
        }

    }

    public static void AtualizarAparencia(String nomePersonagem, float altura, float peso, String corOlhos, int idade,
                                        String corPele, String corCabelo, int codigoAparencia){
        String sql = "update Aparencia set nomePersonagem = ?, altura = ?, peso = ?, corOlhos = ?, idade = ?, corPele = ?, corCabelo = ? " +
                " where codigoAparencia = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nomePersonagem);
            ps.setFloat(2, altura);
            ps.setFloat(3, peso);
            ps.setString(4, corOlhos);
            ps.setInt(5, idade);
            ps.setString(6, corPele);
            ps.setString(7, corCabelo);
            ps.setInt(8, codigoAparencia);

            ps.executeUpdate();

            System.out.println("Atualizado aparencia com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar aparencia!");
            e.printStackTrace();
        }

    }

    public static void RemoverAparencia(Personagem personagem) {
        String sql = "delete from Aparencia where codigoAparencia = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoAparencia());

            ps.executeUpdate();
            System.out.println("Excluído aparencia com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir aparencia!");
            e.printStackTrace();
        }
    }

    public static int GetCodigoAparencia(){
        String sql = "select max(codigoAparencia) as codigoAparencia from Aparencia";
        int codigo = 0;
        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()){
                codigo = resultado.getInt("codigoAparencia");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return codigo;
    }

    public static int GetCodigoPersonagem(){
        String sql = "select max(codigoPersonagem) as codigoPersonagem from personagem";
        int codigo = 0;
        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()){
                codigo = resultado.getInt("codigoPersonagem");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return codigo;
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

    public static void AtualizarItem(Personagem personagem, String nomeItem, int quantidade, boolean equipado){
        String sql = "update PersonagemItem set quantidade = ?, equipado = ?" +
                " where codigoPersonagem = ? and nomeItem = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, quantidade);
            ps.setBoolean(2, equipado);
            ps.setInt(3, personagem.getCodigoPersonagem());
            ps.setString(4, nomeItem);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
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

    public static void RemoverItens(Personagem personagem){
        String sql = "delete from PersonagemItem where codigoPersonagem = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());

            ps.executeUpdate();

            System.out.println("Item Excluído com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir item!");
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

    public static void RemoverPericias(Personagem personagem){
        String sql = "delete from PersonagemPericia where codigoPersonagem = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());

            ps.executeUpdate();

            System.out.println("Pericias Excluído com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir pericias!");
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

    public static void RemoverMagias(Personagem personagem){
        String sql = "delete from PersonagemMagia where codigoPersonagem = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());

            ps.executeUpdate();

            System.out.println("Magias Excluído com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir magias!");
            e.printStackTrace();
        }
    }

    public static void InserirTalento(Personagem personagem, String nomeTalento){
        String sql = "insert into PersonagemTalento (codigoPersonagem, nomeTalento)" +
                " VALUES" +
                "(?, ?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomeTalento);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }
    }

    public static void RemoverTalento(Personagem personagem, String nomeTalento){
        String sql = "delete from PersonagemTalento where codigoPersonagem = ? and nomeTalento = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomeTalento);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }

    public static void RemoverTalentos(Personagem personagem){
        String sql = "delete from PersonagemTalento where codigoPersonagem = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());

            ps.executeUpdate();

            System.out.println("Talentos Excluído com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir talentos!");
            e.printStackTrace();
        }
    }


    public static int listarHabilidade(int personagem, String nomeHabilidade){
        String sql = "select valor from PersonagemHabilidade where codigoPersonagem = " + personagem + "and nomeHabilidade = '" + nomeHabilidade + "';";
        int habilidade = 0;
        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {
                habilidade = resultado.getInt("valor");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista!");
            e.printStackTrace();
        }

        return habilidade;
    }

    public static void inserirHabilidade(Personagem personagem, String nomeHabilidade, int valor){
        String sql = "insert into PersonagemHabilidade (codigoPersonagem, nomeHabilidade, valor)" +
                " VALUES" +
                "(?, ?, ?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomeHabilidade);
            ps.setInt(3, valor);

            ps.executeUpdate();

            System.out.println("Habilidade Inserida com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir habilidade!");
            e.printStackTrace();
        }
    }

    public static void AtualizarHabilidade(Personagem personagem, String nomeHabilidade, int valor){
        String sql = "update PersonagemHabilidade set valor = ?" +
                " where codigoPersonagem = ? and nomeHabilidade = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, valor);
            ps.setInt(2, personagem.getCodigoPersonagem());
            ps.setString(3, nomeHabilidade);

            ps.executeUpdate();

            System.out.println("habilidade Atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar habilidade!");
            e.printStackTrace();
        }
    }

    public static void removerHabilidade(Personagem personagem){
        String sql = "delete from PersonagemHabilidade where codigoPersonagem = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());

            ps.executeUpdate();

            System.out.println("habilidades Excluído com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir habilidades!");
            e.printStackTrace();
        }

    }


    public static ArrayList<String> ListAntecedente(){
        ArrayList<String> strings = new ArrayList<>();
        String sql = "select nomeAntecedente from Antecedente;";

        try{
            Statement declaracao = con.createStatement();
            ResultSet rs = declaracao.executeQuery(sql);

            while(rs.next()){
                String nome = rs.getString("nomeAntecedente");
                strings.add(nome);
            }

        } catch(SQLException e){
            System.out.println("Error");
        }
        return strings;
    }
}
