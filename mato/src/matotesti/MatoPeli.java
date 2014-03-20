package matotesti;

import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/* @author H3173 */

public class MatoPeli extends JComponent{

    public void paint(Graphics g) {
        g.drawRect(100, 100, 20, 20);
    }
    
    public static void main(String[] args) {
        JFrame pelialue = new JFrame();

        // ikkunan otsikko
        pelialue.setTitle("Matopeli");

        //mitä tapahtuu kun klikkaa ruksia
        pelialue.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // luodaan uusi JPaneeli
        JPanel pelijoku = new JPanel();

        // lisää pelialueen JFrameen
        pelialue.setContentPane(pelijoku);

        // pelialueen koko
        pelialue.setSize(640, 480);

        //ikkunan koon muuttaminen ei mahdollista
        pelialue.setResizable(false);

        // tausta valkoinen
        pelialue.setBackground(Color.white);
        pelialue.setVisible(true);

        //static Graphics g;
        

    }

    
}
