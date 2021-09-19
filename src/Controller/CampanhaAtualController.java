package Controller;

import Model.Campanha;

public class CampanhaAtualController {
    private static Campanha campanha;

    public static Campanha getCampanhaAtual(){
        return campanha;
    }

    public static void setCampanhaAtual(Campanha c){
        campanha = c;
    }

}
