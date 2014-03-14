package test;

import agents.Attaquant;
import agents.Base;
import agents.Recolteur;
import environment.Carte;

import java.awt.*;

/**
 * Created by sylvainchen on 06/03/2014.
 */
public class testRessource {

    public static void main(String[] args) {
        String[][] matrix = new String[][] {
                { " "," "," "," "," "," "," "," "},
                { " "," "," "," "," "," "," "," "},
                { " "," "," "," "," "," "," "," "},
                { " "," ","|"," "," "," "," "," "},
                { " "," ","|"," "," "," "," "," "},
                { " "," "," "," "," "," "," "," "},
        };
        System.out.println(matrix[0].length + "  " + matrix.length);
        Carte c = new Carte(matrix);
        Base b1 = new Base(20,20,50,"blue",c, c.getCase(new Point(0,0)));
        Base b2 = new Base(20,20,50,"red",c, c.getCase(new Point(c.getLargeur()-1,c.getHauteur()-1)));
        Recolteur u1 = new Recolteur(b1,20,5,1,5,c.getCase(new Point(4,4)),c,100);
        Recolteur u2 = new Recolteur(b1,20,5,1,5,c.getCase(new Point(4,4)),c,100);

        while(b1.getUnites().size() > 0 && b2.getUnites().size() > 0) {
            System.out.println("tour de 1)");
            Recolteur at = (Recolteur) b1.getUnites().get(0);
            at.reagir();
            at = (Recolteur) b2.getUnites().get(0);
            at.reagir();
        }
    }
}
