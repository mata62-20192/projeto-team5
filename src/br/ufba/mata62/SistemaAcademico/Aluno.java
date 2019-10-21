package br.ufba.mata62.SistemaAcademico;

public class Aluno extends Pessoa {

	private int semestre;
	private boolean matriculado;
	private boolean graduado;
	private Float score;
	private Curso curso;
	private Historico historico;
	private Matricula matricula;

	public Aluno(String nome, String matricula, String senha, String rg, String cpf, Curso curso) {
		super(nome, matricula, senha, rg, cpf);

		this.curso = curso;
		this.historico = new Historico(this);
	}

	public void matricula() {
		matricula = new Matricula(historico, curso);
	}

	public void calculaSemestre() {

	}

	public void calculaScore() {
		score = historico.calculaScore();
	}

	// GETTERS E SETTERS

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public void setMatriculado(boolean matriculado) {
		this.matriculado = matriculado;
	}

	public void setGraduado(boolean graduado) {
		this.graduado = graduado;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public int getSemetre() {
		return semestre;
	}

	public boolean estaMatriculado() {
		return matriculado;
	}

	public boolean estaGraduado() {
		return graduado;
	}

	public Float getScore() {
		return score;
	}

	public Curso getCurso() {
		return curso;
	}

	public Historico getHistorico() {
		return historico;
	}
}