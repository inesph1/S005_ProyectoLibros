package com.ipartek.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.modelo.Libro;
import com.ipartek.repositorios.RepoLibro;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class CargarDatos {
	@Autowired
	private RepoLibro libroRepo;
	
	@PostConstruct //se ejecuta cuando detectaun cambio en el pom
	@Transactional
	public void inicializarDatos() {
		Libro l1 = new Libro(1, "Cien años de soledad", 417, "Gabriel García Márquez");
		Libro l2 = new Libro(2,"Don Quijote de la Mancha", 1023, "Miguel de Cervantes");
		Libro l3 = new Libro(3,"La sombra del viento", 576, "Carlos Ruiz Zafón");
		Libro l4 = new Libro(4,"El amor en los tiempos del cólera", 368, "Gabriel García Márquez");
		Libro l5 = new Libro(5,"Crónica de una muerte anunciada", 120, "Gabriel García Márquez");
		Libro l6 = new Libro(6,"1984", 328, "George Orwell");
		Libro l7 = new Libro(7,"Orgullo y prejuicio", 432, "Jane Austen");
		Libro l8 = new Libro(8,"El túnel", 256, "Ernesto Sabato");
		Libro l9 = new Libro(9,"La casa de los espíritus", 448, "Isabel Allende");
		Libro l10 = new Libro(10,"El principito", 96, "Antoine de Saint-Exupéry");
		
		libroRepo.save(l1);
		libroRepo.save(l2);
		libroRepo.save(l3);
		libroRepo.save(l4);
		libroRepo.save(l5);
		libroRepo.save(l6);
		libroRepo.save(l7);
		libroRepo.save(l8);
		libroRepo.save(l9);
		libroRepo.save(l10);
	}

}
