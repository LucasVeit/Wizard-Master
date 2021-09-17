package Model;

public class Regra {
    private String nomeRegra;
    private String descricao;

    public Regra() {
    }

    public Regra(String nomeRegra, String descricao) {
        this.nomeRegra = nomeRegra;
        this.descricao = descricao;
    }

    public String getNomeRegra() {
        return nomeRegra;
    }

    public void setNomeRegra(String nomeRegra) {
        this.nomeRegra = nomeRegra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
