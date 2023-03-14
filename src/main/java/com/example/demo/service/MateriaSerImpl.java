package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IMateriaRepo;
import com.example.demo.repo.modelo.Materia;

@Service
public class MateriaSerImpl implements IMateriaSer{
	
	@Autowired
	private IMateriaRepo materiaRepo;

	
	//Aqui ingresamos como cero el numero de estudiantes al crear una materia
	@Override
	public void insertar(Materia materia) {
		materia.setNumeroEstudiantes(0);
		// TODO Auto-generated method stub
		this.materiaRepo.insertar(materia);
	}

	@Override
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.materiaRepo.buscarPorCodigo(codigo);
	}
	
	

}
