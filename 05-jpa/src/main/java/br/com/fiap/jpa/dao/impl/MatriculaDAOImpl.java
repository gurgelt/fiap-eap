package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Matricula;

public class MatriculaDAOImpl extends HibernateGenericDAO<Matricula, Long> {

	private static MatriculaDAOImpl instance = null;
	
	public static MatriculaDAOImpl getInstance() {
		if (instance == null) {
			instance = new MatriculaDAOImpl();
		}
		
		return instance;
	}
	
	private MatriculaDAOImpl() {
		super(Matricula.class);
	}

}
