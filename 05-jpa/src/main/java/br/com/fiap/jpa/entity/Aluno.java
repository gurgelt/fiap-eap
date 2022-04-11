package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aluno")
@SequenceGenerator(name = "aluno", sequenceName = "SQ_TB_ALUNO", allocationSize = 1)
public class Aluno implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Aluno() {
		this.ativo = true;
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}
	
	public Aluno(String nome, String matricula, String cpf, LocalDate dataNascimento) {
		this();
		this.nome = nome;
		this.matricula = matricula;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno")
	private Long id;
	
	@Column(name = "ds_nome", length = 80, nullable = false)
	private String nome;
	
	@Column(name = "nr_matricula", length = 10, nullable = false, unique = true)
	private String matricula;
	
	@Column(name = "nr_cpf", length = 14, nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "dt_nascimento")
	private LocalDate dataNascimento;
	
	@Column(name = "st_ativo")
	private Boolean ativo;
	
	@Column(name = "dt_cadastro")
	private LocalDateTime dataCadastro;
	
	@Column(name = "dt_atualizacao")
	private LocalDateTime dataAtualizacao;
	
	@OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Endereco endereco;
	
	@OneToMany(mappedBy = "aluno")
	private List<Matricula> matriculas;
	
	public Long getId() {
		return id;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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
	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

//	@ManyToMany
//	@JoinTable(name = "tb_aluno_curso", 
//				joinColumns = @JoinColumn(name = "aluno_id"), 
//				inverseJoinColumns = @JoinColumn(name = "curso_id"))
//	
//	private List<Curso> cursos;
//
//	public List<Curso> getCursos() {
//		return cursos;
//	}
//
//	public void setCursos(List<Curso> cursos) {
//		this.cursos = cursos;
//	}

	@Override
	public String toString() {
		
		return "\nMatricula: " + this.getMatricula() 
			+ "\nNome: " + this.getNome()
			+ "\nCPF: " + this.getCpf() 
			+ "\nNascimento: " + this.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
			+ "\nEndereço: " + this.getEndereco();
	}

}
