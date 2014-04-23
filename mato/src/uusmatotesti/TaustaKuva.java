package uusmatotesti;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author H3173
 */
public class TaustaKuva extends JPanel {
  private BufferedImage img;
 
  public TaustaKuva() {
    // load the background image
    try {
      img = ImageIO.read(new File("android-eat-apple-6238.jpg"));
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
 
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // paint the background image and scale it to fill the entire space
    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
  }
}
