package com.example.demo.service;

import java.util.List;

import com.example.demo.repo.modelo.Matricula;
import com.example.demo.repo.modelo.MatriculaTmp;

public interface IMatriculaSer {
	
	public void insertar(Matricula matricula);
	
	
	public void agregarMatricula(MatriculaTmp matriculaTmp);
	
	
	public List<Matricula> buscarTodos();

}
