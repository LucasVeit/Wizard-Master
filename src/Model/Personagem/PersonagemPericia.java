package Model.Personagem;

public class PersonagemPericia {
    private int codigoPersonagem;
    private String nomePericia;

    public PersonagemPericia() {
    }

    public PersonagemPericia(int codigoPersonagem, String nomePericia) {
        this.codigoPersonagem = codigoPersonagem;
        this.nomePericia = nomePericia;
    }

    public int getCodigoPersonagem() {
        return codigoPersonagem;
    }

    public void setCodigoPersonagem(int codigoPersonagem) {
        this.codigoPersonagem = codigoPersonagem;
    }

    public String getNomePericia() {
        return nomePericia;
    }

    public void setNomePericia(String nomePericia) {
        this.nomePericia = nomePericia;
    }
}
