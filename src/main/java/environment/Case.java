/**
 * model/Case.java
 *
 * File generated from the Case uml Class
 * Generated by the Acceleo UML 2.1 to Java generator module (Obeo)
 * $ Date : 2/26/14 2:00:36 PM (February 26, 2014) $
 */
package environment;

// Start of user code to add imports for Case


// End of user code

import agents.IAgent;
import agents.Unite;
import agents.Base;
import sun.jvm.hotspot.runtime.ia64.IA64CurrentFrameGuess;

import java.util.*;

/**
 * Description of the class Case.
 * Une case de notre carte
 */

public class Case<T>{

    /** La ressource s'il s'agit d'une case ressource*/
    private Ressource ressource;
    /** vrai s'il s'agit d'un obstacle*/
    private boolean obstacle;
    /** Le nombre maximum d'unités dans une case*/
    private final int capacite = 1;
    /** unités dans la case*/
    private ArrayList<IAgent> unites;
    /** l'étiquette de la case*/
    private T index;
    // End of user code

    /**
     * Constructor.
     */
    public Case(final T index, final boolean obstacleBoolean) {
        this.index = index;
        this.obstacle = obstacleBoolean;
        unites = new ArrayList<IAgent>();
    }

    /**
     * Recupère l'étiquette
     */
    public T getIndex() {
        return index;
    }

    /**
     * Vrai si la case est occupée
     */
    public boolean estLibre() {
        if(!obstacle)
            return unites.size() <= capacite;
        else
            return false;
    }

    /**
     * Vrai si la case est un obstacle
     */
    public boolean estObstacle() {
        return obstacle;
    }


    /**
     * Ajoute une unité dans la case
     */
    public void ajouterUnite(IAgent unite) {
        unites.add(unite);
    }

    /**
     * Retire l'unité dans la case
     */
    public void retirerUnite(IAgent unite) {
        unites.remove(unite);
    }

    /**
     * Est-ce que la case contient l'unité en question.
     */
    public boolean contientUnite(Unite unite) {
        return unites.contains(unite);
    }

    /**
     * Retourne les unités contenues dans la case
     */
    public ArrayList<IAgent> getUnites() {
       return unites;
    }

    /**
     * Retourne la ième unité (0 à n)
     */
    public IAgent getUnite(int i) {
        return unites.get(i);
    }

    // Start of user code to add methods for Case

    // End of user code
}