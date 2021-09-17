package Model.Item;


public class ItemMagico {
    private String tipo;
    private String raridade;
    private String requisito;

    public ItemMagico() {
    }

    public ItemMagico(String tipo, String raridade, String requisito) {
        this.tipo = tipo;
        this.raridade = raridade;
        this.requisito = requisito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaridade() {
        return raridade;
    }

    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }
}

