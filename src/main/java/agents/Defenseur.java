/**
* model/Defenseur.java
*
* File generated from the Defenseur uml Class
* Generated by the Acceleo UML 2.1 to Java generator module (Obeo)
* $ Date : 2/26/14 2:00:36 PM (February 26, 2014) $
*/
package agents;

// Start of user code to add imports for Defenseur


// End of user code

import environment.Carte;
import environment.Case;

/**
* Description of the class Defenseur.
*
*/

public class Defenseur extends Unite implements IAgent {

    // Start of user code to add fields for Defenseur

    // End of user code

    /**
     * Constructor.
     */
    public Defenseur(Base b, int pv, int pt, int pa, int t, int va, double po, Case c, Carte ca) {
        // Start of user code for constructor Unite
        super(b, pv, pt, pa, t, va, po, c, ca);
        // End of user code
    }

    /**
     * Description of the method reagir.
     */
    @Override
    public void reagir() {
        Unite ennemie = calculerUnitePlusProche();
        if(ennemie != null)
                attaquer(ennemie);
    }


// Start of user code to add methods for Defenseur

    // End of user code
}