package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.modelo.Materia;
import com.example.demo.service.IMateriaSer;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	
	@Autowired
	private IMateriaSer materiaSer;
	
	
	@GetMapping("/nuevaMateria")
	public String paginaNuevaMateria(Materia materia) {
		return "vistaNuevaMateria";
	}

	@PostMapping("/insertar")
	public String insertarMateria(Materia materia, Model modelo) {
		this.materiaSer.insertar(materia);
		materia = new Materia();
		modelo.addAttribute("materia", materia);
		return "redirect:/materias/nuevaMateria";
	}
	
	


	

}
