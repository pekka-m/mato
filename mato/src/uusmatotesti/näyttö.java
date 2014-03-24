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

    private final int borderx = 650;
    private final int bordery = 490;
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
    private boolean vasenseinä;
    private boolean yläseinä;
    private boolean oikeaseinä;
    private boolean alaseinä;

    public boolean isVasenseinä() {
        return vasenseinä;
    }

    public boolean isYläseinä() {
        return yläseinä;
    }

    public boolean isOikeaseinä() {
        return oikeaseinä;
    }

    public boolean isAlaseinä() {
        return alaseinä;
    }
    

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
        setBackground(Color.black);
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
        
        // seinätörmäystunnistin ei toimi kunnolla
        if (x == 0) {
            vasenseinä = true;
        }
        if (y == 0) {
            yläseinä = true;
        }
        if (x == 640) {
            oikeaseinä = true;
        }
        if (y == 480) {
            alaseinä = true;
        }

        x += dx;
        y += dy;

//        if (x < borderx) {
//            x -= 20;
//        }
//        if (y > bordery) {
//            y -= 20;
//        }
//        if (x < 0) {
//            x += 20;
//        }
//        if (y < 0) {
//            y += 20;
//        }
        this.törmäys = (x == safkax) & (y == safkay);
//        if (x < borderx && x > 0 && y < bordery && y > 0) {
//            x += dx;
//            y += dy;
//            this.törmäys = (x == safkax) & (y == safkay);
//        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(x, y, 20, 20);
        g.fillRect(0, 0, 660, 10);
       

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
