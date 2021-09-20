package Model;

public class ListaLideres {
    private String nome;
    private int populacao;

    public ListaLideres() {
    }

    public ListaLideres(String nome, int populacao) {
        this.nome = nome;
        this.populacao = populacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }
}
