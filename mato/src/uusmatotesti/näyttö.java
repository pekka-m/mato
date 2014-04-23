package uusmatotesti;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import uusmatotesti.PisteKokeilu.NimiToPiste;
import static uusmatotesti.PisteKokeilu.NimiToPiste.getNimiToPisteet;
import static uusmatotesti.PisteKokeilu.NimiToPiste.setNimiToPisteet;

/**
 * MATO
 *
 * @version 0.51
 * @author Pekka M, Aleksi O
 * @since 2014-03-07
 */
public class näyttö extends JPanel implements Runnable, java.io.Serializable {

    Mato mato = new Mato();
    private final transient int borderx = 700;
    private final transient int bordery = 540;
    private transient int x;
    private transient int y;
    private transient String suunta;
    private transient int pisteet = 0;
    private transient JLabel ennätys;
    private transient Thread thread;
    private transient JLabel hävisit;
    private int apina = 2;
    private String nimi;
    private PisteLista piste = new PisteLista();

    public näyttö() {
        setPreferredSize(new Dimension(borderx, bordery));
        setBackground(Color.black);
        setLayout(new FlowLayout(FlowLayout.CENTER));



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





        if (mato.isSeinä() == true) {
            g.setFont(new Font("Dialog", Font.PLAIN, 48));
            g.setColor(Color.red);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            g.drawString("hävisit", 250, 250);
            g.setFont(new Font("Dialog", Font.PLAIN, 22));
            g.drawString("Painappa R", 250, 280);






            if (apina == 2) {
                try {
                    FileOutputStream fileOut = new FileOutputStream("d://mato.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(mato);
                    out.close();
                    fileOut.close();
                    System.out.println("data serialisoitu");

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(näyttö.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(näyttö.class.getName()).log(Level.SEVERE, null, ex);
                }



                apina++;

                nimi = JOptionPane.showInputDialog(null, "anna nimi");
//            JOptionPane.showMessageDialog(null, nimi);
                System.out.println(this.nimi);


                setNimiToPisteet(nimi);

                getNimiToPisteet();

                this.piste.luopistelista();

            }


            int aksa = 100;

            if (piste.pisteet.size() > 10) {
                for (int i = 0; i < 10; i++) {
                    g.setColor(Color.red);
                    g.setFont(new Font("Dialog", Font.PLAIN, 22));
                    g.drawString(piste.pisteet.get(i).nimi, 100, aksa);
                    aksa += 30;
                }
            } else {
                for (int i = 0; i < piste.pisteet.size(); i++) {
                    g.setColor(Color.red);
                    g.setFont(new Font("Dialog", Font.PLAIN, 22));
                    g.drawString(piste.pisteet.get(i).nimi, 100, aksa);
                    aksa += 30;
                }
            }
            aksa = 100;
               if (piste.pisteet.size() > 10) {
                for (int i = 0; i < 10; i++) {
                  
                  new Integer(piste.pisteet.get(i).pisteeet).toString();
                    g.setColor(Color.red);
                    g.setFont(new Font("Dialog", Font.PLAIN, 22));
                    g.drawString(new Integer(piste.pisteet.get(i).pisteeet).toString(), 300, aksa);
                    aksa += 30;
                }
            } else {
                for (int i = 0; i < piste.pisteet.size(); i++) {
                    g.setColor(Color.red);
                    g.setFont(new Font("Dialog", Font.PLAIN, 22));
                    g.drawString(new Integer(piste.pisteet.get(i).pisteeet).toString(), 300, aksa);
                    aksa += 30;
                }
            }




        }

        Image apple = Toolkit.getDefaultToolkit().getImage("apple.png");

        mato.isTörmäys();

        mato.setSafkax();

        mato.setSafkay();

        if (mato.isTörmäys()) {
            mato.getArpoja();
            // g.fillRect(safkax, safkay, 20, 20);  
            g.drawImage(apple, mato.getSafkax(), mato.getSafkay(), null);
            this.pisteet += 1;
            ennätys.setText("pisteet: " + mato.getPisteet());
            mato.setTörmäys(false);

            // aina safkatessa madon pituutta lisätään yhdellä
            mato.lisääMadonpituutta();
        } else {
            g.drawImage(apple, mato.getSafkax(), mato.getSafkay(), null);
        }

        this.repaint();
    }
// helpottaa koodin vääntämistä, output ikkunaan päivittyy madon koordinaatit
    public int äksä() {
        return this.x;
    }

    public int yyyy() {
        return this.y;
    }
}