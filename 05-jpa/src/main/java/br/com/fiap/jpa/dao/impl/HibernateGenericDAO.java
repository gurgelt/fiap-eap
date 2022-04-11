package br.com.fiap.jpa.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.jpa.dao.GenericDAO;

public abstract class HibernateGenericDAO<T extends Serializable, PK extends Serializable> implements GenericDAO<T, PK> {

	private Class<T> type;
	
	public Class<T> getType() {
		return type;
	}

	public HibernateGenericDAO(Class<T> type) {
		this.type = type;
	}
	
	@Override
	public void salvar(T instancia, EntityManager entityManager) {
		entityManager.persist(instancia);
		
	}
	
	@Override
	public void atualizar(T instancia, EntityManager entityManager) {
		entityManager.merge(instancia);
		
	}

	@Override
	public void remover(PK id, EntityManager entityManager) {
		T instancia = this.obterPorId(id, entityManager);
		entityManager.remove(instancia);
	}

	@Override
	public T obterPorId(PK id, EntityManager entityManager) {
		
		return entityManager.find(type, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar(EntityManager entityManager) {
		String className = type.getName();
		Query consulta = entityManager.createQuery("SELECT o FROM " + className + " o");
		
		return consulta.getResultList();
	}
}
