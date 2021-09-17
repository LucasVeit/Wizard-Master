package Model;

public class Deus {
    private int codigoDeus;
    private String nomeDeus;
    private String mitologia;
    private String dominio;
    private String tendencia;
    private String simbolo;

    public Deus() {
    }

    public Deus(int codigoDeus, String nomeDeus, String mitologia, String dominio, String tendencia, String simbolo) {
        this.codigoDeus = codigoDeus;
        this.nomeDeus = nomeDeus;
        this.mitologia = mitologia;
        this.dominio = dominio;
        this.tendencia = tendencia;
        this.simbolo = simbolo;
    }

    public int getCodigoDeus() {
        return codigoDeus;
    }

    public void setCodigoDeus(int codigoDeus) {
        this.codigoDeus = codigoDeus;
    }

    public String getNomeDeus() {
        return nomeDeus;
    }

    public void setNomeDeus(String nomeDeus) {
        this.nomeDeus = nomeDeus;
    }

    public String getMitologia() {
        return mitologia;
    }

    public void setMitologia(String mitologia) {
        this.mitologia = mitologia;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getTendencia() {
        return tendencia;
    }

    public void setTendencia(String tendencia) {
        this.tendencia = tendencia;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
