package environment;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by sylvainchen on 14/03/2014.
 */
public class Domaine {
    private Case<Point> caseBase;
    private ArrayList<Case<Point>> casesUnitesLibres = new ArrayList<Case<Point>>();
    private ArrayList<Case<Point>> casesDefenses = new  ArrayList<Case<Point>>();

    public Domaine() {
    }

    public Case<Point> getCaseBase() {
        return caseBase;
    }

    public void setCaseBase(Case<Point> caseBase) {
        this.caseBase = caseBase;
    }

    public ArrayList<Case<Point>> getCasesUnitesLibres() {
        return casesUnitesLibres;
    }

    public void addCasesUnitesLibres(Case<Point> cas) {
        casesUnitesLibres.add(cas);
    }

    public ArrayList<Case<Point>> getCasesDefenses() {
        return casesDefenses;
    }

    public void addCasesDefenses(Case<Point> cas) {
        casesDefenses.add(cas);
    }


}
