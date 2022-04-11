package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Endereco;

public class EnderecoDAOImpl extends HibernateGenericDAO<Endereco, Long> {

	private static EnderecoDAOImpl instance = null;

	private EnderecoDAOImpl() {
		super(Endereco.class);
	}
	
	public static EnderecoDAOImpl getInstance() {
		
		if (instance == null) {
			instance = new EnderecoDAOImpl();
		}
		
		return instance;
	}
	
}
