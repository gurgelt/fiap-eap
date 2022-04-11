package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Disciplina;

public class DisciplinaDAOImpl extends HibernateGenericDAO<Disciplina, Long> {

	private static DisciplinaDAOImpl instance;
	
	private DisciplinaDAOImpl() {
		super(Disciplina.class);
	}
	
	public static DisciplinaDAOImpl getInstance() {
		
		if (instance == null) {
			instance = new DisciplinaDAOImpl();
		}
		
		return instance;
	}

}
