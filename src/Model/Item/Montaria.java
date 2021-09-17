package Model.Item;


public class Montaria {
    private float deslocamento;
    private float capacidadeCarga;

    public Montaria() {
    }

    public Montaria(float deslocamento, float capacidadeCarga) {
        this.deslocamento = deslocamento;
        this.capacidadeCarga = capacidadeCarga;
    }

    public float getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(float deslocamento) {
        this.deslocamento = deslocamento;
    }

    public float getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(float capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }
}

