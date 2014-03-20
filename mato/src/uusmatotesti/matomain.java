package uusmatotesti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/* @author H3173 */
public class matomain extends JFrame {

    private näyttö näyttö;
    private ActionListener kuuntelija;

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
                    näyttö.siirrä(-10, 0);
                }
                if (e.getKeyCode() == 38) {
                    näyttö.siirrä(0, -10);
                }
                if (e.getKeyCode() == 39) {
                    näyttö.siirrä(10, 0);
                }
                if (e.getKeyCode() == 40) {
                    näyttö.siirrä(0, 10);
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });


    }

    private class kuuntelija implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        }
    }

    public static void main(String[] args) {
        new matomain();
    }
}