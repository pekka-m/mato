package mato;

// tuodaan swing-kirjasto graafista käyttöliittymää varten
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author H3173
 */
class MatoGUI extends JFrame {

    private MatoOhjain ohjain;
    private JPanel pelialue;
    private JButton heittopainike;
   

    /**
     * rekisteröidään ohjain
     *
     * @param ohjain
     */
    void rekisteröiOhjain(MatoOhjain ohjain) {
        this.ohjain = ohjain;
    }

    public MatoGUI() {
        
        // alustetaan komponentit
        initComponents();
        
        //pack();
        
        // tehdään JFrame näkyväksi
        this.setVisible(true);
    }

    private void initComponents() {
        // ikkunan otsikko
        setTitle("Matopeli");
        
        //mitä tapahtuu kun klikkaa ruksia
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // luodaan uusi JPaneeli
        pelialue = new JPanel();
        
        // lisää pelialueen JFrameen
        setContentPane(pelialue);
        
        // pelialueen koko
        setSize(640, 480);
        
        //ikkunan koon muuttaminen ei mahdollista
        setResizable(false);
        
        // tausta valkoinen
        pelialue.setBackground(Color.white);
        
    }
}
