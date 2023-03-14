package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.repo.modelo.Materia;
import com.example.demo.service.IEstudianteSer;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

	
	@Autowired
	private IEstudianteSer estudianteSer;
	
	@GetMapping("/nuevoEstudiante")
	public String paginaNuevoEstudiante(Estudiante estudiante) {
		return "vistaNuevoEstudiante";
	}

	@PostMapping("/insertar")
	public String insertarMateria(Estudiante estudiante, Model modelo) {
		this.estudianteSer.insertar(estudiante);
		estudiante = new Estudiante();
		modelo.addAttribute("estudiante", estudiante);
		return "redirect:/estudiantes/buscar";
	}
	
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Estudiante> lista = this.estudianteSer.buscarTodos();
		modelo.addAttribute("estudiantes", lista);
		return "vistaListaEstudiantes";
	}
	@DeleteMapping("/borrar/{id}")
	public String borrarProducto(@PathVariable("id") Integer id) {
		this.estudianteSer.eliminar(id);
		return "redirect:/estudiantes/buscar";
	}
	
}
