package uusmatotesti;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * MATO
 *
 * @version 0.51
 * @author Pekka M, Aleksi O
 * @since 2014-03-07
 */
public class Mato implements java.io.Serializable {

//    näyttö näyttö = new näyttö();
    Safka safka = new Safka();
    private transient ArrayList<Integer> madonosatx = new ArrayList<>();
    private transient ArrayList<Integer> madonosaty = new ArrayList<>();
    private transient int madonpituus = 3;
    private transient int vikay;
    private transient int tokavikay;
    private transient int vikax;
    private transient int tokavikax;
    private transient int x;
    private transient int y;
    private transient int dx = 0;
    private transient int dy = 0;
    private transient String suunta;
    private transient Random arpoja = new Random();
    private transient boolean seinä = false;
    private transient boolean törmäys = false;
    private transient int safkax;
    private transient int safkay;
    private int pisteet = 0;


    public Mato() {
        
        this.x = 320;
        this.y = 240;
        this.dx = 20;
        this.dy = 0;
        for (int i = 0; i < this.madonpituus; i++) {
            this.madonosatx.add(320);
            this.madonosaty.add(240);
        }
        this.vikay = this.madonosaty.get(this.madonpituus - 1);
        this.tokavikay = this.madonosaty.get(this.madonpituus - 2);
        this.vikax = this.madonosatx.get(this.madonpituus - 1);
        this.tokavikax = this.madonosatx.get(this.madonpituus - 2);
        suunnanArpoja();
    }

    private void suunnanArpoja() {
        int suuntarng = arpoja.nextInt(4);
        if (suuntarng == 0) {
            this.suunta = "vasen";
        } else if (suuntarng == 1) {
            this.suunta = "ylös";
        } else if (suuntarng == 2) {
            this.suunta = "oikea";
        } else if (suuntarng == 3) {
            this.suunta = "alas";
        }
    }

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
        System.out.println(this.suunta);
    }

    public void lisääMadonKoordinaatit() {
        // lisätään koordinaatit ensimmäiseen paikkaan, muut työntyy eteenpäin
        this.madonosatx.add(0, this.x);
        if (this.madonosatx.size() == this.madonpituus) {
            this.madonosatx.remove(this.madonpituus);
        }
        this.madonosaty.add(0, this.y);
        if (this.madonosaty.size() == this.madonpituus) {
            this.madonosaty.remove(this.madonpituus);
        }
        // päivitetään vikan ja tokavikan hännän koordinaatit
        this.vikay = this.madonosaty.get(this.madonpituus - 1);
        this.tokavikay = this.madonosaty.get(this.madonpituus - 2);
        this.vikax = this.madonosatx.get(this.madonpituus - 1);
        this.tokavikax = this.madonosatx.get(this.madonpituus - 2);
    }

    public void siirrä() {
        if (this.y == 0) {

            this.seinä = true;
        } else if (this.x == 680) {
            this.seinä = true;
        } else if (this.y == 520) {
            this.seinä = true;
        } else if (this.x == 0) {
            this.seinä = true;
        }
        if (this.seinä == false) {
            // näytetään madon x ja y koordinaatit

            // lisätään koordinaatit ensimmäiseen paikkaan, muut työntyy eteenpäin
            lisääMadonKoordinaatit();

            switch (getSuunta()) {
                case "vasen":
                    this.dx = -20;
                    this.dy = 0;
                    System.out.println("keissi vasen");
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
            x += this.dx;
            y += this.dy;

            System.out.print("x: " + äksä() + " ");
            System.out.print("y: " + yyyy() + "\n");
            System.out.println(this.madonpituus);

            // testataan osutaanko omaan matoon
            for (int i = 0; i < this.madonpituus; i++) {

                // debuggia varten avustavaa tekstiä
                System.out.println(this.madonosatx.get(i));
                System.out.println(this.madonosaty.get(i));
                //itteensä törmäämisen tunnistin
                if ((this.madonosatx.get(i) == this.x) && (this.madonosaty.get(i) == this.y)) {
                    System.out.println("Hävisit pelin!");
                    this.seinä = true;
                }
            }

            //ollaanko törmätty safkaan SAFKASTA TEHDÄÄN OMA LUOKKA
            this.törmäys = (this.x == safka.getSafkax()) & (this.y == safka.getSafkay());
            if (törmäys) {
                this.pisteet++;
            }
        }
    }

    public String getSuunta() {
        return suunta;
    }

    public int getMadonpituus() {
        return madonpituus;
    }

    public void lisääMadonpituutta() {
        this.madonpituus++;
    }

    public int getVikay() {
        return vikay;
    }

    public void setVikay(int vikay) {
        this.vikay = vikay;
    }

    public int getTokavikay() {
        return tokavikay;
    }

    public void setTokavikay(int tokavikay) {
        this.tokavikay = tokavikay;
    }

    public int getVikax() {
        return vikax;
    }

    public void setVikax(int vikax) {
        this.vikax = vikax;
    }

    public int getTokavikax() {
        return tokavikax;
    }

    public void setTokavikax(int tokavikax) {
        this.tokavikax = tokavikax;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public boolean isTörmäys() {
        return törmäys;
    }

    public void setTörmäys(boolean törmäys) {
        this.törmäys = törmäys;
    }

    public int äksä() {
        return this.x;
    }

    public int yyyy() {
        return this.y;
    }

    public int getMadonosatx(int indeksi) {
        return madonosatx.get(indeksi);
    }

    public void setMadonosatx(ArrayList<Integer> madonosatx) {
        this.madonosatx = madonosatx;
    }

    public int getMadonosaty(int indeksi) {
        return madonosaty.get(indeksi);
    }

    public void setMadonosaty(ArrayList<Integer> madonosaty) {
        this.madonosaty = madonosaty;
    }

    public void Restarttti() {
    }
    
        public int getPisteet() {
        return pisteet;
    }

    public void setSafkax() {
        this.safkax = safka.getSafkax();

    }

    public int getSafkax() {
        return safkax;
    }

    public boolean isSeinä() {
        return seinä;
    }

    public int getSafkay() {
        return safkay;
    }

    public void setSafkay() {
        this.safkay = safka.getSafkay();

    }

    public void getArpoja() {
        safka.safkaArpoja();

    }

}
