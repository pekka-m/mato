package uusmatotesti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/* @author H3173 */
public class matomain extends JFrame {

    private näyttö näyttö;
    private safka safka;
    private ActionListener kuuntelija;

    public matomain() {
        näyttö = new näyttö();
        add(näyttö, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
       // safka= new safka();
      //  add(safka);
       // safka.setVisible(true);
        
       
        
        pack();

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == 37) {
                    näyttö.siirrä(-20, 0);
                }
                if (e.getKeyCode() == 38) {
                    näyttö.siirrä(0, -20);
                }
                if (e.getKeyCode() == 39) {
                    näyttö.siirrä(20, 0);
                }
                if (e.getKeyCode() == 40) {
                    näyttö.siirrä(0, 20);
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
