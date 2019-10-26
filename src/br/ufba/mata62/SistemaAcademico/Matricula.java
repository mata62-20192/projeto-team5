package br.ufba.mata62.SistemaAcademico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Matricula {

	private ArrayList<Turma> turmasEscolhidas;
	private ArrayList<Turma> turmasDisponiveis;

	// Matricula recebe histórico e curso para saber quais matérias
	// estarão disponíveis para o aluno
	private Historico historico;
	private Curso curso;

	public Matricula(Historico historico, Curso curso) {
		this.historico = historico;
		this.curso = curso;
	}

	// GETTERS E SETTERS

	public void setTurmasEscolhidas(ArrayList<Turma> turmas) {
		this.turmasEscolhidas = turmas;
	}

	public void setTurmasDisponiveis(ArrayList<Turma> turmas) {
		this.turmasDisponiveis = turmas;
	}

	public List<Turma> getTurmasEscolhidas() {
		return Collections.unmodifiableList(turmasEscolhidas);
	}

	public List<Turma> getTurmasDisponiveis() {
		return Collections.unmodifiableList(turmasDisponiveis);
	}

}