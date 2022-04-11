package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.AlunoDAOImpl;
import br.com.fiap.jpa.dao.impl.CursoDAOImpl;
import br.com.fiap.jpa.dao.impl.MatriculaDAOImpl;
import br.com.fiap.jpa.entity.Matricula;
import br.com.fiap.jpa.service.GenericService;

public class MatriculaServiceImpl extends GenericService<Matricula, Long>{

	private static MatriculaServiceImpl instance = null;
	
	private MatriculaDAOImpl matriculaDAO;
	private AlunoDAOImpl alunoDAO;
	private CursoDAOImpl cursoDAO;
	
	private MatriculaServiceImpl() {
		matriculaDAO = MatriculaDAOImpl.getInstance();
		alunoDAO = AlunoDAOImpl.getInstance();
		cursoDAO = CursoDAOImpl.getInstance();
		
	}

	public static MatriculaServiceImpl getInstance() {
		if (instance == null) {
			instance = new MatriculaServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void inserir(Matricula instance) {
		try {
			instance.setAluno(alunoDAO.obterPorId(instance.getAluno().getId(),getEntityManager()));
			instance.setCurso(cursoDAO.obterPorId(instance.getCurso().getId(),getEntityManager()));
			matriculaDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Matricula instance) {
		try {
			matriculaDAO.atualizar(instance, getEntityManager());
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
			matriculaDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Matricula obter(Long id) {
		Matricula matricula = null;
		try {
			matricula = matriculaDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeEntityManager();
		}
		return matricula;
	}

	@Override
	public List<Matricula> listar() {
		
		List<Matricula> matriculas = null;
		
		try {
			matriculas = matriculaDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return matriculas;
	}

	public AlunoDAOImpl getAlunoDAO() {
		return alunoDAO;
	}

	public void setAlunoDAO(AlunoDAOImpl alunoDAO) {
		this.alunoDAO = alunoDAO;
	}

	public CursoDAOImpl getCursoDAO() {
		return cursoDAO;
	}

	public void setCursoDAO(CursoDAOImpl cursoDAO) {
		this.cursoDAO = cursoDAO;
	}
}
