package Model.Personagem;

public class PersonagemItem {
    private int codigoPersonagem;
    private String nomeItem;
    private int quantidade;
    private boolean equipado;

    public PersonagemItem() {
    }

    public PersonagemItem(int codigoPersonagem, String nomeItem, int quantidade, boolean equipado) {
        this.codigoPersonagem = codigoPersonagem;
        this.nomeItem = nomeItem;
        this.quantidade = quantidade;
        this.equipado = equipado;
    }

    public int getCodigoPersonagem() {
        return codigoPersonagem;
    }

    public void setCodigoPersonagem(int codigoPersonagem) {
        this.codigoPersonagem = codigoPersonagem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isEquipado() {
        return equipado;
    }

    public void setEquipado(boolean equipado) {
        this.equipado = equipado;
    }
}
