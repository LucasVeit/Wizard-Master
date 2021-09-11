package Model.Item;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Arma {
    private Item arma;
    private SimpleStringProperty tipo;
    private SimpleStringProperty dano;
    private ArrayList<PropriedadeArma> propriedadeArma;

    public Arma() {
    }

    public Arma(Item arma, SimpleStringProperty tipo, SimpleStringProperty dano, ArrayList<PropriedadeArma> propriedadeArma) {
        this.arma = arma;
        this.tipo = tipo;
        this.dano = dano;
        this.propriedadeArma = propriedadeArma;
    }

    public Item getArma() {
        return arma;
    }

    public void setArma(Item arma) {
        this.arma = arma;
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

    public String getDano() {
        return dano.get();
    }

    public SimpleStringProperty danoProperty() {
        return dano;
    }

    public void setDano(String dano) {
        this.dano.set(dano);
    }

    public ArrayList<PropriedadeArma> getPropriedadeArma() {
        return propriedadeArma;
    }

    public void setPropriedadeArma(ArrayList<PropriedadeArma> propriedadeArma) {
        this.propriedadeArma = propriedadeArma;
    }

}
