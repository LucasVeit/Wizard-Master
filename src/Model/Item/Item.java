package Model.Item;

public class Item {
    private String nomeItem;
    private String descricao;
    private String categoria;
    private int custo;
    private String moeda;
    private float peso;

    public Item() {
    }

    public Item(String nomeItem, String descricao, String categoria, int custo, String moeda, float peso) {
        this.nomeItem = nomeItem;
        this.descricao = descricao;
        this.categoria = categoria;
        this.custo = custo;
        this.moeda = moeda;
        this.peso = peso;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
