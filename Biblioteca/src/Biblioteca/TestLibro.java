package Biblioteca;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestLibro {

	public static void main(String[] args) {
		final int NUM_LIBROS = 10;
		//Crear una colección de libros.
		Set<Libro> coleccionLibros = new HashSet<Libro>();
		
		while(coleccionLibros.size()<NUM_LIBROS) {
			coleccionLibros.add(new Libro(Utils.getTitulo(),Utils.getAutor(),Utils.getEditorial(),Utils.getIsbn()));
		}
	
		for(Libro libro : coleccionLibros) {
			System.out.println(libro);
		}
		
	}

}
