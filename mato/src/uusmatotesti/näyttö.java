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
        g.fillRect(x - 10, y - 10, 20, 20);
    }
}
