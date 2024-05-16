package Biblioteca;

public class Utils {
	static String [] titulos = {"El jardín de cristal y la luna perdida","El viaje del zorro parlante","Las aventuras de la estrella fugaz","El misterio del faro encantado", "El secreto de la montaña de los sueños",
			"La isla de los susurros olvidados","El reino de las sombras danzantes","El tesoro de los suspiros perdidos","El enigma de la ciudad esmeralda","El misterioso caso del reloj detenido" };
	
	static String [] autores = {"Juan","María","Pedro","José","Ramón","Julio","Mercedes","Valentina","Ricardo","Sofía"};
	
	static String[]editorial = {"Penguin Random House","HarperCollins","Simon & Schuster","Macmillan Publishers","Hachette Livre",
			"Pearson Education","Scholastic Corporation","Wiley","Oxford University Press","Cambridge University Press"}; 
	static String[] isbn = {"001","002","003","004","005","006","007","008","009","010"};
	
	public static String getTitulo() {
		int pos = (int)(Math.random()*(titulos.length));
		return titulos[pos];
	}

	public static String getAutor() {
		int pos = (int)(Math.random()*(autores.length));
		return autores[pos];
	}
	
	public static String getEditorial() {
		int pos = (int)(Math.random()*(editorial.length));
		return editorial[pos];
	}
	public static String getIsbn() {
		int pos = (int)(Math.random()*(isbn.length));
		return isbn[pos];
	}
}






