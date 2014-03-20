package mato;

/* @author H3173 */
public class MatoOhjain {

    private Matopeli malli;
    private MatoGUI näkymä;

    public MatoOhjain(Matopeli malli, MatoGUI näkymä) {
        this.malli = malli;
        this.näkymä = näkymä;
    }

    public static void main(String[] args) {
        Matopeli malli = new Matopeli();
        MatoGUI näkymä = new MatoGUI();
        MatoOhjain ohjain = new MatoOhjain(malli, näkymä);
        näkymä.rekisteröiOhjain(ohjain);

    }
}



