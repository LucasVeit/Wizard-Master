package Model.Personagem;

public class PersonagemTalento {
    private int codigoPersonagem;
    private String nomeTalento;

    public PersonagemTalento() {
    }

    public PersonagemTalento(int codigoPersonagem, String nomeTalento) {
        this.codigoPersonagem = codigoPersonagem;
        this.nomeTalento = nomeTalento;
    }

    public int getCodigoPersonagem() {
        return codigoPersonagem;
    }

    public void setCodigoPersonagem(int codigoPersonagem) {
        this.codigoPersonagem = codigoPersonagem;
    }

    public String getNomeTalento() {
        return nomeTalento;
    }

    public void setNomeTalento(String nomeTalento) {
        this.nomeTalento = nomeTalento;
    }
}
