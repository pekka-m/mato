package uusmatotesti;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 *  MATO
 *
 * @version 0.51
 * @author Pekka M, Aleksi O
 * @since 2014-03-07
 */
public class näyttö extends JPanel implements Runnable{

    Mato mato = new Mato();
    private final int borderx = 690;
    private final int bordery = 530;
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int safkax;
    private String suunta;
//    private Mato mato;

    public int getSafkax() {
        return safkax;
    }

    public int getSafkay() {
        return safkay;
    }
    private int safkay;
//    private boolean törmäys;
//    private boolean seinä;
    private int pisteet = 0;
//    private int madonpituus = 3;
    // taulukoihin tallennetaan madon osien x ja y koordinaatit
//    private ArrayList<Integer> madonosatx = new ArrayList<>();
//    private ArrayList<Integer> madonosaty = new ArrayList<>();
    private JLabel häviöteksti;
    private JLabel ennätys;
    private Thread thread;
    private Random arpoja = new Random();
//    private int vikay;
//    private int tokavikay;
//    private int vikax;
//    private int tokavikax;
//    private String suunta;

    /**
     * Tällä vaihdetaan madon suuntaa
     *
     * @param suunta vasen, oikea, ylös, alas
     */
    /*
     public void setSuunta(String suunta) {
     if ("ylos".equals(this.suunta) && "alas".equals(suunta)) {
     this.suunta = "ylos";
     } else if ("oikea".equals(this.suunta) && "vasen".equals(suunta)) {
     this.suunta = "oikea";
     } else if ("alas".equals(this.suunta) && "ylos".equals(suunta)) {
     this.suunta = "alas";
     } else if ("vasen".equals(this.suunta) && "oikea".equals(suunta)) {
     this.suunta = "vasen";
     } else {
     this.suunta = suunta;
     }
     }
     */
    public näyttö() {
        setPreferredSize(new Dimension(borderx, bordery));
        setBackground(Color.black);
//        Mato mato = new Mato();
        /*
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
         */
        // arvotaan ensimmäinen safka
        safkaArpoja();
        ennätys = new JLabel();

        add(ennätys);
        ennätys.setForeground(Color.white);
        ennätys.setText("pisteet: 0");


        thread = new Thread(this);
        thread.start();

    }

    public void siirräSuunta(String suunta) {
        this.suunta = suunta;
        mato.setSuunta(suunta);
    }
    
    /**
     *
     * @param dx direction x
     * @param dy direction y
     */
    /*
     public void siirrä() {
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
     switch (suunta) {
     case "vasen":
     this.dx = -20;
     this.dy = 0;
     break;
     case "ylos":
     this.dx = 0;
     this.dy = -20;
     break;
     case "oikea":
     this.dx = 20;
     this.dy = 0;
     break;
     case "alas":
     this.dx = 0;
     this.dy = 20;
     break;
     }

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
     */
    @Override
    public void run() {
        while (true) {
            mato.siirrä();
            repaint();
            try {
                Thread.sleep(75);
            } catch (InterruptedException e) {
            }
        }

    }
    @Override
    public void paintComponent(Graphics g) {
        // mahdollisesti affinetransform juttua käytetään kuvan kääntämiseen
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(40, 40, 40, 40);
        // madon pää
        if (mato.getDx() == 20 && mato.getDy() == 0) {
            Image madonpää = Toolkit.getDefaultToolkit().getImage("madonpaa-oikea.png");
            g.drawImage(madonpää, mato.getX(), mato.getY(), null);
        } else if (mato.getDx() == 0 && mato.getDy() == 20) {
            Image madonpää = Toolkit.getDefaultToolkit().getImage("madonpaa-alas.png");
            g.drawImage(madonpää, mato.getX(), mato.getY(), null);
        } else if (mato.getDx() == -20 && mato.getDy() == 0) {
            Image madonpää = Toolkit.getDefaultToolkit().getImage("madonpaa-vasen.png");
            g.drawImage(madonpää, mato.getX(), mato.getY(), null);
        } else if (mato.getDx() == 0 && mato.getDy() == -20) {
            Image madonpää = Toolkit.getDefaultToolkit().getImage("madonpaa-ylos.png");
            g.drawImage(madonpää, mato.getX(), mato.getY(), null);
        }

        // yläseinä jne
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, 700, 20);
        g.fillRect(0, 0, 20, 540);
        g.fillRect(680, 0, 20, 540);
        g.fillRect(0, 520, 700, 20);

        // piirretään madon keskiosa, pituus muuttujasta madonpituus, koordinaatit taulukoista
        for (int i = 0; i < mato.getMadonpituus() - 1; i++) {
            Image madonruho = Toolkit.getDefaultToolkit().getImage("madonruho.png");
            g.drawImage(madonruho, mato.getMadonosatx(i), mato.getMadonosaty(i), null);
        }

        // madon jalat
        if (mato.getVikay() == mato.getTokavikay()) {
            if (mato.getVikax() < mato.getTokavikax()) {
                Image madonjalat = Toolkit.getDefaultToolkit().getImage("madonjalat-oikea.png");
                g.drawImage(madonjalat, mato.getMadonosatx(mato.getMadonpituus() - 1), mato.getMadonosaty(mato.getMadonpituus() - 1), null);
            } else {
                Image madonjalat = Toolkit.getDefaultToolkit().getImage("madonjalat-vasen.png");
                g.drawImage(madonjalat, mato.getMadonosatx(mato.getMadonpituus() - 1), mato.getMadonosaty(mato.getMadonpituus() - 1), null);
            }
        } else {
            if (mato.getVikay() < mato.getTokavikay()) {
                Image madonjalat = Toolkit.getDefaultToolkit().getImage("madonjalat-alas.png");
                g.drawImage(madonjalat, mato.getMadonosatx(mato.getMadonpituus() - 1), mato.getMadonosaty(mato.getMadonpituus() - 1), null);
            } else {
                Image madonjalat = Toolkit.getDefaultToolkit().getImage("madonjalat-ylos.png");
                g.drawImage(madonjalat, mato.getMadonosatx(mato.getMadonpituus() - 1), mato.getMadonosaty(mato.getMadonpituus() - 1), null);
            }
        }

        this.repaint();

        Image apple = Toolkit.getDefaultToolkit().getImage("apple.png");
        if (mato.isTörmäys()) {
            safkaArpoja();
            // g.fillRect(safkax, safkay, 20, 20);  
            g.drawImage(apple, safkax, safkay, null);
            this.pisteet += 1;
            ennätys.setText("pisteet: " + pisteet);
            mato.setTörmäys(false);

            // aina safkatessa madon pituutta lisätään yhdellä
            mato.lisääMadonpituutta();
        } else {
            g.drawImage(apple, safkax, safkay, null);
        }

    }

    private void safkaArpoja() {

        this.safkax = arpoja.nextInt(31) * 20 + 20;
        this.safkay = arpoja.nextInt(23) * 20 + 20;
    }
    /*
     private void SuunnanArpoja() {
     int suuntarng = arpoja.nextInt(4);

     //oikea
     if (suuntarng == 0) {
     suunta = "vasen";
     } //vasen
     else if (suuntarng == 1) {
     suunta = "ylös";
     } //ylös
     else if (suuntarng == 2) {
     suunta = "oikea";
     } //alas
     else if (suuntarng == 3) {
     suunta = "alas";
     }

     }
     */

    public void hävisitTeksti() {
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
