package matotesti;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.PopupMenu;
import javax.swing.*;

/**
 *
 * @author H3173
 */
class Näyttö extends JPanel{

    private final int borderx = 690;
    private final int bordery = 530;
//    private  Mato mato;
//    private Mato mato;
    public Näyttö() {
        
        setPreferredSize(new Dimension(borderx, bordery));
        setBackground(Color.black);
//        add(mato);
//        setOpaque(true);
//        mato = new Mato();
//        add(mato);
    }
}
