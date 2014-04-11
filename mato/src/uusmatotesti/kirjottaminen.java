/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uusmatotesti;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author H4198
 */
public class kirjottaminen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
  
 generateCsvFile("D:\\test.csv"); 
 kirjottaminen obj = new kirjottaminen();
	obj.run();
 
    }


 
   private static void generateCsvFile(String sFileName){
   
	try{

	    FileWriter writer = new FileWriter(sFileName);
 
	    writer.append("DisplayName");
	    writer.append(';');
	    writer.append("Age");
	    writer.append('\n');
 
	    writer.append("MKYONG");
	    writer.append(';');
	    writer.append("26");
            writer.append('\n');
 
	    writer.append("YOUR NAME");
	    writer.append(';');
	    writer.append("29");
	    writer.append('\n');
 
	    //generate whatever data you want
 
	    writer.flush();
	    writer.close();
        }
	catch(IOException e){
	
	     e.printStackTrace();
        }
	
        }

   public void run() {
 
	String csvFile = "D:\\test.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ";";
 
	try {
 
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
 
		        // use comma as separator
			String[] country = line.split(cvsSplitBy);
 
			System.out.println("nimi :" + country[0] 
                                 + " pisteet: " + country[1]);
 
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	System.out.println("Done");
  }
}

