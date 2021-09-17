package Model;

import javafx.beans.property.SimpleStringProperty;

public class criarCidade {

    private String nomeCidade;
    private String comercio;
    private String clima;
    private String vegetacao;
    private String populacao;
    private String formaGoverno;
    private String descricao;

    public criarCidade(String nomeCidade, String comercio, String clima, String vegetacao, String populacao, String formaGoverno, String descricao) {
        this.nomeCidade = nomeCidade;
        this.comercio = comercio;
        this.clima = clima;
        this.vegetacao = vegetacao;
        this.populacao = populacao;
        this.formaGoverno = formaGoverno;
        this.descricao = descricao;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
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

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
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
