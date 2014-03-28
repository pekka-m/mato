package matotesti;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author H3173
 */
public class Mato extends JPanel{
 private final int borderx = 690;
    private final int bordery = 530;
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int safkax;
    private int safkay;
    private boolean törmäys;
    private boolean seinä;
    private int pisteet = 0;
    private int madonpituus = 3;
    // taulukoihin tallennetaan madon osien x ja y koordinaatit
    private ArrayList<Integer> madonosatx = new ArrayList<>();
    private ArrayList<Integer> madonosaty = new ArrayList<>();
    private JLabel häviöteksti;
    private JLabel ennätys;
    private Thread thread;
    private Random arpoja = new Random();
    private int vikay;
    private int tokavikay;
    private int vikax;
    private int tokavikax;
    private String suunta;
    private Graphics Graphics;
    
    public void testi() {
        System.out.println("TESTI");
        this.paintComponent(Graphics);
    }
 @Override
    public void paintComponent(Graphics g) {
    System.out.println("TESTIIIIII");
        // mahdollisesti affinetransform juttua käytetään kuvan kääntämiseen
        paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(20, 20, 20, 20);
/*
        // madon pää
        if (dx == 20 && dy == 0) {
            Image madonpää = Toolkit.getDefaultToolkit().getImage("madonpaa-oikea.png");
            g.drawImage(madonpää, x, y, null);
        } else if (dx == 0 && dy == 20) {
            Image madonpää = Toolkit.getDefaultToolkit().getImage("madonpaa-alas.png");
            g.drawImage(madonpää, x, y, null);
        } else if (dx == -20 && dy == 0) {
            Image madonpää = Toolkit.getDefaultToolkit().getImage("madonpaa-vasen.png");
            g.drawImage(madonpää, x, y, null);
        } else if (dx == 0 && dy == -20) {
            Image madonpää = Toolkit.getDefaultToolkit().getImage("madonpaa-ylos.png");
            g.drawImage(madonpää, x, y, null);
        }

        // piirretään madon keskiosa, pituus muuttujasta madonpituus, koordinaatit taulukoista
        for (int i = 0; i < madonpituus - 1; i++) {
            Image madonruho = Toolkit.getDefaultToolkit().getImage("madonruho.png");
            g.drawImage(madonruho, madonosatx.get(i), madonosaty.get(i), null);
        }

        // madon jalat
        if (vikay == tokavikay) {
            if (vikax < tokavikax) {
                Image madonjalat = Toolkit.getDefaultToolkit().getImage("madonjalat-oikea.png");
                g.drawImage(madonjalat, madonosatx.get(madonpituus - 1), madonosaty.get(madonpituus - 1), null);
            } else {
                Image madonjalat = Toolkit.getDefaultToolkit().getImage("madonjalat-vasen.png");
                g.drawImage(madonjalat, madonosatx.get(madonpituus - 1), madonosaty.get(madonpituus - 1), null);
            }
        } else {
            if (vikay < tokavikay) {
                Image madonjalat = Toolkit.getDefaultToolkit().getImage("madonjalat-alas.png");
                g.drawImage(madonjalat, madonosatx.get(madonpituus - 1), madonosaty.get(madonpituus - 1), null);
            } else {
                Image madonjalat = Toolkit.getDefaultToolkit().getImage("madonjalat-ylos.png");
                g.drawImage(madonjalat, madonosatx.get(madonpituus - 1), madonosaty.get(madonpituus - 1), null);
            }
        }*/
        repaint();

    }
}
