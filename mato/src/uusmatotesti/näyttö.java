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
   
    private final int borderx = 700;
    private final int bordery = 540;
    private int x;
    private int y;
    private String suunta;
    private int pisteet = 0;
    private JLabel häviöteksti;
    private JLabel ennätys;
    private Thread thread;

    public näyttö() {
        setPreferredSize(new Dimension(borderx, bordery));
        setBackground(Color.black);

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
        mato.isTörmäys();
        mato.setSafkax();
        mato.setSafkay();
        if (mato.isTörmäys()) {
            mato.getArpoja();
            // g.fillRect(safkax, safkay, 20, 20);  
            g.drawImage(apple, mato.getSafkax(), mato.getSafkay(), null);
            this.pisteet += 1;
            ennätys.setText("pisteet: " + pisteet);
            mato.setTörmäys(false);

            // aina safkatessa madon pituutta lisätään yhdellä
            mato.lisääMadonpituutta();
        } else {
            g.drawImage(apple, mato.getSafkax(), mato.getSafkay(), null);
        }

    }

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

    // helpottaa koodin vääntämistä, output ikkunaan päivittyy madon koordinaatit
    public int äksä() {
        return this.x;
    }

    public int yyyy() {
        return this.y;
    }
}
