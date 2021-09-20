package Model;

public class Desafios {
    private String jogador;
    private String monstro;
    private String habilidade;

    public Desafios() {
    }

    public Desafios(String jogador, String monstro, String habilidade) {
        this.jogador = jogador;
        this.monstro = monstro;
        this.habilidade = habilidade;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public String getMonstro() {
        return monstro;
    }

    public void setMonstro(String monstro) {
        this.monstro = monstro;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }
}
