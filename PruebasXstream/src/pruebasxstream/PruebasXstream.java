/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasxstream;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Ignacio
 */
public class PruebasXstream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Customer customer = new Customer("Jhon","Doe",new Date());

        
        XStream xstream = new XStream();
        xstream.allowTypes(new Class[] {Customer.class});//Si no lo implementas, lanza un error
        String xml = xstream.toXML(customer);
        
        PrintWriter pr = null;
        File fichero = new File("c:/ficheros/datos.xml");
        try {
            pr = new PrintWriter(fichero);
            pr.write(xml);
            pr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PruebasXstream.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Deserializar
        
        Customer datosXml = (Customer)xstream.fromXML(fichero);
        
        //Leer de un xml
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(fichero);
            NodeList listaNodos = documento.getDocumentElement().getChildNodes();
            
            for(int i=0;i<listaNodos.getLength();i++){
                Node hijo = listaNodos.item(i);
                
                if(hijo.getNodeType() == Node.ELEMENT_NODE){
                    
                }
                
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        
        
        
       
    }
    
}
