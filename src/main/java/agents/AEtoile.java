package agents;

import environment.Noeud;
import environment.FabriqueNoeud;
import environment.Successeurs;

import java.util.*;

/**
 * Created by sylvainchen on 28/02/14.
 */
public class AEtoile<T> {

    private final Successeurs<T> successorComputer;
    private final FabriqueNoeud<T> fabriqueNoeud;

    private final Queue<Noeud<T>> paths = new PriorityQueue<Noeud<T>>();
    private final Map<T, Double> distancesMinimum = new HashMap<T, Double>();

    /**
     * Instancie un nouveau calculateur de chemin par algorithme A*
     *
     * @param successorComputer
     *            le fournisseur de l'algorithme calculant les successeurs
     * @param fabriqueNoeud
     *            le créateur du noeud
     */
    public AEtoile(final Successeurs<T> successorComputer, final FabriqueNoeud<T> fabriqueNoeud) {
        if (fabriqueNoeud == null || successorComputer == null) {
            throw new IllegalArgumentException("Les 2 paramètres de A* doivent etre non null");
        }
        this.successorComputer = successorComputer;
        this.fabriqueNoeud = fabriqueNoeud;
    }

    /**
     * Rempli les paths possibles autour du noeud spécifié
     *
     * @param node
     *            le noeud autour duquel on teste les voies
     * @param goal
     *            la destination finale
     */
    private void etendre(final Noeud<T> node, final T goal) {
        final T p = node.getIndex();
        final Double minimum = distancesMinimum.get(p);

        final double nodeF = node.getF();
        if (minimum == null || minimum > nodeF) {
            distancesMinimum.put(p, nodeF);

            final Collection<T> successorsCollection = successorComputer.computeSuccessor(node);
            for (final T t : successorsCollection) {
                final Noeud<T> newNode = fabriqueNoeud.instanciateNode(node, t, goal);
                if (newNode != null) {
                    paths.add(newNode);
                }
            }

        }
    }

    /**
     * Renvoit la liste des noeuds représentant le parcours optimisé par A*
     *
     * @param start
     *            le point de départ
     * @param goal
     *            le point d'arrivée espéré
     * @return la liste des index dans l'ordre représentant le trajet entre les
     *         2 points
     */
    public List<T> calculer(final T start, final T goal) {
        final Noeud<T> root = fabriqueNoeud.instanciateNode(null, start, goal);
        etendre(root, goal);
        while (true) {
            final Noeud<T> p = paths.poll();
            if (p == null) {
                return new ArrayList<T>();
            }

            final T last = p.getIndex();

            if (last.equals(goal)) {
                final LinkedList<T> result = new LinkedList<T>();
                for (Noeud<T> i = p; i != null; i = i.getParent()) {
                    result.addFirst(i.getIndex());
                }
                return result;
            }
            etendre(p, goal);
        }
    }
}