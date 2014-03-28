package uusmatotesti;

import java.util.ArrayList;

/**
 *
 * @author H3173
 */
public class Mato {

    private ArrayList<Integer> madonosatx = new ArrayList<>();
    private ArrayList<Integer> madonosaty = new ArrayList<>();
    private int madonpituus = 3;
    private int vikay;
    private int tokavikay;
    private int vikax;
    private int tokavikax;
    private int x;
    private int y;
    private int dx;
    private int dy;
    
    public Mato() {
        for (int i = 0; i < madonpituus; i++) {
            madonosatx.add(320);
            madonosaty.add(240);
        }
        vikay = madonosaty.get(madonpituus - 1);
        tokavikay = madonosaty.get(madonpituus - 2);
        vikax = madonosatx.get(madonpituus - 1);
        tokavikax = madonosatx.get(madonpituus - 2);
    }
    
}
