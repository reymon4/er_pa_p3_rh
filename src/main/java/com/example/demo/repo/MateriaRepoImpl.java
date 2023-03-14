package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.repo.modelo.Materia;
import com.example.demo.repo.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepoImpl implements IMateriaRepo{

	
	@PersistenceContext
	private EntityManager eM;
	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.eM.persist(materia);
		
		
	}
	@Override
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> query = this.eM.createQuery("SELECT m FROM Materia m where m.codigo =: datoCodigo", Materia.class);
		query.setParameter("datoCodigo", codigo);
		return query.getResultList().get(0);
		
	}
	
	

}
