package uusmatotesti;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author H3173
 */
public class safka extends JComponent {

    private int x;
    private int y;

    public safka() {
       setPreferredSize(new Dimension(640, 480));
        setBackground(Color.black);
        x = 320;
        y = 240;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

     

    
      
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
       
        
        g.setColor(Color.red);
        g.fillOval(200, 100, x, y);
       this.repaint();
}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
