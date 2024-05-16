
package ficheros;

import java.io.FileReader;
import java.io.IOException;

public class Ficheros {

    public static void main(String[] args) {
        try{
            FileReader fr = new FileReader("c:/ficheros/ejemplo.txt");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}
