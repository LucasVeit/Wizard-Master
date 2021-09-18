package Model;

public class Personagem {
    private int codigoAparencia;
    private String nomePersonagem;
    private float altura;
    private float peso;
    private String corOlhos;
    private int idade;
    private String corPele;
    private String corCabelo;
    private int codigoPersonagem;
    private String nomeJogador;
    private String nomeCampanha;
    private String personagemRaca;
    private String personagemClasse;
    private int Deus;
    private String arquetipo;
    private String nomeAntecedente;
    private int coordenadaX;
    private int coordenadaY;
    private String tendencia;
    private int percepcaoPassiva;
    private int numeroInspiracao;;
    private int pontosVidaAtual;
    private int pontosVidaTotal;
    private int pontosExperiencia;
    private int capacidadeCarga;
    private int cobre;
    private int prata;
    private int ouro;
    private int platina;
    private int electro;
    private int classeArmadura;
    private float deslocamento;
    private String caracteristicaAdicional;
    private String vinculo;
    private String defeito;
    private String ideal;
    private String tracoPersonalidade;
    private int Carisma;
    private int Constituição;
    private int Força;
    private int Destreza;
    private int sabedoria;
    private int inteligencia;

    public Personagem() {
    }

    public Personagem(int codigoAparencia, String nomePersonagem, float altura, float peso, String corOlhos, int idade, String corPele, String corCabelo, int codigoPersonagem, String nomeJogador, String nomeCampanha, String personagemRaca, String personagemClasse, int deus, String arquetipo, String nomeAntecedente, int coordenadaX, int coordenadaY, String tendencia, int percepcaoPassiva, int numeroInspiracao, int pontosVidaAtual, int pontosVidaTotal, int pontosExperiencia, int capacidadeCarga, int cobre, int prata, int ouro, int platina, int electro, int classeArmadura, float deslocamento, String caracteristicaAdicional, String vinculo, String defeito, String ideal, String tracoPersonalidade, int carisma, int constituição, int força, int destreza, int sabedoria, int inteligencia) {
        this.codigoAparencia = codigoAparencia;
        this.nomePersonagem = nomePersonagem;
        this.altura = altura;
        this.peso = peso;
        this.corOlhos = corOlhos;
        this.idade = idade;
        this.corPele = corPele;
        this.corCabelo = corCabelo;
        this.codigoPersonagem = codigoPersonagem;
        this.nomeJogador = nomeJogador;
        this.nomeCampanha = nomeCampanha;
        this.personagemRaca = personagemRaca;
        this.personagemClasse = personagemClasse;
        Deus = deus;
        this.arquetipo = arquetipo;
        this.nomeAntecedente = nomeAntecedente;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.tendencia = tendencia;
        this.percepcaoPassiva = percepcaoPassiva;
        this.numeroInspiracao = numeroInspiracao;
        this.pontosVidaAtual = pontosVidaAtual;
        this.pontosVidaTotal = pontosVidaTotal;
        this.pontosExperiencia = pontosExperiencia;
        this.capacidadeCarga = capacidadeCarga;
        this.cobre = cobre;
        this.prata = prata;
        this.ouro = ouro;
        this.platina = platina;
        this.electro = electro;
        this.classeArmadura = classeArmadura;
        this.deslocamento = deslocamento;
        this.caracteristicaAdicional = caracteristicaAdicional;
        this.vinculo = vinculo;
        this.defeito = defeito;
        this.ideal = ideal;
        this.tracoPersonalidade = tracoPersonalidade;
        Carisma = carisma;
        Constituição = constituição;
        Força = força;
        Destreza = destreza;
        this.sabedoria = sabedoria;
        this.inteligencia = inteligencia;
    }

    public int getCodigoAparencia() {
        return codigoAparencia;
    }

