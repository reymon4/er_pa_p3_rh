package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.dto.MatriculaDTO;
import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.repo.modelo.Materia;
import com.example.demo.repo.modelo.Matricula;
import com.example.demo.repo.modelo.MatriculaTmp;
import com.example.demo.service.IMatriculaSer;

@Controller
@RequestMapping("/matriculas")

public class MatriculaController {
	
	
	@Autowired 
	private IMatriculaSer matriculaSer;
	
	@GetMapping("/nuevaMatricula")
	public String paginaNuevaMatricula(MatriculaTmp matriculaTmp) {
		return "vistaNuevaMatricula";
	}

	@PostMapping("/insertar")
	public String insertarMatricula(MatriculaTmp matriculaTmp, Model modelo) {
		this.matriculaSer.agregarMatricula(matriculaTmp);
		matriculaTmp = new MatriculaTmp();
		modelo.addAttribute("matriculaTmp", matriculaTmp);
		return "redirect:/matriculas/buscar";
	}	
		
		@GetMapping("/buscar")
		public String buscarTodos(Model modelo) {
			List<MatriculaDTO> lista = this.matriculaSer.buscarDTO();
			modelo.addAttribute("matriculas", lista);
			return "vistaListaMatriculas";
		}
	

}
