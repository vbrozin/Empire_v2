package gui;

import agents.Attaquant;
import agents.Base;
import environment.Carte;
import environment.Case;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sylvainchen on 26/02/14.
 */
public class GridOfSprites extends JFrame implements ActionListener{

    public static void main(String[] args) {
        new GridOfSprites();
    }
    BufferedImage[] sprites;
    Image lune;
    JFrame window;
    MyCanvas canvas;
    int boxSize = 20,
            width = 0,
            height = 0;
    private Base b;
    private Base b2;
    private Carte c;
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

    public GridOfSprites() {
        Carte carte = new Carte(matrix);
        Base b1 = new Base(20,20,50,"blue",carte, carte.getCase(new Point(0,0)));
        int x = carte.getLargeur()-1;
        int y = carte.getHauteur()-1;
        //Base b2 = new Base(20,20,50,"red",carte, carte.getCase(new Point(1, 0)));
        b1.creerMele();
        //b2.creerMele();
        //Attaquant u3 = new Attaquant(b1,20,5,1,1,1,5,c.getCase(new Point(1,0)),c,1);
        //Attaquant u5 = new Attaquant(b2,20,5,1,1,1,5,c.getCase(new Point(x-1,y-1)),c,1);
        //Attaquant u6 = new Attaquant(b2,20,5,1,1,1,5,c.getCase(new Point(x-1,y)),c,1);
        loadSprites();
        width = boxSize*carte.getLargeur();
        height = boxSize*carte.getHauteur();
        window = new JFrame();
        canvas = new MyCanvas(carte);
        canvas.setPreferredSize(new Dimension(width, height));
        window.getContentPane().add(canvas);
        window.pack();
        window.setVisible(true);
    }

    private void loadSprites() {
        try {
            sprites = new BufferedImage[3];
            sprites[0] = ImageIO.read(new File("/Users/sylvainchen/git/test-github/empire-v2/Empire_v2/src/main/resources/grass.jpg"));
            sprites[1] = ImageIO.read(new File("/Users/sylvainchen/git/test-github/empire-v2/Empire_v2/src/main/resources/Bricks.jpg"));
            sprites[2] = ImageIO.read(new File("/Users/sylvainchen/git/test-github/empire-v2/Empire_v2/src/main/resources/ez.png"));
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
            drawGrid(g);
            drawSprites(g);
        }

        private void drawGrid(Graphics g) {
            g.setColor(Color.BLACK);

            for (int i = 0; i < carte.getLargeur(); i++) {
                g.drawLine(i * boxSize, 0, i * boxSize, height);

            }
            for (int i = 0; i < carte.getHauteur(); i++) {
                g.drawLine(0, i * boxSize, width, i * boxSize);
            }
        }

        private void drawSprites(Graphics g) {
            Map<Point, Case> map = carte.getMap();
            for(Point p : carte.getPoints()) {
                Case c = map.get(p);
                if(c.estObstacle())
                    g.drawImage(sprites[1], boxSize * (int)p.getX(), boxSize * (int)p.getY(), null);
                else
                    if(c.getUnites().size() > 0)
                        g.drawImage(sprites[2], boxSize * (int)p.getX(), boxSize * (int)p.getY(), null);
                    else
                        g.drawImage(sprites[0], boxSize * (int)p.getX(), boxSize * (int)p.getY(), null);
            }
            //g.drawImage(sprites[0], boxSize * 5, boxSize * 3, null);
            //g.drawImage(sprites[1], boxSize * 2, boxSize * 1, null);
            //g.drawImage(sprites[1], boxSize * 7, boxSize * 9, null);
        }
    }





    public void jouer() {

    }


    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
