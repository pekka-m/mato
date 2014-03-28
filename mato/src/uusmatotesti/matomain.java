package uusmatotesti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * MATO
 * @version 0.51
 * @author Pekka M, Aleksi O
 * @since 2014-03-07
 */
public class matomain extends JFrame {

    private näyttö näyttö;

    public matomain() {
        näyttö = new näyttö();
        add(näyttö, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 37) {
                    näyttö.setSuunta("vasen");
                }
                if (e.getKeyCode() == 38) {
                    näyttö.setSuunta("ylos");
                }
                if (e.getKeyCode() == 39) {
                    näyttö.setSuunta("oikea");
                }
                if (e.getKeyCode() == 40) {
                    näyttö.setSuunta("alas");
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    public static void main(String[] args) {
        new matomain();
    }
}
