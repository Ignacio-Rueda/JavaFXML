package generico_1;

import java.util.Objects;

public class Alumno implements Comparable<Alumno> {

    String nombre;
    int edad;

    public Alumno(String nombre,int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    //Comparación por edad.
    @Override
    public int compareTo(Alumno a) {
        return Integer.compare(this.edad, a.edad);
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s Edad: %d años.",
                this.nombre,
                this.edad
        );
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        return Objects.equals(this.nombre, other.nombre);
    }



  



}
