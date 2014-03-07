package agents;

/**
 * Created by sylvainchen on 27/02/14.
 */
public class Agent{
    protected int pv;


    public Agent(int pv) {
        this.pv = pv;
    }

    /**
     * Return pv.
     * @return pv
     */
    public int getPv() {
        return pv;
    }

    /**
     * Set a value to attribute pv.
     * @param pv
     */
    public void setPv(int pv) {
        this.pv = pv;
    }
    /**
     * Description of the method reagir.
     * action réactive de l'agent
     */
    public void reagir() {

    }
}
