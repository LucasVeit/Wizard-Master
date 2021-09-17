package Model;

public class Panteao {
    private String nomeCampanha;
    private int codigoDeus;

    public Panteao() {
    }

    public Panteao(String nomeCampanha, int codigoDeus) {
        this.nomeCampanha = nomeCampanha;
        this.codigoDeus = codigoDeus;
    }

    public String getNomeCampanha() {
        return nomeCampanha;
    }

    public void setNomeCampanha(String nomeCampanha) {
        this.nomeCampanha = nomeCampanha;
    }

    public int getCodigoDeus() {
        return codigoDeus;
    }

    public void setCodigoDeus(int codigoDeus) {
        this.codigoDeus = codigoDeus;
    }
}
