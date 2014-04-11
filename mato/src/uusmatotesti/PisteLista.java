package uusmatotesti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * MATO
 *
 * @version 0.51
 * @author Pekka M, Aleksi O
 * @since 2014-03-07
 */
class Pisteet implements Comparable<Pisteet> {

    String nimi;
    int pisteet;

    public Pisteet(String nimi, int pisteet) {
        this.nimi = nimi;
        this.pisteet = pisteet;
    }

    @Override
    public int compareTo(Pisteet o) {
        return pisteet < o.pisteet ? -1 : pisteet > o.pisteet ? 1 : 0;
    }
}

public class PisteLista {
     
   static int pisteeet;
 
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
         DeSerialisoitu desse = new DeSerialisoitu();
        desse.deserialisoitu();
        
//        PisteetSerristä();
        
       try {
            FileWriter writer = new FileWriter("d://testi.csv");

            writer.append("TÄMÄONTESTI;"+ desse.getPisteet());

            

       

            //generate whatever data you want

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Pisteet> pisteet = new ArrayList<Pisteet>();

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
        br = new BufferedReader(new FileReader(csvFile));

        while ((line = br.readLine()) != null) {
            String[] country = line.split(cvsSplitBy);
            int pisteapu = Integer.parseInt(country[1]);
            pisteet.add(new Pisteet(country[0], pisteapu));
        }

        Collections.sort(pisteet, Collections.reverseOrder());

        for (int i = 0; i < pisteet.size(); i++) {
            System.out.println(pisteet.get(i).nimi + pisteet.get(i).pisteet);
        }

        
        
    }

    
    private static void generateCsvFile(String sFileName) {
       
    }
    
//    private  void PisteetSerristä() {
//            Mato testi = null;
//
//        try {
//            FileInputStream fileIn = new FileInputStream("D://mato.ser");
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            testi =(Mato) in.readObject();
//            in.close();
//            fileIn.close();
//     
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(DeSerialisoitu.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(DeSerialisoitu.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(PisteLista.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         this.pisteeet = testi.getPisteet();
    }
  
