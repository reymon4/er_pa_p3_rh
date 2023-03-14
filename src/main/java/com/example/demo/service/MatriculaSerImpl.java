package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IEstudianteRepo;
import com.example.demo.repo.IMateriaRepo;
import com.example.demo.repo.IMatriculaRepo;
import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.repo.modelo.Materia;
import com.example.demo.repo.modelo.Matricula;
import com.example.demo.repo.modelo.MatriculaTmp;

@Service
public class MatriculaSerImpl implements IMatriculaSer{

	
	@Autowired
	private IMatriculaRepo matriculaRepo;
	
	@Autowired
	private IMateriaRepo materiaRepo;
	
	@Autowired
	private IEstudianteRepo estudianteRepo;
	
	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.matriculaRepo.insertar(matricula);
	}

	@Override
	public void agregarMatricula(MatriculaTmp matriculaTmp) {
		// TODO Auto-generated method stub
		Materia mate = this.materiaRepo.buscarPorCodigo(matriculaTmp.getCodigo());
		
		Estudiante estu = this.estudianteRepo.buscarPorCedula(matriculaTmp.getCedula());
		
		Matricula matricula = new Matricula();
		matricula.setEstudiante(estu);
		matricula.setMateria(mate);
		mate.setNumeroEstudiantes(mate.getNumeroEstudiantes()+1);
		this.insertar(matricula);
		//mate.setNumeroEstudiantes(mate.getNumeroEstudiantes()+1);
				
	}

	@Override
	public List<Matricula> buscarTodos() {
		// TODO Auto-generated method stub
		return this.matriculaRepo.buscarTodos();
	}
	

}
