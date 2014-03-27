package uusmatotesti;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 * 
 *
 * @author H3173
 */
public class näyttö extends JPanel implements Runnable{

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
    private final JLabel ennätys;
    private int pisteet = 0;
    private int madonpituus = 10;
    // taulukoihin tallennetaan madon osien x ja y koordinaatit
    private final ArrayList<Integer> madonosatx = new ArrayList<>();
    private final ArrayList<Integer> madonosaty = new ArrayList<>();
    private JLabel häviöteksti;
    private Thread thread;
    private Random arpoja = new Random();
    private int vikay;
    private int tokavikay;
    private int vikax;
    private int tokavikax;

    public näyttö() {
        setPreferredSize(new Dimension(borderx, bordery));
        setBackground(Color.black);
        x = 320;
        y = 240;

        // pelin alussa alustetaan madonosataulukon kaikki paikat
        for (int i = 0; i < madonpituus; i++) {
            madonosatx.add(320);
            madonosaty.add(240);
        }
        vikay = madonosaty.get(madonpituus - 1);
        tokavikay = madonosaty.get(madonpituus - 2);
        vikax = madonosatx.get(madonpituus - 1);
        tokavikax = madonosatx.get(madonpituus - 2);
        SuunnanArpoja();

        // arvotaan ensimmäinen safka
        arpoja();
        ennätys = new JLabel();

        add(ennätys);
        ennätys.setText("pisteet: 0");

       thread = new Thread(this);
     thread.start();

    }

    /**
     *
     * @param dx direction x
     * @param dy direction y
     */
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

            // lisätään koordinaatit ensimmäiseen paikkaan, muut työntyy eteenpäin
            this.madonosatx.add(0, x);
            if (madonosatx.size() == madonpituus) {
                madonosatx.remove(madonpituus);
            }
            this.madonosaty.add(0, y);
            if (madonosaty.size() == madonpituus) {
                madonosaty.remove(madonpituus);
            }
            vikay = madonosaty.get(madonpituus - 1);
            tokavikay = madonosaty.get(madonpituus - 2);
            vikax = madonosatx.get(madonpituus - 1);
            tokavikax = madonosatx.get(madonpituus - 2);
            this.dx = dx;
            this.dy = dy;
            // liikuttaa matoa
            x += dx;
            y += dy;

            System.out.print("x: " + äksä() + " ");
            System.out.print("y: " + yyyy() + "\n");
            System.out.println(madonpituus);

            for (int i = 0; i < madonpituus; i++) {

                System.out.println(madonosatx.get(i));
                System.out.println(madonosaty.get(i));

                if ((madonosatx.get(i) == x) && (madonosaty.get(i) == y)) {
                    System.out.println("Hävisit pelin!");
                    seinä = true;
                    hävisitTeksti();
                }
            }

            //ollaanko törmätty safkaan
            this.törmäys = (x == safkax) & (y == safkay);
        }
    }

    @Override
    public void run() {
        while (true) {
            siirrä(dx, dy);
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }

    }
    @Override
    public void paintComponent(Graphics g) {
        // mahdollisesti affinetransform juttua käytetään kuvan kääntämiseen
        super.paintComponent(g);

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
        
        // yläseinä jne
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, 700, 20);
        g.fillRect(0, 0, 20, 540);
        g.fillRect(680, 0, 20, 540);
        g.fillRect(0, 520, 700, 20);

        // piirretään madon keskiosa, pituus muuttujasta madonpituus, koordinaatit taulukoista
        for (int i = 0; i < madonpituus-1; i++) {
            Image madonruho = Toolkit.getDefaultToolkit().getImage("madonruho.png");
            g.drawImage(madonruho, madonosatx.get(i), madonosaty.get(i), null);
        }

        // madon jalat
        if (vikay == tokavikay) {
            if (vikax < tokavikax) {
                Image madonjalat = Toolkit.getDefaultToolkit().getImage("madonjalat-oikea.png");
                g.drawImage(madonjalat, madonosatx.get(madonpituus-1), madonosaty.get(madonpituus-1), null);
            }
            else {
                Image madonjalat = Toolkit.getDefaultToolkit().getImage("madonjalat-vasen.png");
                g.drawImage(madonjalat, madonosatx.get(madonpituus-1), madonosaty.get(madonpituus-1), null);
            }
        }
        else {
            if (vikay < tokavikay) {
                Image madonjalat = Toolkit.getDefaultToolkit().getImage("madonjalat-alas.png");
                g.drawImage(madonjalat, madonosatx.get(madonpituus-1), madonosaty.get(madonpituus-1), null);
            }
            else {
                Image madonjalat = Toolkit.getDefaultToolkit().getImage("madonjalat-ylos.png");
                g.drawImage(madonjalat, madonosatx.get(madonpituus-1), madonosaty.get(madonpituus-1), null);
            }
        }
        this.repaint();
        Image apple = Toolkit.getDefaultToolkit().getImage("apple.png");
        if (törmäys) {
            arpoja();
           // g.fillRect(safkax, safkay, 20, 20);  
            g.drawImage(apple, safkax, safkay, null);
            this.pisteet += 1;
            ennätys.setText("pisteet: " + pisteet);
            törmäys = false;

            // aina safkatessa madon pituutta lisätään yhdellä
            madonpituus++;
        } else {
            g.drawImage(apple, safkax, safkay, null);
        }
    }

    private void arpoja() {

        this.safkax = arpoja.nextInt(31) * 20 + 20;
        this.safkay = arpoja.nextInt(23) * 20 + 20;
    }

    private void SuunnanArpoja() {
        int suunta = arpoja.nextInt(4);

        //oikea
        if (suunta == 0) {
            siirrä(20, 0);
        }
        //vasen
        if (suunta == 1) {
            siirrä(-20, 0);
        }
        //ylös
        if (suunta == 2) {
            siirrä(0, -20);
        }
        //alas
        if (suunta == 3) {
            siirrä(0, 20);
        }

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
