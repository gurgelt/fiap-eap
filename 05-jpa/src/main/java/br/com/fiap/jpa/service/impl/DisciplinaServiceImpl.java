package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.DisciplinaDAOImpl;
import br.com.fiap.jpa.entity.Disciplina;
import br.com.fiap.jpa.service.GenericService;

public class DisciplinaServiceImpl extends GenericService<Disciplina, Long>{

	private static DisciplinaServiceImpl instance = null;
	
	private DisciplinaDAOImpl disciplinaDAO;
	
	private DisciplinaServiceImpl() {
		disciplinaDAO = DisciplinaDAOImpl.getInstance();
	}

	public static DisciplinaServiceImpl getInstance() {
		if (instance == null) {
			instance = new DisciplinaServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void inserir(Disciplina instance) {
		try {
			disciplinaDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Disciplina instance) {
		try {
			disciplinaDAO.atualizar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void remover(Long id) {
		try {
			disciplinaDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Disciplina obter(Long id) {
		Disciplina disciplina = null;
		try {
			disciplina = disciplinaDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeEntityManager();
		}
		return disciplina;
	}

	@Override
	public List<Disciplina> listar() {
		
		List<Disciplina> disciplinas = null;
		
		try {
			disciplinas = disciplinaDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return disciplinas;
	}
}
