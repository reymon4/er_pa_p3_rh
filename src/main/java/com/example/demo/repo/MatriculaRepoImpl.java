package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.dto.MatriculaDTO;
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
	//Como dice que tiene que ser optimizada, tiene que usarse un DTO
	
	@Override
	public List<MatriculaDTO> buscarDTO() {
		TypedQuery<MatriculaDTO> myTypedQuery = this.eM
				 .createQuery("select NEW com.example.demo.modelo.dto.MatriculaDTO (m.estudiante.cedula, m.estudiante.nombre, m.estudiante.apellido, m.materia.nombre, m.materia.codigo)from Matricula m", MatriculaDTO.class);
				return myTypedQuery.getResultList();
	}
	

}
