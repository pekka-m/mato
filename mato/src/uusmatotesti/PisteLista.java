package uusmatotesti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * MATO
 *
 * @version 0.51
 * @author Pekka M, Aleksi O
 * @since 2014-03-07
 */
class Pisteet implements Comparable<Pisteet> {

    String nimi;
    int pisteeet;
   private  List<Pisteet> pisteet = new ArrayList<>();

  
    public Pisteet(String nimi, int pisteet) {
        this.nimi = nimi;
        this.pisteeet = pisteeet;
    }

    @Override
    public int compareTo(Pisteet o) {
        return pisteeet < o.pisteeet ? -1 : pisteeet > o.pisteeet ? 1 : 0;
    }
}

public class PisteLista {

    private int pisteeet;
     List<Pisteet> pisteet = new ArrayList<Pisteet>();

    public PisteLista() {
        try {
            DeSerialisoitu desse = new DeSerialisoitu();
            try {
                desse.deserialisoitu();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PisteLista.class.getName()).log(Level.SEVERE, null, ex);
            }

            //        PisteetSerristä();

            try {
                FileWriter writer = new FileWriter("d://testi.csv");

                writer.append("TÄMÄONTESTI;" + desse.getPisteet());





                //generate whatever data you want

                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
           

            pisteet.add(new Pisteet("Sakarias", 123));
            pisteet.add(new Pisteet("Sasdfas", 765));
            pisteet.add(new Pisteet("Khjdhgfjs", 45));
            pisteet.add(new Pisteet("ASDFas", 987));
            pisteet.add(new Pisteet("AAPAOAPAPOPAO", 34));
            pisteet.add(new Pisteet("Lojnhibt", 1));

            String csvFile = "d:\\testi.csv";
            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ";";
            try {
                br = new BufferedReader(new FileReader(csvFile));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PisteLista.class.getName()).log(Level.SEVERE, null, ex);
            }

            while ((line = br.readLine()) != null) {
                String[] country = line.split(cvsSplitBy);
                int pisteapu = Integer.parseInt(country[1]);
                pisteet.add(new Pisteet(country[0], pisteapu));
            }

            Collections.sort(pisteet, Collections.reverseOrder());

            for (int i = 0; i < pisteet.size(); i++) {
                System.out.println(pisteet.get(i).nimi + pisteet.get(i).pisteeet);
            }
        } catch (IOException ex) {
            Logger.getLogger(PisteLista.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

      public List<Pisteet> getPisteet() {
        return pisteet;
    }

  
}
