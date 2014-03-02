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

import agents.Unite;

import java.util.HashSet;

/**
 * Description of the class Case.
 *
 */

public class Case<T>{

    // Start of user code to add fields for Case
    private final int capacite = 1;
    private Ressource ressource;
    private boolean obstacle;
    //private boolean libre;
    private HashSet<Unite> unites;
    private T index;
    // End of user code

    /**
     * Constructor.
     */
    public Case(final T index, final boolean obstacleBoolean) {
        this.index = index;
        this.obstacle = obstacleBoolean;
        unites = new HashSet<Unite>();
    }

    public T getIndex() {
        return index;
    }

    public boolean estLibre() {
        return !obstacle && unites.size() < capacite;
    }

    public boolean estObstacle() {
        return obstacle;
    }

    public void ajouterUnite(Unite unite) {
        unites.add(unite);
    }

    public void retirerUnite(Unite unite) {
        unites.remove(unite);
    }

    public boolean contientUnite(Unite unite) {
        return unites.contains(unite);
    }

    public int compte() {
        return unites.size();
    }

    public HashSet<Unite> getUnite() {
       return unites;
    }
    // Start of user code to add methods for Case

    // End of user code
}