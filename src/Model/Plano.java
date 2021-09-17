package Model;

public class Plano {
    private String nomePlano;
    private String descricao;
    private String corCortina;
    private String corPoco;

    public Plano() {
    }

    public Plano(String nomePlano, String descricao, String corCortina, String corPoco) {
        this.nomePlano = nomePlano;
        this.descricao = descricao;
        this.corCortina = corCortina;
        this.corPoco = corPoco;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCorCortina() {
        return corCortina;
    }

    public void setCorCortina(String corCortina) {
        this.corCortina = corCortina;
    }

    public String getCorPoco() {
        return corPoco;
    }

    public void setCorPoco(String corPoco) {
        this.corPoco = corPoco;
    }
}
