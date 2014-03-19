/**
* model/Jeu.java
*
* File generated from the Jeu uml Class
* Generated by the Acceleo UML 2.1 to Java generator module (Obeo)
* $ Date : 2/26/14 2:00:37 PM (February 26, 2014) $
*/
package environment;

// Start of user code to add imports for Jeu

import agents.Base;

import java.awt.*;
import java.util.ArrayList;


// End of user code

/**
* Description of the class Jeu.
* Le jeu
*/

public class Jeu {
    /**Liste des bases du jeu */
    private ArrayList<Base> bases;
    /**Liste des bases qui doivent encore jouer pendant le tour*/
    private ArrayList<Base> playedBases;
    /**La carte du jeu */
    private Carte carte;
    /**La base courante, celle qui joue actuellement */
    private Base baseCourante;
    /**Le temps */
    private double t;

    // Start of user code to add fields for Jeu

    // End of user code

    /**
     * Constructor.
     */
    public Jeu(Carte carte, ArrayList<Base> bases) {
        // Start of user code for constructor Jeu
        super();
        this.carte = carte;
        this.bases = bases;
        t = 0;
        for(Base b : bases)
            b.setJeu(this);
        initTour();
        choisirBaseCourante();
        // End of user code
    }

    /**
     * Return bases.
     * @return bases
     */
    public ArrayList<Base> getBases() {
        return bases;
    }


    /**
     * Remove a bases to the bases collection.
     * @param bases_elt Element to remove
     */
    public void removeBases(Base bases_elt) {
        this.bases.remove(bases_elt);
    }

    /**
     * Return carte.
     * @return carte
     */
    public Carte getCarte() {
        return carte;
    }


    /**
     * Description of the method avancerTemps.
     *
     */
    public void avancerTemps() {
        t++;
    }

    /**
     * Description of the method jouer.
     */
    public void jouer() {
        Base b = getBaseCourante();
        if(b.getPvRestant() > 0)
            b.jouer();
        // La base courante vient de jouer
        if(tourFini()) {
            // S'il ne reste que la base courante de jouer, on initialise le tour de jeu
            initTour();
            // On choisit alors aléatoirement une nouvelle base
            if(bases.size() != 0)
                choisirBaseCourante();
        }
        else {
            // Sinon on change la base courante
            if(bases.size() != 0)
                changerBaseCourante();
        }

    }

    /**
     * Description of the method fini.
     *
     * @return ret
     */
    public boolean fini() {
        // Start of user code for method fini

        boolean ret = bases.size() == 1;

        return ret;
        // End of user code
    }

    /**
     * Description of the method getBaseCourante.
     *
     * @return ret
     */
    public Base getBaseCourante() {
        // Start of user code for method getBaseCourante
        return baseCourante;
        // End of user code
    }

    /**
     * Change la base courante
     */
    public void changerBaseCourante() {
        playedBases.remove(baseCourante);
        choisirBaseCourante();
    }

    /**
     * Choisi une base courante aléatoirement parmi celles qui n'ont pas encore joués
     */
    public void choisirBaseCourante() {
        int n = playedBases.size();
        int number = (int)(Math.random()*n);
        if(playedBases.size() != 0)
            baseCourante = playedBases.get(number);
    }

    /**
     * Description of the method changerBaseCourante.
     *
     */
    public void initTour() {
        playedBases = new ArrayList<Base>();
        playedBases.addAll(bases);
        //for(Base b : bases)
        //    playedBases.add(b);
        t++;
    }


    /**
     * Description of the method changerBaseCourante.
     *
     */
    public boolean tourFini() {
        return playedBases.size() == 1;
    }

    /**
     * Renvoie les cases des autres bases
     *
     */
    public ArrayList<Case<Point>> getCasesBases(Base base) {
        ArrayList<Base> nouvellesBases = bases;
        ArrayList<Case<Point>> cases = new ArrayList<Case<Point>>();
        for(Base b : nouvellesBases) {
            if(!b.equals(base))
                cases.add(b.getCase());
        }
        return cases;
    }

    // Start of user code to add methods for Jeu

    // End of user code
}