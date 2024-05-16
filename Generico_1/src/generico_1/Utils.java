package generico_1;

public class Utils {

    static String[] nombres = {"Nacho", "Ramon", "Pablo", "Domingo", "Alfonso", "Adriano", "Maria", "Carmen", "Eva","Guillermo"};
    static int[] edades = {20, 30, 35, 45, 20, 12, 15, 6, 8, 56};

    public static String nombreAzar() {
        return nombres[(int) (Math.random() * nombres.length)];
    }

    public static int edades() {
        return edades[(int) (Math.random() * edades.length)];
    }

}
