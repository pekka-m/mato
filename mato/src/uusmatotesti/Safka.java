package uusmatotesti;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author H3173
 */
public class Safka{
    
    private int safkax;
    private int safkay;
    private Random arpoja = new Random();
    
    public Safka() {
        safkaArpoja();
/*
        super.setSafkax(this.safkax);
        super.setSafkay(this.safkay);
 */
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