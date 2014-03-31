package gui;

import agents.*;
import environment.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sylvainchen on 26/02/14.
 */
public class GridOfSprites extends JFrame{

    public static void main(String[] args) {
        GridOfSprites g = new GridOfSprites();
        g.afficher();
    }


    private BufferedImage[] sprites;
    private JFrame window;
    private MyCanvas canvas;
    private int boxSize = 30,
            width = 0,
            height = 0;
    private Base b;
    private Base b2;
    private Carte c;
    private JButton bouton = new JButton();
    private ArrayList<Base> bases;
    private Jeu jeu;
    private Carte carte;
    private ArrayList<String> names;
    /*
    * m bois
    * n nourriture
    * a spawn tourelle base
    * b spawn Unitelibre base
    * c base
    *
    * " " caseLibre
    * | obstacle
    *
     */
    final String[][] matrix = new String[][] {

            { " " },
            { " ","|" },
            { " ","|"," " },
            { " ","|","|"," " },
            { " ","|","|"," "," " },
            { " ","n","|"," "," "," " },
            { " ","|"," "," "," ","|"," " },
            { " "," "," "," ","|","|","|"," " },
            { " "," "," "," "," "," ","|"," ","|" },
            { " "," "," "," "," "," "," "," ","|"," " },
            { " "," "," "," "," "," ","|","m","|"," "," " },
            { " "," "," "," "," ","|","|","|","|"," "," "," "},
            { " "," "," "," "," "," ","|","|","n","|"," ","|"," " },
            { "b","b","b","b","b"," "," "," "," ","|"," "," "," "," " },
            { "b","a"," ","a","b"," "," "," "," "," ","|","n"," "," "," " },
            { "b"," ","c"," ","b"," "," "," "," "," "," ","|"," "," "," "," " },
            { "b","a"," ","a","b"," "," "," "," "," "," "," ","|"," "," "," "," " },
            { "b","b","b","b","b"," "," "," "," "," "," "," "," "," "," "," "," "," " },
    };

    /**Constructeur par défaut */
    public GridOfSprites() {
        super();
        names = new ArrayList<String>();
    }

