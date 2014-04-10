package uusmatotesti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * MATO
 *
 * @version 0.51
 * @author Pekka M, Aleksi O
 * @since 2014-03-07
 */
public class matomain extends JFrame {

    näyttö näyttö = new näyttö();

    public matomain() {

        add(näyttö, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 37) {
                    näyttö.siirräSuunta("vasen");
                }
                if (e.getKeyCode() == 38) {
                    näyttö.siirräSuunta("ylos");
                }
                if (e.getKeyCode() == 39) {
                    näyttö.siirräSuunta("oikea");
                }
                if (e.getKeyCode() == 40) {
                    näyttö.siirräSuunta("alas");
                }
                if (e.getKeyCode() == 82) {
                    dispose();
                    new matomain();

                }
                if (e.getKeyCode() == 114) {
                    dispose();
                    new matomain();

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
        matomain matomain = new matomain();
    }
}
