package Model;

public class Raca {
    private String nomeRaca;
    private String caminhoImagem;
    private String descricao;

    public Raca() {
    }

    public Raca(String nomeRaca, String caminhoImagem, String descricao) {
        this.nomeRaca = nomeRaca;
        this.caminhoImagem = caminhoImagem;
        this.descricao = descricao;
    }

    public String getNomeRaca() {
        return nomeRaca;
    }

    public void setNomeRaca(String nomeRaca) {
        this.nomeRaca = nomeRaca;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
