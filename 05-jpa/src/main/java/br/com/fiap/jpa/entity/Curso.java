package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_curso")
@SequenceGenerator(name = "curso", sequenceName = "SQ_TB_CURSO", allocationSize = 1)
public class Curso implements Serializable{

	private static final long serialVersionUID = 1L;

	public Curso() {
		this.ativo = true;
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}
	
	public Curso(String nome) {
		this();
		this.nome = nome;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso")
	private Long id;
	
	@Column(name = "ds_nome", length = 80, nullable = false)
	private String nome;
	
	@Column(name = "st_ativo")
	private Boolean ativo;
	
	@Column(name = "dt_cadastro")
	private LocalDateTime dataCadastro;
	
	@Column(name = "dt_atualizacao")
	private LocalDateTime dataAtualizacao;

	@OneToMany(mappedBy = "curso", fetch = FetchType.EAGER)
	private List<Disciplina>disciplinas;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
//	@ManyToMany(mappedBy = "cursos")
//	private List<Aluno> alunos;
	
//	public List<Aluno> getAlunos() {
//		return alunos;
//	}
//
//	public void setAlunos(List<Aluno> alunos) {
//		this.alunos = alunos;
//	}

	@Override
	public String toString() {
		return "\nCurso: " + this.getNome()
				+"\nDisciplinas: " + this.getDisciplinas();
	}

	public void setCurso(Curso curso) {

	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
}
