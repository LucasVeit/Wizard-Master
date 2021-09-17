package Model.Item;


public class ArmaduraEscudo {
    private int classeArmadura;
    private boolean modificadorDes;
    private int maxModificador;
    private int forcaNecessaria;
    private String tipo;
    private boolean furtividade;
    private int PeriodoEquipar;
    private int PeriodoDesequipar;
    private String medidaPeriodo;

    public ArmaduraEscudo() {
    }

    public ArmaduraEscudo(int classeArmadura, boolean modificadorDes, int maxModificador, int forcaNecessaria, String tipo, boolean furtividade, int periodoEquipar, int periodoDesequipar, String medidaPeriodo) {
        this.classeArmadura = classeArmadura;
        this.modificadorDes = modificadorDes;
        this.maxModificador = maxModificador;
        this.forcaNecessaria = forcaNecessaria;
        this.tipo = tipo;
        this.furtividade = furtividade;
        PeriodoEquipar = periodoEquipar;
        PeriodoDesequipar = periodoDesequipar;
        this.medidaPeriodo = medidaPeriodo;
    }

    public int getClasseArmadura() {
        return classeArmadura;
    }

    public void setClasseArmadura(int classeArmadura) {
        this.classeArmadura = classeArmadura;
    }

    public boolean isModificadorDes() {
        return modificadorDes;
    }

    public void setModificadorDes(boolean modificadorDes) {
        this.modificadorDes = modificadorDes;
    }

    public int getMaxModificador() {
        return maxModificador;
    }

    public void setMaxModificador(int maxModificador) {
        this.maxModificador = maxModificador;
    }

    public int getForcaNecessaria() {
        return forcaNecessaria;
    }

    public void setForcaNecessaria(int forcaNecessaria) {
        this.forcaNecessaria = forcaNecessaria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isFurtividade() {
        return furtividade;
    }

    public void setFurtividade(boolean furtividade) {
        this.furtividade = furtividade;
    }

    public int getPeriodoEquipar() {
        return PeriodoEquipar;
    }

    public void setPeriodoEquipar(int periodoEquipar) {
        PeriodoEquipar = periodoEquipar;
    }

    public int getPeriodoDesequipar() {
        return PeriodoDesequipar;
    }

    public void setPeriodoDesequipar(int periodoDesequipar) {
        PeriodoDesequipar = periodoDesequipar;
    }

    public String getMedidaPeriodo() {
        return medidaPeriodo;
    }

    public void setMedidaPeriodo(String medidaPeriodo) {
        this.medidaPeriodo = medidaPeriodo;
    }
}
