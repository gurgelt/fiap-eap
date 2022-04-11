package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_disciplina")
@SequenceGenerator(name = "disciplina", sequenceName = "SQ_TB_DISCIPLINA", allocationSize = 1)
public class Disciplina implements Serializable{

	
	private static final long serialVersionUID = 613485805604306620L;
	
	public Disciplina() {
		this.ativo = true;
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}
	
	public Disciplina(String nome, Integer cargaHoraria, Curso curso) {
		this();
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.curso = curso;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina")
	private Long id;
	
	@Column(name = "ds_nome", length = 40, nullable = false)
	private String nome;
	
	@Column(name = "nr_carga_horaria")
	private Integer cargaHoraria;
	
	@Column(name = "st_ativo")
	private Boolean ativo;
	
	@Column(name = "dt_cadastro")
	private LocalDateTime dataCadastro;
	
	@Column(name = "dt_atualizacao")
	private LocalDateTime dataAtualizacao;
	
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

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

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
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

	@Override
	public String toString() {
		return "\nDisciplina: " + this.getNome()
				+ "\nCarga Horária: " + this.getCargaHoraria() + " Horas ";
		
		
	}
}
