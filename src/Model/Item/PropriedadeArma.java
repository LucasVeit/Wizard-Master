package Model.Item;

import javafx.beans.property.SimpleStringProperty;

public class PropriedadeArma {
    private SimpleStringProperty nome;
    private SimpleStringProperty descricaoPropriedade;
    private SimpleStringProperty descricaoCaracteristica;

    public PropriedadeArma() {
    }

    public PropriedadeArma(SimpleStringProperty nome, SimpleStringProperty descricaoPropriedade, SimpleStringProperty descricaoCaracteristica) {
        this.nome = nome;
        this.descricaoPropriedade = descricaoPropriedade;
        this.descricaoCaracteristica = descricaoCaracteristica;
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getDescricaoPropriedade() {
        return descricaoPropriedade.get();
    }

    public SimpleStringProperty descricaoPropriedadeProperty() {
        return descricaoPropriedade;
    }

    public void setDescricaoPropriedade(String descricaoPropriedade) {
        this.descricaoPropriedade.set(descricaoPropriedade);
    }

    public String getDescricaoCaracteristica() {
        return descricaoCaracteristica.get();
    }

    public SimpleStringProperty descricaoCaracteristicaProperty() {
        return descricaoCaracteristica;
    }

    public void setDescricaoCaracteristica(String descricaoCaracteristica) {
        this.descricaoCaracteristica.set(descricaoCaracteristica);
    }
}
