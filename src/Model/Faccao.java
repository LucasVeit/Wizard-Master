package Model;

public class Faccao {

    private int codigo;
    private String nomeFaccao;
    private String nomeCampanha;
    private int populacao;
    private String formaGoverno;
    private String descricao;

    public Faccao() {
    }

    public Faccao(int codigo, String nomeFaccao, String nomeCampanha, int populacao, String formaGoverno, String descricao) {
        this.codigo = codigo;
        this.nomeFaccao = nomeFaccao;
        this.nomeCampanha = nomeCampanha;
        this.populacao = populacao;
        this.formaGoverno = formaGoverno;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeFaccao() {
        return nomeFaccao;
    }

    public void setNomeFaccao(String nomeFaccao) {
        this.nomeFaccao = nomeFaccao;
    }

    public String getNomeCampanha() {
        return nomeCampanha;
    }

    public void setNomeCampanha(String nomeCampanha) {
        this.nomeCampanha = nomeCampanha;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public String getFormaGoverno() {
        return formaGoverno;
    }

    public void setFormaGoverno(String formaGoverno) {
        this.formaGoverno = formaGoverno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
