package gui;

import agents.Base;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by sylvainchen on 20/03/2014.
 */
public class VueBase extends JLabel implements Observer {

    private Base base;
    private int choix;

    public VueBase(Base b){
        // Start of user code for the default constructor
        super();
        // Attributes TODO
        this.base = b;
        this.choix = 0;
        initialiser();
        // End of user code for the default constructor
    }

    public VueBase(Base b, int choix){
        // Start of user code for the default constructor
        super();
        // Attributes TODO
        this.base = b;
        this.choix = choix;
        initialiser();
        // End of user code for the default constructor
    }

// Start of user code for parameterized constructors
// End of user code for parameterized constructors

// Methods

    /**
     * initialisation<br />
     *
     */
    private void initialiser() {
        // Start of user code for VueJoueur.initialiser[]
        // TODO
        if (base != null)
        { // mvc
            base.addObserver(this);
        }
        Color c = new Color(174,174,174);
        this.setOpaque(true);
        this.setBackground(c);
        this.setFont(new Font("Times New Roman", 20, 20));
        this.setForeground(Color.BLACK);
        this.setHorizontalAlignment(JLabel.CENTER);
        afficher();
        // End of user code
    }

    /**
     * affichage du nom, du score et de la couleur du joueur<br />
     *
     */
    protected void afficher() {
        // Start of user code for VueJoueur.afficher[]
        // TODO
        if(base.getCase().getUnites().size() == 0) {
            if(choix == 0)
                setText(base.getNom() + " a perdu");
            else
                setText("");
        }

        else {
            if(choix == 0) {
                String choix0 = base.getNom()  + " (bois = " + base.getBois() + ", nourriture = " + base.getNourriture() + ")";
                setText(choix0);
            }
            else {
                String choix1 = " (defenseurs = "+ base.getDefenseurs().size() + ", recolteurs = " + base.getRecolteurs().size() + ")";
                setText(choix1);
            }
        }

        // End of user code
    }

// Methods for implemented interfaces


    /**
     * {@inheritDoc}<br />
     * Method for implemented interface : java.util.Observer
     * @see java.util.Observer#update
     */
    public void update(Observable o, Object arg) {
        // Start of user code for VueJoueur.update[Observable, Object]
        // TODO
        afficher();
        // End of user code
    }
}