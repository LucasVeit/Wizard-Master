package Model.Item;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ArmaduraEscudo {
    private Item armaduraEscudo;
    private SimpleIntegerProperty classeArmadura;
    private SimpleBooleanProperty modificadorDes;
    private SimpleIntegerProperty maxModificador;
    private SimpleIntegerProperty forcaNecessaria;
    private SimpleStringProperty tipo;
    private SimpleBooleanProperty furtividade;
    private SimpleIntegerProperty PeriodoEquipar;
    private SimpleIntegerProperty PeriodoDesequipar;
    private SimpleStringProperty medidaPeriodo;

    public ArmaduraEscudo() {
    }

    public ArmaduraEscudo(Item armaduraEscudo, SimpleIntegerProperty classeArmadura, SimpleBooleanProperty modificadorDes, SimpleIntegerProperty maxModificador, SimpleIntegerProperty forcaNecessaria, SimpleStringProperty tipo, SimpleBooleanProperty furtividade, SimpleIntegerProperty periodoEquipar, SimpleIntegerProperty periodoDesequipar, SimpleStringProperty medidaPeriodo) {
        this.armaduraEscudo = armaduraEscudo;
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

    public Item getArmaduraEscudo() {
        return armaduraEscudo;
    }

    public void setArmaduraEscudo(Item armaduraEscudo) {
        this.armaduraEscudo = armaduraEscudo;
    }

    public int getClasseArmadura() {
        return classeArmadura.get();
    }

    public SimpleIntegerProperty classeArmaduraProperty() {
        return classeArmadura;
    }

    public void setClasseArmadura(int classeArmadura) {
        this.classeArmadura.set(classeArmadura);
    }

    public boolean isModificadorDes() {
        return modificadorDes.get();
    }

    public SimpleBooleanProperty modificadorDesProperty() {
        return modificadorDes;
    }

    public void setModificadorDes(boolean modificadorDes) {
        this.modificadorDes.set(modificadorDes);
    }

    public int getMaxModificador() {
        return maxModificador.get();
    }

    public SimpleIntegerProperty maxModificadorProperty() {
        return maxModificador;
    }

    public void setMaxModificador(int maxModificador) {
        this.maxModificador.set(maxModificador);
    }

    public int getForcaNecessaria() {
        return forcaNecessaria.get();
    }

    public SimpleIntegerProperty forcaNecessariaProperty() {
        return forcaNecessaria;
    }

    public void setForcaNecessaria(int forcaNecessaria) {
        this.forcaNecessaria.set(forcaNecessaria);
    }

    public String getTipo() {
        return tipo.get();
    }

    public SimpleStringProperty tipoProperty() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }

    public boolean isFurtividade() {
        return furtividade.get();
    }

    public SimpleBooleanProperty furtividadeProperty() {
        return furtividade;
    }

    public void setFurtividade(boolean furtividade) {
        this.furtividade.set(furtividade);
    }

    public int getPeriodoEquipar() {
        return PeriodoEquipar.get();
    }

    public SimpleIntegerProperty periodoEquiparProperty() {
        return PeriodoEquipar;
    }

    public void setPeriodoEquipar(int periodoEquipar) {
        this.PeriodoEquipar.set(periodoEquipar);
    }

    public int getPeriodoDesequipar() {
        return PeriodoDesequipar.get();
    }

    public SimpleIntegerProperty periodoDesequiparProperty() {
        return PeriodoDesequipar;
    }

    public void setPeriodoDesequipar(int periodoDesequipar) {
        this.PeriodoDesequipar.set(periodoDesequipar);
    }

    public String getMedidaPeriodo() {
        return medidaPeriodo.get();
    }

    public SimpleStringProperty medidaPeriodoProperty() {
        return medidaPeriodo;
    }

    public void setMedidaPeriodo(String medidaPeriodo) {
        this.medidaPeriodo.set(medidaPeriodo);
    }
}
