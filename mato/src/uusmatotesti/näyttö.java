package uusmatotesti;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author H3173
 */
public class näyttö extends JPanel {

    private int x;
    private int y;

    public näyttö() {
        setPreferredSize(new Dimension(640, 480));
        setBackground(Color.black);
        x = 320;
        y = 240;
    }

    public void siirrä(int dx, int dy) {
        x += dx;
        y += dy;
        repaint();
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
        
        g.setColor(Color.red);
        g.fillOval(200, 100, 20, 20);
    }
    
      
    public void sass (Graphics g) {
        super.paintComponent(g);
       
        
        g.setColor(Color.red);
        g.fillOval(200, 100, 20, 20);
}
}
