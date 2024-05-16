

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ignacio
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ManagedBeanMovimiento {

    private MovimientoBean movimientoBean = new MovimientoBean();
    private static final File fichero = new File("C:" + File.separator + "Ficheros" + File.separator + "contabilidad" + File.separator + "tiposDeMovimiento.txt");
    private Set<String> listaMovimientos = new HashSet<>();

    public Set<String> getListaDeMovimientos() {

        //Leemos el fichero  
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String cadena = "";
            while (cadena != null) {
                cadena = br.readLine();
                if (cadena != null) {
                    listaMovimientos.add(cadena);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return listaMovimientos;
    }


    public MovimientoBean getMovimientoBean() {
        return movimientoBean;
    }

    public void setMovimientoBean(MovimientoBean movimientoBean) {
        this.movimientoBean = movimientoBean;
    }



    public void clear() {
        movimientoBean.setNombre("");
    }
    public void deleteMovimiento(String movimiento)throws IOException{
        listaMovimientos.remove(movimiento);
        try(BufferedWriter br = new BufferedWriter(new FileWriter(fichero))){//Escribimos todo el fichero, ojo,que no usamos true, para que no se añada a continuación.
            for(String mov : listaMovimientos){
                br.write(mov+"\n");
                br.flush();
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void registrarMovimiento() throws IllegalArgumentException, IllegalStateException, IOException {
        //Guardamos en listaMovimientos. 
        try {
            if (movimientoBean.getNombre().trim().isEmpty()) {//Eliminamos todos los espacios y si no está vacía la cadena, la guardamos
                throw new IllegalArgumentException();
            }
            if (listaMovimientos.contains(movimientoBean.getNombre())) {//Controlamos que no hay otro valor igual.
                throw new IllegalStateException();
            }
            //Gurdamos en fichero  
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true))) {
                bw.write(movimientoBean.getNombre() + "\n");
                bw.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        } catch (IllegalArgumentException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El valor introducidos no es válido.", null + ex.getMessage()));
        } catch (IllegalStateException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El valor introducido ya existe.", null + ex.getMessage()));
        }

    }
}
