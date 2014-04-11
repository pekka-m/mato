package uusmatotesti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author H3173 */

public class DeSerialisoitu {

    public static void main(String[] args) throws ClassNotFoundException {
        
        Mato testi = null;
        try {
            FileInputStream fileIn = new FileInputStream("D://mato.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            testi =(Mato) in.readObject();
            in.close();
            fileIn.close();
            
           
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DeSerialisoitu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DeSerialisoitu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("pisteet: " + testi.getPisteet());
        
       
        }
    }


