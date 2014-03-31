package gui;

/**
 * Created by sylvainchen on 20/03/2014.
 */
//Start of user code for imports
import agents.Base;
import java.awt.GridLayout;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;
//End of user code for imports

/**
 * Class EtatBases<br />
 * Composant agrégeant l'ensemble des vues des joueurs du jeu.<br />
 * Les mises à jours sont faites pas les vues des joueurs<br />
 *
 * @author sylvainchen
 */
public class EtatBases extends JPanel {

    // Owned attributes
    private List<VueBase> vuesBases;

    // Attributes from associations
    /** liste des joueurs du jeu */
    private List<Base> bases;

    // Start of user code for extra fields
    // End of user code for extra fields

    // Start of user code for parameterized constructors
    // End of user code for parameterized constructors

    // Methods

    /**
     * initialisation<br />
     *
     */
    private void initialiser() {
        // Start of user code for EtatBases.initialiser[]
        this.vuesBases = new ArrayList<VueBase>();
        if (bases != null)
        {
            vuesBases.add(new VueBase(bases.get(0)));
            vuesBases.add(new VueBase(bases.get(0),1));
            vuesBases.add(new VueBase(bases.get(1)));
            vuesBases.add(new VueBase(bases.get(1),1));
        }
        mettreEnPage();
        // TODO
        // End of user code
    }

    /**
     * mise en page<br />
     *
     */
    protected void mettreEnPage() {
        // Start of user code for EtatBases.mettreEnPage[]
        GridLayout etatJoueurLayout = new GridLayout(4,1);
        this.setLayout(etatJoueurLayout);
        for (VueBase vb : vuesBases)
        {
            add(vb);
        }
        // End of user code
    }

    /**
     * constructeur paramétré<br />
     *
     * @param bases
     */
    public EtatBases(List<Base> bases) {
        // Start of user code for EtatBases.EtatBases[List<Base>]
        super();
        // Attributes TODO
        this.bases = bases;
        initialiser();
        // End of user code
    }

    // Methods for implemented interfaces

    // Methods for abstract methods from superclass

    // Start of user code for extra methods
    // End of user code for extra methods

}
