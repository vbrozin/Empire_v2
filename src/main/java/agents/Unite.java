/**
* model/Unite.java
*
* File generated from the Unite uml Class
* Generated by the Acceleo UML 2.1 to Java generator module (Obeo)
* $ Date : 2/26/14 2:00:36 PM (February 26, 2014) $
*/
package agents;

// Start of user code to add imports for Unite


// End of user code

import environment.Carte;
import environment.Case;

import java.awt.*;
import java.util.HashSet;

/**
* Description of the class Unite.
*
*/

public class Unite implements IAgent{
    protected int pvRestant;
    protected int pointAttaque;
    protected double porteeAttaque;
    protected double porteeVision;

    // Start of user code to add fields for Unite
    protected Case<Point> maCase;
    protected Base maBase;
    protected Carte map;
    // End of user code

    /**
     * Constructor.
     */
    public Unite(Base b, int pv, int pt, int pa, double po, Case<Point> c, Carte ca) {
        // Start of user code for constructor Unite
        super();
        this.maBase = b;
        this.pvRestant = pv;
        this.pointAttaque = pt;
        this.porteeAttaque = pa;
        this.porteeVision = po;
        this.maCase = c;
        this.map = ca;
        // ajout de l'unité dans sa case
        c.ajouterUnite(this);
        // ajout de l'unite dans sa base
        b.addUnites(this);
        // End of user code
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

    /**
     * Return pointAttaque.
     * @return pointAttaque
     */
    public int getPointAttaque() {
        return pointAttaque;
    }

    /**
     * Set a value to attribute pointAttaque.
     * @param pointAttaque
     */
    public void setPointAttaque(int pointAttaque) {
        this.pointAttaque = pointAttaque;
    }

    /**
     * Return porteeAttaque.
     * @return porteeAttaque
     */
    public double getPorteeAttaque() {
        return porteeAttaque;
    }

    /**
     * Set a value to attribute porteeAttaque.
     * @param porteeAttaque
     */
    public void setPorteeAttaque(double porteeAttaque) {
        this.porteeAttaque = porteeAttaque;
    }


    /**
     * Return porteeVision.
     * @return porteeVision
     */
    public double getPorteeVision() {
        return porteeVision;
    }

    /**
     * Set a value to attribute porteeVision.
     * @param porteeVision
     */
    public void setPorteeVision(double porteeVision) {
        this.porteeVision = porteeVision;
    }

    /**
     * Return maBase.
     * @return maBase
     */
    public Base getBase() {
        return this.maBase;
    }

    /**
     * Return maCase.
     * @return maCase
     */
    public Case<Point> getCase() {
        return this.maCase;
    }

    /**
     * Description of the method calculerUnitePlusProche.
     *
     * @return ret
     */
    public IAgent calculerUnitePlusProche() {
        // Start of user code for method calculerUnitePlusProche

        IAgent ret = null;
        int i=1,j=0,tailleC=0;
        int posX = (int) this.maCase.getIndex().getX();
        int posY = (int) this.maCase.getIndex().getY();
        boolean ennemieTrouve=false;
        while(!ennemieTrouve && i<= porteeVision)
        {
            tailleC = 1+2*i;
            j=0;
            while(j<tailleC-1 && !ennemieTrouve)
            {
                // ligne du haut ->
                if(verifierCase(new Point(posX-i+j,posY+i))) {
                    ret = map.getCase(new Point(posX-i+j,posY+i)).getUnite(0);
                    ennemieTrouve=true;
                }
                // colonne de droite (haut vers bas)
                if(!ennemieTrouve && verifierCase(new Point(posX+i,posY+i-j))) {
                    ret = map.getCase(new Point(posX+i,posY+i-j)).getUnite(0);
                    ennemieTrouve=true;
                }
                // ligne du bas <-
                if(!ennemieTrouve && verifierCase(new Point(posX+i-j,posY-i))) {
                    ret = map.getCase(new Point(posX+i-j,posY-i)).getUnite(0);
                    ennemieTrouve=true;
                }
                 // colonne gauche (bas vers haut)
                if(!ennemieTrouve && verifierCase(new Point(posX-i,posY-i+j))) {
                    ret = map.getCase(new Point(posX-i,posY-i+j)).getUnite(0);
                    ennemieTrouve=true;
                }
                j++;
            }
            i++;
        }
        return ret;
        // End of user code
    }

    /**
     * Description of the method attaquer.
     *
     * @param cible
     */
    public void attaquer(IAgent cible) {
        // Start of user code for method attaquer
        if(calculerDistance(cible) <= porteeAttaque) {
            System.out.println(this.maBase.getNom() + " attaque " + cible.getBase().getNom() + "  pvRestant = " + (cible.getPvRestant()-pointAttaque));
            cible.subirDegats(cible.getPvRestant() - pointAttaque);
        }
        // End of user code
    }

    /**
     * Description of the method calculerDistance.
     * Calcul la distance entre l'Unite et une unite ennemie par Pythagore
     *
     * @param ennemie
     * @return ret
     */
    public double calculerDistance(IAgent ennemie) {
        // Start of user code for method calculerDistance
        double ret = 0;
        int posX = (int) this.maCase.getIndex().getX();
        int posY = (int) this.maCase.getIndex().getY();
        int cX = (int) ennemie.getCase().getIndex().getX();
        int cY = (int) ennemie.getCase().getIndex().getY();
        ret = Math.sqrt(Math.pow(posX-cX,2) + Math.pow(posY-cY,2));
        return ret;
        // End of user code
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

    /**
     * Description of the method guetter.
     *
     */
    public void guetter() {
        // Start of user code for method guetter

        // End of user code
    }

    // Start of user code to add methods for Unite
    private boolean verifierCase(Point p) {
        if(p.getX() >= 0 && p.getY() >= 0 && p.getX() < map.getLargeur() && p.getY() < map.getHauteur()) {

            if(map.getCase(p).estLibre() && map.getCase(p).getUnites().size() != 0){
                if(map.getCase(p).getUnite(0).getBase() == this.maBase)
                    return false;
                else
                    //System.out.println(map.getCase(p).getUnite(0).getBase().getNom() + " trouvé");
                    return true;
            }

            else
                return false;
        }
        else
            return false;
    }

    public void subirDegats(int pvRestant) {
        if(pvRestant <= 0)
            map.detruireUnite(this);
        else
            this.pvRestant = pvRestant;
    }

    public void reagir() {

    }

    // End of user code
}