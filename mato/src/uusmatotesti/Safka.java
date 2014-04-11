package uusmatotesti;

import java.util.Random;

/**
 * MATO
 *
 * @version 0.51
 * @author Pekka M, Aleksi O
 * @since 2014-03-07
 */
public class Safka implements java.io.Serializable {
    
    private transient int safkax;
    private transient int safkay;
    private transient Random arpoja = new Random();
    
    public Safka() {
        safkaArpoja();
    }

    public void safkaArpoja() {

        this.safkax = this.arpoja.nextInt(31) * 20 + 20;
        this.safkay = this.arpoja.nextInt(23) * 20 + 20;
        
    }
    
    public int getSafkax() {
        return this.safkax;
    }

    public int getSafkay() {
        return this.safkay;
    }

    public void setSafkax(int safkax) {
        this.safkax = safkax;
    }

    public void setSafkay(int safkay) {
        this.safkay = safkay;
    }

}