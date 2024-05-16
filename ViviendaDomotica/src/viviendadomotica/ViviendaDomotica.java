package viviendadomotica;

public class ViviendaDomotica {

    public static void main(String[] args) {

        Dispositivo[] array = new Dispositivo[4];

        array[0] = new Cerradura("Cerradura garaje", 1, true);
        if (array[0] instanceof Bombilla) {
            System.out.println("Es de tipo bombilla");

        } else if (array[0] instanceof Cerradura) {
            System.out.println("Es de tipo cerradura");
        }
        array[1] = new Cerradura("Cerradura ppal", 2);
        array[2] = new Persiana("Persiana dormitorio infantil", 3);
        array[3] = new Persiana("Persiana dormitorio matrimonio", 4);

        for (int n = 0; n < array.length; n++) {
            System.out.println(array[n]);
        }
    }

}