    /**Affichage d'une partie*/
    public void afficher() {
        carte = new Carte(matrix);
        jeu = new Jeu(carte, 1, 3);
        bases = jeu.getBases();
        for(Base b : bases)
            names.add(b.getNom());
        loadSprites();
        width = boxSize*carte.getLargeur();
        height = boxSize*carte.getHauteur();
        window = new JFrame();
        EtatBases etatBases = new EtatBases(bases);
        canvas = new MyCanvas(carte);
        canvas.setPreferredSize(new Dimension(width, height));
        window.getContentPane().add(canvas, BorderLayout.NORTH);
        this.setTitle("Affichage d'une partie");
        etatBases.setPreferredSize(new Dimension(width, height/3));
        window.getContentPane().add(etatBases, BorderLayout.SOUTH);
        window.pack();
        window.setVisible(true);
        int j = 0;
        while(j < 1000 && !jeu.fini() ) {
            jeu.jouer();
            j++;
            window.getContentPane().revalidate();
            window.getContentPane().repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(jeu.fini()) {
            System.out.println(jeu.getBaseGagnante().getNom());
        }

    }

    /*Simulation de 100 parties*/
    public void simuler() {

        //int i = 0;
        int victoires_b1 = 0, victoires_b2 = 0;
        for(int i=0; i<100;i++) {
            Carte carte = new Carte(matrix);
            jeu = new Jeu(carte, 1, 3);
            for(Base b : jeu.getBases())
                names.add(b.getNom());

            int j = 0;
            while(j < 10000 && !jeu.fini() ) {
                jeu.jouer();
                j++;
            }
            if(jeu.fini()) {
                if(jeu.getBaseGagnante().getNom().equals(names.get(0)))
                    victoires_b1++;
                else
                    victoires_b2++;
            }
        }
        System.out.println(victoires_b1);
        System.out.println(victoires_b2);
    }

    private void loadSprites() {
        try {
            sprites = new BufferedImage[11];
            sprites[0] = ImageIO.read(new File("/Users/sylvainchen/git/test-github/empire-v2/Empire_v2/src/main/resources/grass.jpg"));
            sprites[1] = ImageIO.read(new File("/Users/sylvainchen/git/test-github/empire-v2/Empire_v2/src/main/resources/Bricks.jpg"));
            sprites[2] = ImageIO.read(new File("/Users/sylvainchen/git/test-github/empire-v2/Empire_v2/src/main/resources/buche.gif"));
            sprites[3] = ImageIO.read(new File("/Users/sylvainchen/git/test-github/empire-v2/Empire_v2/src/main/resources/food2.png"));
            sprites[4] = ImageIO.read(new File("/Users/sylvainchen/git/test-github/empire-v2/Empire_v2/src/main/resources/grass40.png"));
            sprites[5] = ImageIO.read(new File("/Users/sylvainchen/git/test-github/empire-v2/Empire_v2/src/main/resources/Bricks40.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(GridOfSprites.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

private class MyCanvas extends JPanel {

    private Carte carte;
    public MyCanvas(Carte c) {
        carte = c;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        update(g);
    }

    public void update(Graphics g) {
        drawSprites(g);
        drawGrid(g);

    }
    /* Affichage du quadrillage */
    private void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);

        for (int i = 0; i < carte.getLargeur(); i++) {
            g.drawLine(i * boxSize, 0, i * boxSize, height);

        }
        for (int i = 0; i < carte.getHauteur(); i++) {
            g.drawLine(0, i * boxSize, width, i * boxSize);
        }
    }
    /* Affichage des sprites*/
    private void drawSprites(Graphics g) {
        Map<Point, Case> map = carte.getMap();
        for(Point p : carte.getPoints()) {
            Case c = map.get(p);
            if(c.getRessource() != null) {
                if (c.getRessource().getTypeRessource() == TypeRessource.BOIS) {
                    g.drawImage(sprites[4], boxSize * (int)p.getX(), boxSize * (int)p.getY(), null);
                    g.drawImage(sprites[2], boxSize * (int)p.getX(), boxSize * (int)p.getY(), null);
                }
                if (c.getRessource().getTypeRessource() == TypeRessource.NOURRITURE) {
                    g.drawImage(sprites[4], boxSize * (int)p.getX(), boxSize * (int)p.getY(), null);
                    g.drawImage(sprites[3], boxSize * (int)p.getX(), boxSize * (int)p.getY(), null);
                }

            }
            else {
                if(c.estObstacle())
                    g.drawImage(sprites[5], boxSize * (int)p.getX(), boxSize * (int)p.getY(), null);
                else {
                    if(c.getUnites().size() > 0) {
                        IAgent unite = c.getUnite(0);
                        String className = unite.getClass().getSimpleName();
                        if(className.equals("Recolteur")) {
                            if(unite.getBase().getNom().equals(names.get(0)))
                                g.setColor(Color.blue);
                            else
                                g.setColor(Color.red);
                            g.fillRect(boxSize * (int)p.getX(), boxSize * (int)p.getY(), boxSize, boxSize);
                        }
                        if(className.equals("Attaquant")) {
                            if(unite.getBase().getNom().equals(names.get(0)))
                                g.setColor(Color.cyan);
                            else
                                g.setColor(Color.orange);
                            g.fillRect(boxSize * (int)p.getX(), boxSize * (int)p.getY(), boxSize, boxSize);
                        }
                        if(className.equals("Defenseur")) {
                            if(unite.getBase().getNom().equals(names.get(0)))
                                g.setColor(new Color(159,232,85));
                            else
                                g.setColor(new Color(161,6,132));
                            g.fillRect(boxSize * (int)p.getX(), boxSize * (int)p.getY(), boxSize, boxSize);
                        }
                        if(className.equals("Base")) {
                            if(unite.getBase().getNom().equals(names.get(0))) {
                                g.setColor(Color.white);
                            }
                            else
                                g.setColor(Color.black);
                            g.fillRect(boxSize * (int)p.getX(), boxSize * (int)p.getY(), boxSize, boxSize);
                        }
                    }
                    else
                        g.drawImage(sprites[4], boxSize * (int)p.getX(), boxSize * (int)p.getY(), null);
                }

            }
        }
    }


}
}