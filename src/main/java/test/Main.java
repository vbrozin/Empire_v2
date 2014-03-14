package test;

import agents.Attaquant;
import agents.Base;
import environment.Carte;
import environment.Case;
import environment.Jeu;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by sylvainchen on 27/02/14.
 */
public class Main {
    public static void main(String[] args) {
        String[][] matrix = new String[][] {
                { " "," "," "," "," "," "," "," "},
                { " "," "," "," "," "," "," "," "},
                { " "," "," "," "," "," "," "," "},
                { " "," ","|"," "," "," "," "," "},
                { " "," ","|"," "," "," "," "," "},
                { " "," "," "," "," "," "," "," "},
        };
        Carte c = new Carte(matrix);

        ArrayList<Base> bases = new ArrayList<Base>();
        Case<Point> maCase = c.getCase(new Point(0,0));
        Base b1 = new Base(20,20,50,"blue",c, c.getCase(new Point(0,0)));
        int x = c.getLargeur()-1;
        int y = c.getHauteur()-1;
        Base b2 = new Base(20,20,50,"red",c, c.getCase(new Point(x, y)));
        //Attaquant u3 = new Attaquant(b1,20,5,1,1,1,5,c.getCase(new Point(1,0)),c,1);
        //Attaquant u5 = new Attaquant(b2,20,5,1,1,1,5,c.getCase(new Point(x-1,y-1)),c,1);
        //Attaquant u6 = new Attaquant(b2,20,5,1,1,1,5,c.getCase(new Point(x-1,y)),c,1);
        bases.add(b1);
        bases.add(b2);
        Jeu jeu=new Jeu(c, bases);
        int t = 0;
        while(t < 50 && !jeu.fini()) {
            jeu.jouer();
            t++;
        }
        System.out.println(t);
        System.out.println(b1.getUnites().size());
        System.out.println(b2.getUnites().size());


    }
}
