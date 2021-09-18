package Model.Personagem;

public class PersonagemMagia {
    private int codigoPersonagem;
    private String nomeMagia;

    public PersonagemMagia() {
    }

    public PersonagemMagia(int codigoPersonagem, String nomeMagia) {
        this.codigoPersonagem = codigoPersonagem;
        this.nomeMagia = nomeMagia;
    }

    public int getCodigoPersonagem() {
        return codigoPersonagem;
    }

    public void setCodigoPersonagem(int codigoPersonagem) {
        this.codigoPersonagem = codigoPersonagem;
    }

    public String getNomeMagia() {
        return nomeMagia;
    }

    public void setNomeMagia(String nomeMagia) {
        this.nomeMagia = nomeMagia;
    }
}
