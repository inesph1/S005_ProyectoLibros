package com.ipartek.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="libros")
public class Libro {
	@Id
	private int id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "numeroPaginas")
	private int numeroPaginas;
	@Column(name = "autor")
	private String autor;
	
	public Libro() {
		super();
		this.id = 0;
		this.titulo = "";
		this.numeroPaginas = 0;
		this.autor = "";
	}
	
	public Libro(int id, String titulo, int numeroPaginas, String autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.numeroPaginas = numeroPaginas;
		this.autor = autor;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", numeroPaginas=" + numeroPaginas + ", autor=" + autor + "]";
	}
	
	

}
