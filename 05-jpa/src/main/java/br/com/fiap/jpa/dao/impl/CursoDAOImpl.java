package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Curso;

public class CursoDAOImpl extends HibernateGenericDAO<Curso, Long> {

	private static CursoDAOImpl instance = null;
	
	public static CursoDAOImpl getInstance() {
		if (instance == null) {
			instance = new CursoDAOImpl();
		}
		
		return instance;
	}
	
	private CursoDAOImpl() {
		super(Curso.class);
	}

}
