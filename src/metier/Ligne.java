package metier;

import org.w3c.dom.events.MouseEvent;

import IHM.PanelDessin;

public class Ligne
{
    private Point pDepart;
    private Point pArrivee;

    private Couleur coul;

    public Ligne(Couleur coul,Point p1, Point p2)
    {
        this.coul = coul; 
        this.pDepart=p1;
        this.pArrivee=p2;

    }

    public double longueur()    
    {
        return pDepart.distance(pArrivee);
    }

    




    
}

