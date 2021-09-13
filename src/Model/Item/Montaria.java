package Model.Item;

import javafx.beans.property.SimpleFloatProperty;

public class Montaria {
    private Item montaria;
    private SimpleFloatProperty deslocamento;
    private SimpleFloatProperty capacidadeCarga;

    public Montaria() {
    }

    public Montaria(Item montaria, SimpleFloatProperty deslocamento, SimpleFloatProperty capacidadeCarga) {
        this.montaria = montaria;
        this.deslocamento = deslocamento;
        this.capacidadeCarga = capacidadeCarga;
    }

    public Item getMontaria() {
        return montaria;
    }

    public void setMontaria(Item montaria) {
        this.montaria = montaria;
    }

    public float getDeslocamento() {
        return deslocamento.get();
    }

    public SimpleFloatProperty deslocamentoProperty() {
        return deslocamento;
    }

    public void setDeslocamento(float deslocamento) {
        this.deslocamento.set(deslocamento);
    }

    public float getCapacidadeCarga() {
        return capacidadeCarga.get();
    }

    public SimpleFloatProperty capacidadeCargaProperty() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(float capacidadeCarga) {
        this.capacidadeCarga.set(capacidadeCarga);
    }
}

