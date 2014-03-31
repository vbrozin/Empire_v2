/**
* model/Attaquant.java
*
* File generated from the Attaquant uml Class
* Generated by the Acceleo UML 2.1 to Java generator module (Obeo)
* $ Date : 2/26/14 2:00:36 PM (February 26, 2014) $
*/
package agents;

// Start of user code to add imports for Attaquant


// End of user code

import environment.Carte;
import environment.Case;
import java.awt.Point;

/**
* Description of the class Attaquant.
*
*/

public class Attaquant extends Defenseur implements IUniteLibre {

    // Start of user code to add fields for Attaquant

    // End of user code

    /**
     * Constructor.
     */
    public Attaquant(Base b, int pv, int pa, double poa, double pov, Case<Point> c, Carte ca) {
    // Start of user code for constructor Unite
    super(b, pv, pa, poa, pov, c, ca);
    // End of user code
    }

    /**
     * Description of the method seDeplacer.
    *
    * @param caseLibre
    */
    @Override
    public void seDeplacer(Case caseLibre) {
        if(caseLibre != null && caseLibre.estLibre()) {
            getCase().retirerUnite(this);
            setCase(caseLibre);
            getCase().ajouterUnite(this);
        }
    }


    /**
     * Description of the method suivreUnite.
     *
     * @param cible
     */
    public void suivreUnite(IAgent cible) {
        Case<Point> caseCalculee = maBase.calculerChemin(getCase(), cible.getCase());
        seDeplacer(caseCalculee);
    }

    /**
     * Description of the method reagir.
     * On cherche une unite ennemie dans la portee de vision, si il y en a une,
     * on verifit la distance est on attaque ou on se deplace vers l'unite ennemie selon le cas.
     */
    public void reagir() {
        IAgent ennemi = calculerUnitePlusProche();
        if(ennemi != null) {
            double distance = calculerDistance(ennemi);
            if(distance <= porteeVision) {
                if(distance <= porteeAction)
                    attaquer(ennemi);
                else
                    suivreUnite(ennemi);
            }
        }
    }



}