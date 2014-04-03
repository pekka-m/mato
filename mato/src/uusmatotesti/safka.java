package uusmatotesti;

import java.util.Random;

/**
 *
 * @author H3173
 */
public class Safka {
    
    private int safkax;
    private int safkay;
    private Random arpoja = new Random();
    
    public Safka() {
        safkaArpoja();
    }

    public void safkaArpoja() {

        this.safkax = arpoja.nextInt(31) * 20 + 20;
        this.safkay = arpoja.nextInt(23) * 20 + 20;
    }
    
    public int getSafkax() {
        return safkax;
    }

    public int getSafkay() {
        return safkay;
    }

    public void setSafkax(int safkax) {
        this.safkax = safkax;
    }

    public void setSafkay(int safkay) {
        this.safkay = safkay;
    }
    
    

}
