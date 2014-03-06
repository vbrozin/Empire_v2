package test;

import agents.Base;
import environment.Carte;
import environment.Jeu;

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

        Base b1 = new Base(20,20,50,"blue",c);
        Base b2 = new Base(20,20,50,"red",c);
        bases.add(b1);
        bases.add(b2);
        Jeu jeu=new Jeu(c, bases);
        int t = 0;
        while(t < 100 || !jeu.fini()) {
            jeu.jouer();
            t++;
        }


    }
}
