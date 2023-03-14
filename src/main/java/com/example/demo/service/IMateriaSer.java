package com.example.demo.service;

import com.example.demo.repo.modelo.Materia;

public interface IMateriaSer {
	
	public  void insertar(Materia materia);
	
	public Materia buscarPorCodigo(String codigo);

}
