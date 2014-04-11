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

    public static void main(String[] args) throws FileNotFoundException, IOException {
        generateCsvFile("d:\\testi.csv");
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
        try {
            FileWriter writer = new FileWriter(sFileName);

            writer.append("DisplayName;71238\n");

            writer.append("MKYONG;26\n");

            writer.append("YOUR NAME;29\n");

            //generate whatever data you want

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}