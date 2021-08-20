package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Magia {
    private SimpleStringProperty nomeMagia;
    private SimpleStringProperty tipo;
    private SimpleIntegerProperty nivel;
    private SimpleStringProperty descricao;
    private SimpleStringProperty duracao;
    private SimpleStringProperty componentes;
    private SimpleStringProperty alcance;
    private SimpleStringProperty tempoConjuracao;

    public Magia(SimpleStringProperty nomeMagia, SimpleStringProperty tipo, SimpleIntegerProperty nivel, SimpleStringProperty descricao, SimpleStringProperty duracao, SimpleStringProperty componentes, SimpleStringProperty alcance, SimpleStringProperty tempoConjuracao) {
        this.nomeMagia = nomeMagia;
        this.tipo = tipo;
        this.nivel = nivel;
        this.descricao = descricao;
        this.duracao = duracao;
        this.componentes = componentes;
        this.alcance = alcance;
        this.tempoConjuracao = tempoConjuracao;
    }

    public String getNomeMagia() {
        return nomeMagia.get();
    }

    public SimpleStringProperty nomeMagiaProperty() {
        return nomeMagia;
    }

    public void setNomeMagia(String nomeMagia) {
        this.nomeMagia.set(nomeMagia);
    }

    public String getTipo() {
        return tipo.get();
    }

    public SimpleStringProperty tipoProperty() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }

    public int getNivel() {
        return nivel.get();
    }

    public SimpleIntegerProperty nivelProperty() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel.set(nivel);
    }

    public String getDescricao() {
        return descricao.get();
    }

    public SimpleStringProperty descricaoProperty() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }

    public String getDuracao() {
        return duracao.get();
    }

    public SimpleStringProperty duracaoProperty() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao.set(duracao);
    }

    public String getComponentes() {
        return componentes.get();
    }

    public SimpleStringProperty componentesProperty() {
        return componentes;
    }

    public void setComponentes(String componentes) {
        this.componentes.set(componentes);
    }

    public String getAlcance() {
        return alcance.get();
    }

    public SimpleStringProperty alcanceProperty() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance.set(alcance);
    }

    public String getTempoConjuracao() {
        return tempoConjuracao.get();
    }

    public SimpleStringProperty tempoConjuracaoProperty() {
        return tempoConjuracao;
    }

    public void setTempoConjuracao(String tempoConjuracao) {
        this.tempoConjuracao.set(tempoConjuracao);
    }
}