package Model;

public class BonusTalento {
    private String nomeBonus;
    private String descricao;

    public BonusTalento() {
    }

    public BonusTalento(String nomeBonus, String descricao) {
        this.nomeBonus = nomeBonus;
        this.descricao = descricao;
    }

    public String getNomeBonus() {
        return nomeBonus;
    }

    public void setNomeBonus(String nomeBonus) {
        this.nomeBonus = nomeBonus;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
