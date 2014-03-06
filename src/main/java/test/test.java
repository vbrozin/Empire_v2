package test;

import agents.Attaquant;
import agents.Base;
import agents.Unite;
import environment.Carte;
import environment.Jeu;

import java.awt.*;

/**
 * Created by val on 02/03/14.
 */
public class test {

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
        Base b1 = new Base(20,20,50,"blue",c);
        Base b2 = new Base(20,20,50,"red",c);
        Attaquant u1 = new Attaquant(b1,20,5,1,1,1,5,c.getCase(new Point(4,4)),c,1);
        Attaquant u4 = new Attaquant(b2,20,5,1,1,1,5,c.getCase(new Point(2,3)),c,1);

       while(b1.getUnites().size() > 0 && b2.getUnites().size() > 0) {
            System.out.println("tour de 1)");
            Attaquant at = (Attaquant) b1.getUnites().get(0);
            at.reagir();
            at = (Attaquant) b2.getUnites().get(0);
            at.reagir();
       }
    }
}