package agents;

import environment.Case;

import java.awt.*;

/**
 * Created by sylvainchen on 26/02/14.
 */
public interface IAgent {
    /**
     *  Description of the method reagir.
     *  action réactive de l'agent
     *
     */
    public void reagir();

    public Case<Point> getCase();

    public Base getBase();

    public void subirDegats(int b);

    public int getPvRestant();
}
