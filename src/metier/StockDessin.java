package src.metier;

import java.util.ArrayList;

public class StockDessin {
    private ArrayList<Dessin> dessins;

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