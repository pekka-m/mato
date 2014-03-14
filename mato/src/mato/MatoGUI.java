package mato;

// tuodaan swing-kirjasto graafista käyttöliittymää varten
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author H3173
 */
class MatoGUI extends JFrame {

    private MatoOhjain ohjain;

    /** rekisteröidään ohjain
     * 
     * @param ohjain 
     */
    void rekisteröiOhjain(MatoOhjain ohjain) {
        this.ohjain = ohjain;
    }
    
    public MatoGUI() {
        initComponents();
        pack();
        this.setVisible(true);
    }

    private void initComponents() {
       
        pelialue = new JPanel();
        
        
        
    }
    
    
}
