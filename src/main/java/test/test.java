package test;

import agents.Attaquant;
import agents.Base;
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
     //  Attaquant u2 = new Attaquant(b1,20,5,1,1,1,5,c.getCase(new Point(1,1)),c,1);
     //  Attaquant u3 = new Attaquant(b1,20,5,1,1,1,5,c.getCase(new Point(1,5)),c,1);
        Attaquant u4 = new Attaquant(b2,20,5,1,1,1,5,c.getCase(new Point(2,3)),c,1);
      //  Attaquant u5 = new Attaquant(b2,20,5,1,1,1,5,c.getCase(new Point(5,5)),c,1);

       for(int i=0;i<10;i++) {
           System.out.println("\ntour de 1)");
           u1.reagir();
         //  System.out.println("\ntour de 2");
         //  u2.reagir();
          // System.out.println("\ntour de 3)");
         //  u3.reagir();
           System.out.println("\ntour de 4)");
           u4.reagir();
          // System.out.println("\ntour de 5)");
         //  u5.reagir();


       }

    }
}