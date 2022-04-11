package br.com.fiap.jpa;

import java.time.LocalDate;

import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.entity.Curso;
import br.com.fiap.jpa.entity.Disciplina;
import br.com.fiap.jpa.entity.Endereco;
import br.com.fiap.jpa.entity.Matricula;
import br.com.fiap.jpa.service.impl.AlunoServiceImpl;
import br.com.fiap.jpa.service.impl.CursoServiceImpl;
import br.com.fiap.jpa.service.impl.DisciplinaServiceImpl;
import br.com.fiap.jpa.service.impl.MatriculaServiceImpl;

public class App {

	public static void main(String[] args) {
		
		//Instanciando service para executar operações na entidade Aluno
		AlunoServiceImpl alunoService = AlunoServiceImpl.getInstance();
		CursoServiceImpl cursoService = CursoServiceImpl.getInstance();
		DisciplinaServiceImpl disciplinaService = DisciplinaServiceImpl.getInstance();
		MatriculaServiceImpl matriculaService = MatriculaServiceImpl.getInstance();		
		
		//Criando 3 instâncias de Aluno
		Aluno aluno1 = new Aluno("Aluno 1", "1111", "111.111.111-11", LocalDate.of(1980, 1, 1));
		Aluno aluno2 = new Aluno("Aluno 2", "2222", "222.222.222-22", LocalDate.of(1990, 1, 1));
		Aluno aluno3 = new Aluno("Aluno 3", "3333", "333.333.333-33", LocalDate.of(2000, 1, 1));
		
		//Inserindo no banco os alunos 1 e 2
		alunoService.inserir(aluno1);
		alunoService.inserir(aluno2);
		
		Endereco endereco = new Endereco("Av. Paulista", 777, "5 andar", "Bela Vista", "S�o Paulo", "SP", "04632-098");
		
		//Inserindo um aluno com endereço
		alunoService.inserirComEndereco(aluno3, endereco);
		
		alunoService.listar().forEach(System.out::println);
		
		//Excluindo o aluno com id 3 e, em cascata, removendo também o endereço associado a ele
		alunoService.remover(3L);
		
		Curso curso = new Curso("TDS");
		cursoService.inserir(curso);
		
		cursoService.listar().forEach(System.out::println);
		
		Disciplina disciplina = new Disciplina("EAD", 60, curso);
		disciplinaService.inserir(disciplina);
		disciplinaService.listar().forEach(System.out::println);
		
//		alunoService.matricular(aluno1.getId(), curso.getId());
		
		Matricula matricula = new Matricula();
		matricula.setAluno(aluno1);
		matricula.setCurso(curso);
		matricula.setDataMatricula(LocalDate.now());
		
		matriculaService.inserir(matricula);
	}
}
