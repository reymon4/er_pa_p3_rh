package com.example.demo.service;

import java.util.List;

import com.example.demo.repo.modelo.Estudiante;

public interface IEstudianteSer {
	
	public void insertar(Estudiante estudiante);

	public void eliminar(Integer id);

	public Estudiante buscar(Integer id);

	// Para ver la lista de los estudiantes
	public List<Estudiante> buscarTodos();
	
	
	public Estudiante buscarPorCedula(String cedula);

}
