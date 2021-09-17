package Model;

public class Cidade {
    private int codigo;
    private String nomeCidade;
    private String nomeCampanha;
    private String comercio;
    private String clima;
    private String vegetacao;
    private int populacao;
    private String formaGoverno;
    private String descricao;

    public Cidade() {
    }

    public Cidade(int codigo, String nomeCidade, String nomeCampanha, String comercio, String clima, String vegetacao, int populacao, String formaGoverno, String descricao) {
        this.codigo = codigo;
        this.nomeCidade = nomeCidade;
        this.nomeCampanha = nomeCampanha;
        this.comercio = comercio;
        this.clima = clima;
        this.vegetacao = vegetacao;
        this.populacao = populacao;
        this.formaGoverno = formaGoverno;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getNomeCampanha() {
        return nomeCampanha;
    }

    public void setNomeCampanha(String nomeCampanha) {
        this.nomeCampanha = nomeCampanha;
    }

    public String getComercio() {
        return comercio;
    }

    public void setComercio(String comercio) {
        this.comercio = comercio;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getVegetacao() {
        return vegetacao;
    }

    public void setVegetacao(String vegetacao) {
        this.vegetacao = vegetacao;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public String getFormaGoverno() {
        return formaGoverno;
    }

    public void setFormaGoverno(String formaGoverno) {
        this.formaGoverno = formaGoverno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
