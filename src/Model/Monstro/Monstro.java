package Model.Monstro;

import java.util.ArrayList;

public class Monstro {
    private String nomeMonstro;
    private String introducao;
    private String foto;
    private String classeArmadura;
    private String pontosVida;
    private String tendencia;
    private float nivel;
    private int pontosExperiencia;
    private String formaCorporal;
    private String tamanho;
    private String descricaoLendaria;
    private ArrayList<LoreMonstro> lore;
    private ArrayList<TracoEspecialMonstro> tracoEspecial;
    private ArrayList<CaracteristicaMonstro> caracteristica;
    private ArrayList<AcaoMonstro> acao;
    private ArrayList<AcaoLendariaMonstro> acaoLendaria;

    public Monstro(String nomeMonstro, String introducao, String foto, String classeArmadura,
                   String pontosVida, String tendencia, float nivel, int pontosExperiencia,
                   String formaCorporal, String tamanho, String descricaoLendaria,
                   ArrayList<LoreMonstro> lore, ArrayList<TracoEspecialMonstro> tracoEspecial,
                   ArrayList<CaracteristicaMonstro> caracteristica, ArrayList<AcaoMonstro> acao,
                   ArrayList<AcaoLendariaMonstro> acaoLendaria) {
        this.nomeMonstro = nomeMonstro;
        this.introducao = introducao;
        this.foto = foto;
        this.classeArmadura = classeArmadura;
        this.pontosVida = pontosVida;
        this.tendencia = tendencia;
        this.nivel = nivel;
        this.pontosExperiencia = pontosExperiencia;
        this.formaCorporal = formaCorporal;
        this.tamanho = tamanho;
        this.descricaoLendaria = descricaoLendaria;
        this.lore = lore;
        this.tracoEspecial = tracoEspecial;
        this.caracteristica = caracteristica;
        this.acao = acao;
        this.acaoLendaria = acaoLendaria;
    }

    public String getNomeMonstro() {
        return nomeMonstro;
    }

    public void setNomeMonstro(String nomeMonstro) {
        this.nomeMonstro = nomeMonstro;
    }

    public String getIntroducao() {
        return introducao;
    }

    public void setIntroducao(String introducao) {
        this.introducao = introducao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getClasseArmadura() {
        return classeArmadura;
    }

    public void setClasseArmadura(String classeArmadura) {
        this.classeArmadura = classeArmadura;
    }

    public String getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(String pontosVida) {
        this.pontosVida = pontosVida;
    }

    public String getTendencia() {
        return tendencia;
    }

    public void setTendencia(String tendencia) {
        this.tendencia = tendencia;
    }

    public float getNivel() {
        return nivel;
    }

    public void setNivel(float nivel) {
        this.nivel = nivel;
    }

    public int getPontosExperiencia() {
        return pontosExperiencia;
    }

    public void setPontosExperiencia(int pontosExperiencia) {
        this.pontosExperiencia = pontosExperiencia;
    }

    public String getFormaCorporal() {
        return formaCorporal;
    }

    public void setFormaCorporal(String formaCorporal) {
        this.formaCorporal = formaCorporal;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getDescricaoLendaria() {
        return descricaoLendaria;
    }

    public void setDescricaoLendaria(String descricaoLendaria) {
        this.descricaoLendaria = descricaoLendaria;
    }

    public ArrayList<LoreMonstro> getLore() {
        return lore;
    }

    public void setLore(ArrayList<LoreMonstro> lore) {
        this.lore = lore;
    }

    public ArrayList<TracoEspecialMonstro> getTracoEspecial() {
        return tracoEspecial;
    }

    public void setTracoEspecial(ArrayList<TracoEspecialMonstro> tracoEspecial) {
        this.tracoEspecial = tracoEspecial;
    }

    public ArrayList<CaracteristicaMonstro> getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(ArrayList<CaracteristicaMonstro> caracteristica) {
        this.caracteristica = caracteristica;
    }

    public ArrayList<AcaoMonstro> getAcao() {
        return acao;
    }

    public void setAcao(ArrayList<AcaoMonstro> acao) {
        this.acao = acao;
    }

    public ArrayList<AcaoLendariaMonstro> getAcaoLendaria() {
        return acaoLendaria;
    }

    public void setAcaoLendaria(ArrayList<AcaoLendariaMonstro> acaoLendaria) {
        this.acaoLendaria = acaoLendaria;
    }
}
