package Model;

public class Intervalo {
    private String nome;
    private float nivel;

    public Intervalo() {
    }

    public Intervalo(String nome, float nivel) {
        this.nome = nome;
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNivel() {
        return nivel;
    }

    public void setNivel(float nivel) {
        this.nivel = nivel;
    }
}
