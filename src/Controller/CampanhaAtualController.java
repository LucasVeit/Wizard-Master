package Controller;

import Model.Campanha;
import sample.main;

public class CampanhaAtualController {
    private static Campanha campanha;

    public static Campanha getCampanhaAtual(){
        return campanha;
    }

    public static void setCampanhaAtual(Campanha c){
        campanha = c;
    }
    public static void start(){
        campanha = new Campanha("", "");
    }

}
