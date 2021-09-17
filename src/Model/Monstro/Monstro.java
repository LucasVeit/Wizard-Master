package Model.Monstro;

import java.util.ArrayList;

public class Monstro {
    private String nomeMonstro;
    private String descricao;
    private String foto;
    private int classeArmadura;
    private int pontosVidaBase;
    private String tendencia;
    private float nivel;
    private int pontosExperiencia;
    private String formaCorporal;
    private String tamanho;
    private float deslocamentoBase;
    private ArrayList<CaracteristicaMonstro> caracteristicaMonstros;
    private int constituicao;
    private int carisma;
    private int destreza;
    private int forca;
    private int inteligencia;
    private int sabedoria;

    public Monstro() {
    }

    public Monstro(String nomeMonstro, String descricao, String foto, int classeArmadura, int pontosVidaBase, String tendencia, float nivel, int pontosExperiencia, String formaCorporal, String tamanho, float deslocamentoBase, ArrayList<CaracteristicaMonstro> caracteristicaMonstros, int constituicao, int carisma, int destreza, int forca, int inteligencia, int sabedoria) {
        this.nomeMonstro = nomeMonstro;
        this.descricao = descricao;
        this.foto = foto;
        this.classeArmadura = classeArmadura;
        this.pontosVidaBase = pontosVidaBase;
        this.tendencia = tendencia;
        this.nivel = nivel;
        this.pontosExperiencia = pontosExperiencia;
        this.formaCorporal = formaCorporal;
        this.tamanho = tamanho;
        this.deslocamentoBase = deslocamentoBase;
        this.caracteristicaMonstros = caracteristicaMonstros;
        this.constituicao = constituicao;
        this.carisma = carisma;
        this.destreza = destreza;
        this.forca = forca;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
    }

    public String getNomeMonstro() {
        return nomeMonstro;
    }

    public void setNomeMonstro(String nomeMonstro) {
        this.nomeMonstro = nomeMonstro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getClasseArmadura() {
        return classeArmadura;
    }

    public void setClasseArmadura(int classeArmadura) {
        this.classeArmadura = classeArmadura;
    }

    public int getPontosVidaBase() {
        return pontosVidaBase;
    }

    public void setPontosVidaBase(int pontosVidaBase) {
        this.pontosVidaBase = pontosVidaBase;
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

    public float getDeslocamentoBase() {
        return deslocamentoBase;
    }

    public void setDeslocamentoBase(float deslocamentoBase) {
        this.deslocamentoBase = deslocamentoBase;
    }

    public ArrayList<CaracteristicaMonstro> getCaracteristicaMonstros() {
        return caracteristicaMonstros;
    }

    public void setCaracteristicaMonstros(ArrayList<CaracteristicaMonstro> caracteristicaMonstros) {
        this.caracteristicaMonstros = caracteristicaMonstros;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }
}
