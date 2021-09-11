package Model.Item;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {
    private SimpleStringProperty nomeItem;
    private SimpleStringProperty descricao;
    private SimpleStringProperty categoria;
    private SimpleIntegerProperty custo;
    private SimpleStringProperty moeda;
    private SimpleFloatProperty peso;

    public Item() {
    }

    public Item(SimpleStringProperty nomeItem, SimpleStringProperty descricao, SimpleStringProperty categoria, SimpleIntegerProperty custo, SimpleStringProperty moeda, SimpleFloatProperty peso) {
        this.nomeItem = nomeItem;
        this.descricao = descricao;
        this.categoria = categoria;
        this.custo = custo;
        this.moeda = moeda;
        this.peso = peso;
    }

    public String getNomeItem() {
        return nomeItem.get();
    }

    public SimpleStringProperty nomeItemProperty() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem.set(nomeItem);
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

    public String getCategoria() {
        return categoria.get();
    }

    public SimpleStringProperty categoriaProperty() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria.set(categoria);
    }

    public int getCusto() {
        return custo.get();
    }

    public SimpleIntegerProperty custoProperty() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo.set(custo);
    }

    public String getMoeda() {
        return moeda.get();
    }

    public SimpleStringProperty moedaProperty() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda.set(moeda);
    }

    public float getPeso() {
        return peso.get();
    }

    public SimpleFloatProperty pesoProperty() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso.set(peso);
    }
}
