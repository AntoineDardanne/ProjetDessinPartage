package metier;

import java.util.ArrayList;

import IHM.PanelDessin;


public class StockDessin {
    private static ArrayList<Dessin> dessins;

    public StockDessin() {
        this.dessins = new ArrayList<Dessin>();
    }

    public ArrayList<Dessin> getDessins() {
        return dessins;
    }

    public void setDessins(ArrayList<Dessin> dessins) {
        this.dessins = dessins;
    }

    


}