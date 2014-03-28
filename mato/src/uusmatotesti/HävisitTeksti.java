package uusmatotesti;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author H3173
 */
public class HävisitTeksti extends JLabel{
    private JLabel häviöteksti;
public void hävisitTeksti() {
        Font f = new Font("Dialog", Font.PLAIN, 24);
        häviöteksti = new JLabel();
        add(häviöteksti);
        häviöteksti.setText("Hävisit pelin!");
        häviöteksti.setSize(400, 100);
        häviöteksti.setFont(f);
        häviöteksti.setForeground(Color.red);
        häviöteksti.setVisible(true);
        System.out.println("dsalkjfsal");
//        häviöteksti.set

    }
}
