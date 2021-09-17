package Model;

public class Mundo {
    private String nomeCampanha;
    private String nomePlano;

    public Mundo() {
    }

    public Mundo(String nomeCampanha, String nomePlano) {
        this.nomeCampanha = nomeCampanha;
        this.nomePlano = nomePlano;
    }

    public String getNomeCampanha() {
        return nomeCampanha;
    }

    public void setNomeCampanha(String nomeCampanha) {
        this.nomeCampanha = nomeCampanha;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }
}
