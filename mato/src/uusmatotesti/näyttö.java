package uusmatotesti;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author H3173
 */
public class näyttö extends JPanel {

    private final int borderx = 690;
    private final int bordery = 530;
    private int x;
    private int y;
    private int safkax;
    private int safkay;
    private boolean törmäys;
    private boolean seinä;
    private final JLabel ennätys;
    private int pisteet = 0;
    private int madonpituus = 3;
    // taulukoihin tallennetaan madon osien x ja y koordinaatit
    private final ArrayList<Integer> madonosatx = new ArrayList<>();
    private final ArrayList<Integer> madonosaty = new ArrayList<>();
    private JLabel häviöteksti;

    // pääohjelman puolelta kutsutaan näitä aina liikkumisen yhteydessä
    // lisätään taulukoihin edelliset koordinaatit ennen liikkumista
    // taulukoista poistetaan viimeiset koordinaatit (madon pituus)
    public void addMadonosatx() {
        this.madonosatx.add(0, x); // lisätään koordinaatit ensimmäiseen paikkaan, muut työntyy eteenpäin
        if (madonosatx.size() == madonpituus) {
            madonosatx.remove(madonpituus);
        }
    }

    public void addMadonosaty() {
        this.madonosaty.add(0, y);
        if (madonosaty.size() == madonpituus) {
            madonosaty.remove(madonpituus);
        }
    }

    public näyttö() {
        setPreferredSize(new Dimension(borderx, bordery));
        setBackground(Color.gray);
        x = 320;
        y = 240;

        // pelin alussa alustetaan madonosataulukon kaikki paikat
        for (int i = 0; i < 3; i++) {
            madonosatx.add(320);
            madonosaty.add(240);
        }

        // arvotaan ensimmäinen safka
        
        arpoja();
        ennätys = new JLabel();

        add(ennätys);
        ennätys.setText("pisteet: 0");

    }

    public void siirrä(int dx, int dy) {
        if (y == 20 && dy == -20) {
            if (seinä == false) {
                System.out.println("HÄVISIT PELIN!");
                hävisitTeksti();
            }
            seinä = true;
        } else if (x == 660 && dx == 20) {
            if (seinä == false) {
                System.out.println("HÄVISIT PELIN!");
                hävisitTeksti();
            }
            seinä = true;
        } else if (y == 500 && dy == 20) {
            if (seinä == false) {
                System.out.println("HÄVISIT PELIN!");
                hävisitTeksti();
            }
            seinä = true;
        } else if (x == 20 && dx == -20) {
            if (seinä == false) {
                System.out.println("HÄVISIT PELIN!");
                hävisitTeksti();
            }
            seinä = true;
        }

        if (seinä == false) {
            // näytetään madon x ja y koordinaatit
            System.out.print("x: " + äksä() + " ");
            System.out.print("y: " + yyyy() + "\n");

            // lisätään koordinaatit ensimmäiseen paikkaan, muut työntyy eteenpäin
            this.madonosatx.add(0, x);
            if (madonosatx.size() == madonpituus) {
                madonosatx.remove(madonpituus);
            }
            this.madonosaty.add(0, y);
            if (madonosaty.size() == madonpituus) {
                madonosaty.remove(madonpituus);
            }

            // liikuttaa matoa
            x += dx;
            y += dy;

            //ollaanko törmätty safkaan
            this.törmäys = (x == safkax) & (y == safkay);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(x, y, 20, 20);
        g.fillRect(0, 0, 700, 20); // yläseinä
        g.fillRect(0, 0, 20, 540);
        g.fillRect(680, 0, 20, 540);
        g.fillRect(0, 520, 700, 20);



        if (this.x == 0) {
            g.fillRect(0, 0, 40, 40);
        }

        // piirretään madon osat, pituus muuttujasta madonpituus, koordinaatit taulukoista
        for (int i = 0; i < madonpituus; i++) {
            g.fillRect(madonosatx.get(i), madonosaty.get(i), 20, 20);
        }

        g.setColor(Color.red);
        this.repaint();

        if (törmäys) {
            arpoja();
            g.fillRect(safkax, safkay, 20, 20);
            this.pisteet += 1;
            ennätys.setText("pisteet: " + pisteet);
            törmäys = false;

            // aina safkatessa madon pituutta lisätään yhdellä
            madonpituus++;
        } else {
            g.fillRect(safkax, safkay, 20, 20);
        }
    }

    private void arpoja() {
        Random arpoja = new Random();
        this.safkax = arpoja.nextInt(31) * 20;
        this.safkay = arpoja.nextInt(23) * 20;
    }
    
    private void hävisitTeksti() {
        Font f = new Font("Dialog", Font.PLAIN, 24);
        häviöteksti = new JLabel();
        add(häviöteksti);
        häviöteksti.setText("Hävisit pelin!");
        häviöteksti.setSize(400, 100);
        häviöteksti.setFont(f);
        häviöteksti.setForeground(Color.red);
//        häviöteksti.set
        
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // helpottaa koodin vääntämistä, output ikkunaan päivittyy madon koordinaatit
    public int äksä() {
        return this.x;
    }

    public int yyyy() {
        return this.y;
    }
}
