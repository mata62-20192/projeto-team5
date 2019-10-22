package br.ufba.mata62.SistemaAcademico;

import java.sql.Time;
import java.util.Date;

public class Turma {

	private Disciplina disciplina;
	private String codigo;
	private int capacidade;
	private Time horario;
	private Professor professor;

	public Turma(Disciplina disciplina, String codigo, int capacidade, Time horario, Professor professor) {
		this.disciplina = disciplina;
		this.codigo = codigo;
		this.capacidade = capacidade;
		this.horario = horario;
		this.professor = professor;
	}

	// GETTERS E SETTERS

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public void setHorario(Time horario) {
		this.horario = horario;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Professor getProfessor() {
		return professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public Date getHorario() {
		return horario;
	}

}