package Biblioteca;

import java.util.Objects;

public class Libro {
	private String titulo;
	private String isbn;
	private String autor;
	private String editorial;
	
	public Libro(String titulo,String autor,String editorial,String isbn) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial=editorial;
		this.isbn = isbn;
	}
	

	
	  @Override public int hashCode() { return Objects.hash(isbn); }
	  
	  
	  @Override public boolean equals(Object obj) { if (this == obj) return true;
	  if (obj == null) return false; if (getClass() != obj.getClass()) return
	  false; Libro other = (Libro) obj; return Objects.equals(isbn, other.isbn); }
	 


	@Override
	public String toString() {
		return String.format("TITULO: %s,AUTOR: %s,EDITORIAL: %s,ISBN %s",
					this.titulo,
					this.autor,
					this.editorial,
					this.isbn
				);
	}
	

}
