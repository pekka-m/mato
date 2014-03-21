package mato;

// tuodaan swing-kirjasto graafista käyttöliittymää varten
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

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



        //Mato mato = new Mato();
        //mato.TeeMato();



    }
    //private Timer timer;
  //  Timer timer;
//    public int timerTesti() {
 //       timer.start();
 //       return 10;
 //   }
   // Timer timer = new Timer(1,null);
 //   System.out.println("säkki");
 //   int x = timer;
    
    
    
    int y = 50;
    @Override
    public void paint(Graphics g) {
        Rectangle r = new Rectangle(100, 100, 20, 20);
        g.fillRect(r.x, r.y, r.width, r.width);
    }
}

