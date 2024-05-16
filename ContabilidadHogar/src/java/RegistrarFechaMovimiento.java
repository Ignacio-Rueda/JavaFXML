
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ignacio
 */
public class RegistrarFechaMovimiento {

    private String mes;
    private String anyo;
    private String tipoDeMovimiento;
    private String importe;
    private LocalDate fechaActual;
    private List<String> listaMeses;
    private static final File fichero = new File("C:" + File.separator + "Ficheros" + File.separator + "contabilidad" + File.separator + "registroFechasMovimiento.txt");
    private List<String> listaRegistroFechasMovimientos;

    public RegistrarFechaMovimiento() {
        listaRegistroFechasMovimientos = new ArrayList<>();
        listaMeses = new ArrayList<>();
        fechaActual = LocalDate.now();
        anyo = String.valueOf(fechaActual.getYear());

        listaMeses.add("ENERO");
        listaMeses.add("FEBRERO");
        listaMeses.add("MARZO");
        listaMeses.add("ABRIL");
        listaMeses.add("MAYO");
        listaMeses.add("JUNIO");
        listaMeses.add("JULIO");
        listaMeses.add("AGOSTO");
        listaMeses.add("SEPTIEMBRE");
        listaMeses.add("OCTUBRE");
        listaMeses.add("NOVIEMBRE");
        listaMeses.add("DICIEMBRE");
    }

    public List<String> getListaFechaDeMovimientos() {

        //Leemos el fichero  
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String cadena="";
           
            while (cadena != null) {
                cadena = br.readLine();
                if (cadena != null) {
                    listaRegistroFechasMovimientos.add(cadena);
                }
                
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return listaRegistroFechasMovimientos;
    }

    public void deleteMovimiento(String movimiento) throws IOException {
        listaRegistroFechasMovimientos.remove(movimiento);
        try (BufferedWriter br = new BufferedWriter(new FileWriter(fichero))) {//Escribimos todo el fichero, ojo,que no usamos true, para que no se añada a continuación.
            for (String mov : listaRegistroFechasMovimientos) {
                br.write(mov + "\n");
                br.flush();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void registrarFechaMovimiento() throws NumberFormatException {
        Double importe;
        try {
            this.importe = this.importe.replace(",", ".");
            importe = Double.parseDouble(this.importe);
            //Gurdamos en fichero  
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true))) {
                bw.write(this.mes + "|" + this.anyo + "|" + this.tipoDeMovimiento + "|" + this.importe + "\n");
                bw.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (NumberFormatException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El número introducido no es válido", null + ex.getMessage()));
        }

    }

    public String getAnyo() {
        return this.anyo;
    }

    public String getMes() {
        return this.mes;
    }

    public List<String> getListaMeses() {
        return this.listaMeses;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getTipoDeMovimiento() {
        return tipoDeMovimiento;
    }

    public void setTipoDeMovimiento(String tipoDeMovimiento) {
        this.tipoDeMovimiento = tipoDeMovimiento;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public void clear() {
        this.setImporte("");
    }

}
