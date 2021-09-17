package Model;

public class Lider {
    private int codigoLider;
    private String nomeLider;
    private String descricao;
    private String nomeCampanha;

    public Lider() {
    }

    public Lider(int codigoLider, String nomeLider, String descricao, String nomeCampanha) {
        this.codigoLider = codigoLider;
        this.nomeLider = nomeLider;
        this.descricao = descricao;
        this.nomeCampanha = nomeCampanha;
    }

    public int getCodigoLider() {
        return codigoLider;
    }

    public void setCodigoLider(int codigoLider) {
        this.codigoLider = codigoLider;
    }

    public String getNomeLider() {
        return nomeLider;
    }

    public void setNomeLider(String nomeLider) {
        this.nomeLider = nomeLider;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeCampanha() {
        return nomeCampanha;
    }

    public void setNomeCampanha(String nomeCampanha) {
        this.nomeCampanha = nomeCampanha;
    }
}
