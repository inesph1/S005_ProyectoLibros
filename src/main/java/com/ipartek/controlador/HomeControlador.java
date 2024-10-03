package com.ipartek.controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ipartek.modelo.Libro;
import com.ipartek.repositorios.RepoLibro;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeControlador {

	@Autowired
	private RepoLibro libroRepo;

	@RequestMapping("/")
	public String home(Model modelo) {
		List<Libro> listaLibros = new ArrayList<Libro>();
		listaLibros = libroRepo.findAll();
		modelo.addAttribute("atr_lista_libros", listaLibros);
		modelo.addAttribute("obj_libro", new Libro());
		return "home";
	}

	@RequestMapping("/guardarLibro")
	public String guardarLibro(Model modelo, @ModelAttribute("obj_libro") Libro libro) {
		libroRepo.save(libro);

		return "redirect:/";
	}

	@RequestMapping("/crearCopiaJSON")
	public String copiaJSON(HttpServletRequest request) {
		List<Libro> listaLibros = libroRepo.findAll();
		System.out.println("CONTEXTO "+request.getServletContext().getRealPath("/WEB-INF/classes/backups/"));
		request.getServletContext().getRealPath("");

		
		//DESPLEGADO
		String rutaBaseDespliegue = request.getServletContext().getRealPath(""); 
		//aqui tiene que entrar a /WEB-INF/clases/backups pero no existe
		
		Path currentRelativePath = Paths.get("").toAbsolutePath(); // obtiene ruta actual
		System.out.println("Ruta actual de ejecución: " + currentRelativePath.toString());
		String ruta ="";
		
		//CHAPUZA
		if(currentRelativePath.toString().equals("C:\\Users\\html\\Desktop\\Spring 4.24.0\\WS_Spring24\\S005_ProyectoLibros")) {
			ruta = currentRelativePath + "/src/main/resources/backups/copiaJSON.txt";
		}else {
			//ruta = servletContext.getRealPath("/WEB-INF/resources/backups/copiaJSON.txt");
		 ruta= request.getServletContext().getRealPath("/WEB-INF/classes/backups/copiaJSON.txt");
		}
				
		//File archivo = new File(currentRelativePath + "/src/main/resources/backups/copiaJSON.txt");
		File archivo = new File(ruta);
		// crea la carpeta
		archivo.getParentFile().mkdirs();

		try {
			if (archivo.createNewFile()) {
				System.out.println("Archivo creado: " + archivo.getName());
			} else {
				System.out.println("El archivo ya existe.");
			}
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			FileWriter writer = new FileWriter(archivo);
			gson.toJson(listaLibros, writer);
			writer.close();
		} catch (IOException e) {
			System.out.println("Ocurrió un error.");
			e.printStackTrace();
		}

		return "redirect:/";
	}
}
