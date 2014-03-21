package uusmatotesti;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author H3173
 */
public class näyttö extends JPanel {

    private int borderx = 650;
    private int bordery = 490;
    private int x;
    private int y;
    private int safkax;
    private int safkay;
    private boolean törmäys;
    private JLabel ennätys;
    private int pisteet = 0;
    
    private int madonosat = 3;
    private Map<Integer, Integer> matokoordinaatit = new HashMap<>();
    
    

    public näyttö() {
        setPreferredSize(new Dimension(borderx, bordery));
        setBackground(Color.black);
        x = 320;
        y = 240;
        safkax = 200;
        safkay = 100;
        ennätys = new JLabel();
        add(ennätys);
        ennätys.setText("pisteet: 0");
    }

    public boolean siirrä(int dx, int dy) {

        if (x > borderx) {
            x -= 20;
        }
        if (y > bordery) {
            y -= 20;
        }
        if (x < 0) {
            x += 20;
        }
        if (y < 0) {
            y += 20;
        }


        x += dx;
        y += dy;
        
        matokoordinaatit.put(x,y);
        


        if ((x == safkax) & (y == safkay)) {
            this.törmäys = true;
        } else {
            this.törmäys = false;
        }
   

        return törmäys;


    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(x, y, 20, 20);


        // this.paintComponent2(g);
        g.setColor(Color.red);
        //   g.fillOval(safkax, safkay, 20, 20);
        this.repaint();
        siirrä(0, 0);


        if (törmäys) {
            arpoja();
            g.fillRect(safkax, safkay, 20, 20);
            this.pisteet += 1;
            ennätys.setText("pisteet: " + pisteet);
        } else {
            g.fillRect(safkax, safkay, 20, 20);
            g.setColor(Color.CYAN);
        }

    }

    public void paintComponent2(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.red);
        g.fillOval(safkax, safkay, 20, 20);
        this.repaint();
    }

    public void arpoja() {

        Random arpoja = new Random();

        this.safkax = arpoja.nextInt(31) * 20;
        this.safkay = arpoja.nextInt(23) * 20;

    }
}
