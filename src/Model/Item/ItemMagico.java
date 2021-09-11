package Model.Item;

import javafx.beans.property.SimpleStringProperty;

public class ItemMagico {
    private Item itemMagico;
    private SimpleStringProperty tipo;
    private SimpleStringProperty raridade;
    private SimpleStringProperty requisito;

    public ItemMagico() {
    }

    public ItemMagico(Item itemMagico, SimpleStringProperty tipo, SimpleStringProperty raridade, SimpleStringProperty requisito) {
        this.itemMagico = itemMagico;
        this.tipo = tipo;
        this.raridade = raridade;
        this.requisito = requisito;
    }

    public Item getItemMagico() {
        return itemMagico;
    }

    public void setItemMagico(Item itemMagico) {
        this.itemMagico = itemMagico;
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

    public String getRaridade() {
        return raridade.get();
    }

    public SimpleStringProperty raridadeProperty() {
        return raridade;
    }

    public void setRaridade(String raridade) {
        this.raridade.set(raridade);
    }

    public String getRequisito() {
        return requisito.get();
    }

    public SimpleStringProperty requisitoProperty() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito.set(requisito);
    }
}
