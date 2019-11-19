package br.ufba.mata62.SistemaAcademico.domain;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Universidade {

	private String nome;
	private String sigla;
	private String semestre;
	private ArrayList<Aluno> alunos;
	private ArrayList<Professor> professores;
	private ArrayList<Coordenador> coordenadores;
	private final ArrayList<Disciplina> disciplinas;
	private ArrayList<Curso> cursos;

	public Universidade(String nome, String sigla, String semestre, ArrayList<Disciplina> disciplinas) {
		this.nome = nome;
		this.sigla = sigla;
		this.semestre = semestre;
		this.disciplinas = disciplinas;

		alunos = new ArrayList<Aluno>();
		professores = new ArrayList<Professor>();
		cursos = new ArrayList<Curso>();
		coordenadores = new ArrayList<Coordenador>();
	}

	// Iniciar universidade com alunos, professores e coordenador
	public Universidade(String nome, String sigla, String semestre, ArrayList<Disciplina> disciplinas,
			ArrayList<Aluno> alunos, ArrayList<Professor> professores, ArrayList<Coordenador> coordenadores) {
		this.nome = nome;
		this.sigla = sigla;
		this.semestre = semestre;
		this.disciplinas = disciplinas;

		this.alunos = alunos;
		this.professores = professores;
		this.coordenadores = coordenadores;
	}

	public void iniciaSemestre() {

	};

	public void encerraSemestre() {

	};

	public void adicionaAluno(Aluno aluno) {
		alunos.add(aluno);
	}

	public void adicionaProfessor(Professor professor) {
		professores.add(professor);
	}

	public void adicionaCurso(Curso curso) {
		cursos.add(curso);
	}

	public void adicionaDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}

	// Método que muda um professor na lista
	public void alteraProfessor(Professor professor, int index) {
		this.professores.set(index, professor);
	}

	// Método que muda um aluno na lista
	public void alteraAluno(Aluno aluno, int index) {
		this.alunos.set(index, aluno);
	}

	// GETTERS E SETTERS

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public List<Aluno> getAlunos() {
		return Collections.unmodifiableList(alunos);
	}

	public List<Professor> getProfessores() {
		return Collections.unmodifiableList(professores);
	}

	public List<Disciplina> getDisciplinas() {
		return Collections.unmodifiableList(disciplinas);
	}

	public List<Curso> getCursos() {
		return Collections.unmodifiableList(cursos);
	}

	public List<Coordenador> getCoordenadores() {
		return Collections.unmodifiableList(coordenadores);
	}

	public void adicionaCoordenador(Coordenador coordenador) {
		coordenadores.add(coordenador);
	}

	public String getSigla() {
		return sigla;
	}

	public String getSemestre() {
		return semestre;
	}

}
