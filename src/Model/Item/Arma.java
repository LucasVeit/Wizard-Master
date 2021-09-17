package Model.Item;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Arma {
    private String tipo;
    private String dano;
    private ArrayList<PropriedadeArma> propriedadeArma;

    public Arma() {
    }

    public Arma(String tipo, String dano, ArrayList<PropriedadeArma> propriedadeArma) {
        this.tipo = tipo;
        this.dano = dano;
        this.propriedadeArma = propriedadeArma;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDano() {
        return dano;
    }

    public void setDano(String dano) {
        this.dano = dano;
    }

    public ArrayList<PropriedadeArma> getPropriedadeArma() {
        return propriedadeArma;
    }

    public void setPropriedadeArma(ArrayList<PropriedadeArma> propriedadeArma) {
        this.propriedadeArma = propriedadeArma;
    }
}