    public void setCodigoAparencia(int codigoAparencia) {
        this.codigoAparencia = codigoAparencia;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getCorOlhos() {
        return corOlhos;
    }

    public void setCorOlhos(String corOlhos) {
        this.corOlhos = corOlhos;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCorPele() {
        return corPele;
    }

    public void setCorPele(String corPele) {
        this.corPele = corPele;
    }

    public String getCorCabelo() {
        return corCabelo;
    }

    public void setCorCabelo(String corCabelo) {
        this.corCabelo = corCabelo;
    }

    public int getCodigoPersonagem() {
        return codigoPersonagem;
    }

    public void setCodigoPersonagem(int codigoPersonagem) {
        this.codigoPersonagem = codigoPersonagem;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public String getNomeCampanha() {
        return nomeCampanha;
    }

    public void setNomeCampanha(String nomeCampanha) {
        this.nomeCampanha = nomeCampanha;
    }

    public String getPersonagemRaca() {
        return personagemRaca;
    }

    public void setPersonagemRaca(String personagemRaca) {
        this.personagemRaca = personagemRaca;
    }

    public String getPersonagemClasse() {
        return personagemClasse;
    }

    public void setPersonagemClasse(String personagemClasse) {
        this.personagemClasse = personagemClasse;
    }

    public int getDeus() {
        return Deus;
    }

    public void setDeus(int deus) {
        Deus = deus;
    }

    public String getArquetipo() {
        return arquetipo;
    }

    public void setArquetipo(String arquetipo) {
        this.arquetipo = arquetipo;
    }

    public String getNomeAntecedente() {
        return nomeAntecedente;
    }

    public void setNomeAntecedente(String nomeAntecedente) {
        this.nomeAntecedente = nomeAntecedente;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public String getTendencia() {
        return tendencia;
    }

    public void setTendencia(String tendencia) {
        this.tendencia = tendencia;
    }

    public int getPercepcaoPassiva() {
        return percepcaoPassiva;
    }

    public void setPercepcaoPassiva(int percepcaoPassiva) {
        this.percepcaoPassiva = percepcaoPassiva;
    }

    public int getNumeroInspiracao() {
        return numeroInspiracao;
    }

    public void setNumeroInspiracao(int numeroInspiracao) {
        this.numeroInspiracao = numeroInspiracao;
    }

    public int getPontosVidaAtual() {
        return pontosVidaAtual;
    }

    public void setPontosVidaAtual(int pontosVidaAtual) {
        this.pontosVidaAtual = pontosVidaAtual;
    }

    public int getPontosVidaTotal() {
        return pontosVidaTotal;
    }

    public void setPontosVidaTotal(int pontosVidaTotal) {
        this.pontosVidaTotal = pontosVidaTotal;
    }

    public int getPontosExperiencia() {
        return pontosExperiencia;
    }

    public void setPontosExperiencia(int pontosExperiencia) {
        this.pontosExperiencia = pontosExperiencia;
    }

    public int getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(int capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getCobre() {
        return cobre;
    }

    public void setCobre(int cobre) {
        this.cobre = cobre;
    }

    public int getPrata() {
        return prata;
    }

    public void setPrata(int prata) {
        this.prata = prata;
    }

    public int getOuro() {
        return ouro;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public int getPlatina() {
        return platina;
    }

    public void setPlatina(int platina) {
        this.platina = platina;
    }

    public int getElectro() {
        return electro;
    }

    public void setElectro(int electro) {
        this.electro = electro;
    }

    public int getClasseArmadura() {
        return classeArmadura;
    }

    public void setClasseArmadura(int classeArmadura) {
        this.classeArmadura = classeArmadura;
    }

    public float getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(float deslocamento) {
        this.deslocamento = deslocamento;
    }

    public String getCaracteristicaAdicional() {
        return caracteristicaAdicional;
    }

    public void setCaracteristicaAdicional(String caracteristicaAdicional) {
        this.caracteristicaAdicional = caracteristicaAdicional;
    }

    public String getVinculo() {
        return vinculo;
    }

    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getIdeal() {
        return ideal;
    }

    public void setIdeal(String ideal) {
        this.ideal = ideal;
    }

    public String getTracoPersonalidade() {
        return tracoPersonalidade;
    }

    public void setTracoPersonalidade(String tracoPersonalidade) {
        this.tracoPersonalidade = tracoPersonalidade;
    }

    public int getCarisma() {
        return Carisma;
    }

    public void setCarisma(int carisma) {
        Carisma = carisma;
    }

    public int getConstituição() {
        return Constituição;
    }

    public void setConstituição(int constituição) {
        Constituição = constituição;
    }

    public int getForça() {
        return Força;
    }

    public void setForça(int força) {
        Força = força;
    }

    public int getDestreza() {
        return Destreza;
    }

    public void setDestreza(int destreza) {
        Destreza = destreza;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }
}
