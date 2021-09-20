package Model;

public class Relatorio {
    private String nomeCampanha;
    private String descricao;
    private int cidades;
    private int cidadeMenorPopulacao;
    private int CidadeMaiorPopulacao;
    private float mediaPopulacao;
    private int numeroLideres;

    public Relatorio() {
    }

    public Relatorio(String nomeCampanha, String descricao, int cidades, int cidadeMenorPopulacao, int cidadeMaiorPopulacao, float mediaPopulacao, int numeroLideres) {
        this.nomeCampanha = nomeCampanha;
        this.descricao = descricao;
        this.cidades = cidades;
        this.cidadeMenorPopulacao = cidadeMenorPopulacao;
        CidadeMaiorPopulacao = cidadeMaiorPopulacao;
        this.mediaPopulacao = mediaPopulacao;
        this.numeroLideres = numeroLideres;
    }

    public String getNomeCampanha() {
        return nomeCampanha;
    }

    public void setNomeCampanha(String nomeCampanha) {
        this.nomeCampanha = nomeCampanha;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCidades() {
        return cidades;
    }

    public void setCidades(int cidades) {
        this.cidades = cidades;
    }

    public int getCidadeMenorPopulacao() {
        return cidadeMenorPopulacao;
    }

    public void setCidadeMenorPopulacao(int cidadeMenorPopulacao) {
        this.cidadeMenorPopulacao = cidadeMenorPopulacao;
    }

    public int getCidadeMaiorPopulacao() {
        return CidadeMaiorPopulacao;
    }

    public void setCidadeMaiorPopulacao(int cidadeMaiorPopulacao) {
        CidadeMaiorPopulacao = cidadeMaiorPopulacao;
    }

    public float getMediaPopulacao() {
        return mediaPopulacao;
    }

    public void setMediaPopulacao(float mediaPopulacao) {
        this.mediaPopulacao = mediaPopulacao;
    }

    public int getNumeroLideres() {
        return numeroLideres;
    }

    public void setNumeroLideres(int numeroLideres) {
        this.numeroLideres = numeroLideres;
    }
}
