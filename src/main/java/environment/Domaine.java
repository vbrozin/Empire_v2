package environment;

import java.awt.*;
import java.util.HashSet;

/**
 * Created by sylvainchen on 14/03/2014.
 */
public class Domaine {
    private Case<Point> caseBase;
    private HashSet<Case<Point>> casesUnitesLibres = new HashSet<Case<Point>>();
    private HashSet<Case<Point>> casesDefenses = new  HashSet<Case<Point>>();

    public Domaine() {
    }

    public Case<Point> getCaseBase() {
        return caseBase;
    }

    public void setCaseBase(Case<Point> caseBase) {
        this.caseBase = caseBase;
    }

    public HashSet<Case<Point>> getCasesUnitesLibres() {
        return casesUnitesLibres;
    }

    public void addCasesUnitesLibres(Case<Point> cas) {
        casesUnitesLibres.add(cas);
    }

    public HashSet<Case<Point>> getCasesDefenses() {
        return casesDefenses;
    }

    public void addCasesDefenses(Case<Point> cas) {
        casesDefenses.add(cas);
    }


}
