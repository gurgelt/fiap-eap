package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.CursoDAOImpl;
import br.com.fiap.jpa.entity.Curso;
import br.com.fiap.jpa.service.GenericService;

public class CursoServiceImpl extends GenericService<Curso, Long> {

	private static CursoServiceImpl instance = null;
	
	private CursoDAOImpl cursoDAO;
	
	private CursoServiceImpl() {
		cursoDAO = CursoDAOImpl.getInstance();
	}
	
	public static CursoServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new CursoServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void inserir(Curso curso) {
		try {
			cursoDAO.salvar(curso, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}
	
	@Override
	public void atualizar(Curso curso) {
		try {
			cursoDAO.atualizar(curso, getEntityManager());
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public void remover(Long id) {
		try {
			cursoDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public Curso obter(Long id) {
		Curso curso = null;
		
		try {
			curso = cursoDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return curso;
	}

	@Override
	public List<Curso> listar() {
		List<Curso> cursos = null;
		
		try {
			cursos = cursoDAO.listar(getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return cursos;
	}

}
