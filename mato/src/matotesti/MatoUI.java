package matotesti;

import java.awt.BorderLayout;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author H3173
 */
public class MatoUI extends JFrame {

    private Näyttö näyttö;
    private Mato mato;

    public MatoUI() {
        näyttö = new Näyttö();
        Mato mato = new Mato();
        add(näyttö, BorderLayout.CENTER);
    
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        mato.testi();
       
      
//        pack();
    }
}
