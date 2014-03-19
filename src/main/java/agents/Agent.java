package agents;

import environment.Carte;
import environment.Case;

import java.awt.*;

/**
 * Created by sylvainchen on 27/02/14.
 */
public class Agent{
    private int pvRestant;
    private Case<Point> maCase;
    private Carte maCarte;
    protected Base maBase;


    public Agent(int pv, Case<Point> c, Carte laCarte) {
        this.pvRestant = pv;
        this.maCase = c;
        this.maCarte = laCarte;
    }

    /**
     * Return maCase.
     * @return maCase
     */
    public Case<Point> getCase() {
        return maCase;
    }

    /**
     * Return maCase.
     * @return maCase
     */
    protected void setCase(Case<Point> c) {
        this.maCase = c;
    }

    /**
     * Return maCase.
     * @return maCase
     */
    public Carte getCarte() {
        return maCarte;
    }

    /**
     * Return maCase.
     * @return maCase
     */
    public Base getBase() {
        return maBase;
    }

    /**
     * Return pvRestant.
     * @return pvRestant
     */
    public int getPvRestant() {
        return pvRestant;
    }

    /**
     * Set a value to attribute pvRestant.
     * @param pvRestant
     */
    public void setPvRestant(int pvRestant) {
        this.pvRestant = pvRestant;
    }


    public void subirDegats(int degats) {
        if(pvRestant-degats <= 0) {
            this.pvRestant = 0;
        }
        else
            this.pvRestant -= degats;
    }



    /**
     * Description of the method calculerDistance.
     * Calcul la distance entre l'Unite et une unite ennemie par Pythagore
     *
     * @param c
     * @return ret
     */
    public double calculerDistance(Case<Point> c) {
        // Start of user code for method calculerDistance
        double ret = 0;
        int posX = (int) this.maCase.getIndex().getX();
        int posY = (int) this.maCase.getIndex().getY();
        int cX = (int) c.getIndex().getX();
        int cY = (int) c.getIndex().getY();
        ret = Math.sqrt(Math.pow(posX-cX,2) + Math.pow(posY-cY,2));
        return ret;
        // End of user code
    }

}
