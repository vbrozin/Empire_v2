package environment;

import java.util.Collection;

/**
 * Created by sylvainchen on 28/02/14.
 */
public interface Successeurs<T> {

    /**
     * Renvoit une collection des index successeurs du noeuds passés en
     * paramètres. Attention, les successeurs ne doivent pas etre parmi les
     * parents du noeud paramètre
     *
     * @param node
     *            le noeud dont on veut les successeurs
     * @return la liste des successeurs du noeuds
     */
    Collection<T> computeSuccessor(Noeud<T> node);

}
