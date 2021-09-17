package Model.Item;


public class PropriedadeArma {
    private String nome;
    private String descricaoPropriedade;
    private String descricaoCaracteristica;

    public PropriedadeArma() {
    }

    public PropriedadeArma(String nome, String descricaoPropriedade, String descricaoCaracteristica) {
        this.nome = nome;
        this.descricaoPropriedade = descricaoPropriedade;
        this.descricaoCaracteristica = descricaoCaracteristica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoPropriedade() {
        return descricaoPropriedade;
    }

    public void setDescricaoPropriedade(String descricaoPropriedade) {
        this.descricaoPropriedade = descricaoPropriedade;
    }

    public String getDescricaoCaracteristica() {
        return descricaoCaracteristica;
    }

    public void setDescricaoCaracteristica(String descricaoCaracteristica) {
        this.descricaoCaracteristica = descricaoCaracteristica;
    }
}
