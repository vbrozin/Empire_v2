/**
 * model/Carte.java
 *
 * File generated from the Carte uml Class
 * Generated by the Acceleo UML 2.1 to Java generator module (Obeo)
 * $ Date : 2/26/14 2:00:37 PM (February 26, 2014) $
 */
package environment;

// Start of user code to add imports for Carte
 
import agents.Unite;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


// End of user code

/**
 * Description of the class Carte.
 *
 */

public class Carte {
    private int hauteur;
    private int largeur;
    private Map<Point, Case> map = new HashMap<Point, Case>();
    private HashSet<Point> points = new HashSet<Point>();
    private Map<Ressource, Case> ressources = new HashMap<Ressource, Case>();
    private HashSet<Case> casesBases = new HashSet<Case>();

    /**
     * Constructor.
     */
    public Carte(String[][] matrix) {
        // Start of user code for constructor Carte
        largeur = matrix[0].length;
        hauteur = matrix.length;
        for(int i=0; i<hauteur; i++)
            for(int j=0; j<largeur; j++) {
                Point p = new Point(j,i);
                points.add(p);
                Case<Point> c = null;
                // Création des cases libres
                if(" ".equals(matrix[i][j]))
                    c = new Case(p, false);
                else {
                    // Création des ressources
                    if("n".equals(matrix[i][j]) || "b".equals(matrix[i][j])) {
                        TypeRessource type = null;
                        if("b".equals(matrix[i][j]))
                            type = TypeRessource.BOIS;
                        if("n".equals(matrix[i][j]))
                            type = TypeRessource.NOURRITURE;
                        Ressource r = new Ressource(1000, type);
                        c = new Case(p, false);
                        c.ajouterRessource(r);
                    }
                    // Création des bases
                    if("q".equals(matrix[i][j])) {
                        c = new Case(p, false);
                        casesBases.add(c);
                    }
                    // Création des obstacles
                    else
                        c = new Case(p, true);
                }
                map.put(p,c);
            }
        // End of user code
    }

    public Case getCase(Unite unite) {
        return null;
    }

    public Map getMap() {
        return map;
    }

    public HashSet<Point> getPoints() {
        return points;
    }

    /**
     * Return hauteur.
     * @return hauteur
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Return largeur.
     * @return largeur
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Return largeur.
     * @return largeur
     */
    public Case getCase(Point p) {
        return map.get(p);
    }

    /**
     * Détruit l'unité en question
     * @param dead l'unité qui doit disparaître
     */
    public void detruireUnite(Unite dead) {
        System.out.println("************ Une unité de "+ dead.getBase().getNom() + " est mort ************");
        // On retire l'unité de la case
        dead.getCase().retirerUnite(dead);
        // On retire l'unité de la base
        dead.getBase().removeUnites(dead);
        dead = null;
        //On fait appel au garbage collector
		System.gc();
    }

    /**
     * Renvoie les cases des autres bases
     *
     */
    public ArrayList<Case<Point>> getCasesRessources() {
        ArrayList<Case<Point>> cases = new ArrayList<Case<Point>>();
        for(Ressource r : ressources.keySet()) {
            cases.add(ressources.get(r));
        }
        return cases;
    }
    // End of user code
}