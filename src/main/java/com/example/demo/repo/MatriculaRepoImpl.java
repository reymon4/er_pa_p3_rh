package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.repo.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MatriculaRepoImpl implements IMatriculaRepo {

	
	@PersistenceContext
	private EntityManager eM;
	@Override
	public void insertar(Matricula matricula) {
		
		this.eM.persist(matricula);
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Matricula> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Matricula> query = this.eM.createQuery("SELECT ma FROM Matricula ma", Matricula.class);
		return query.getResultList();
	}
	

}
