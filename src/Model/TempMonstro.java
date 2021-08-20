package Model;

import javafx.beans.property.SimpleStringProperty;

public class TempMonstro {

    private SimpleStringProperty nomeMonstro;

    public TempMonstro(String nomeMonstro) {
        this.nomeMonstro = new SimpleStringProperty(nomeMonstro);
    }

    public String getNomeMonstro() {
        return nomeMonstro.get();
    }

    public SimpleStringProperty nomeMonstroProperty() {
        return nomeMonstro;
    }

    public void setNomeMonstro(String nomeMonstro) {
        this.nomeMonstro.set(nomeMonstro);
    }
}
