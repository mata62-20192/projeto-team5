package br.ufba.mata62.SistemaAcademico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DisciplinaSelecionada implements Comparable<DisciplinaSelecionada> {

	private Disciplina disciplina;
	private ArrayList<Disciplina> preRequisitos;
	private boolean obrigatoria;
	private int semestre;

	public DisciplinaSelecionada(Disciplina disciplina, ArrayList<Disciplina> preRequisitos, boolean obrigatoria,
			int semestre) {
		this.obrigatoria = obrigatoria;
		this.disciplina = disciplina;

		if (obrigatoria)
			this.semestre = semestre;
		else
			this.semestre = 0;

		this.preRequisitos = preRequisitos;

	}

	// Implementando TreeSet
	// Organiza por semestre. Caso o semestre seja o mesmo,
	// organiza por ordem alfabética
	@Override
	public int compareTo(DisciplinaSelecionada o) {
		if (semestre != 0) { // Se a matéria é obrigatória
			if (semestre - o.semestre != 0)
				return semestre - o.semestre;
			else
				return disciplina.getNome().compareTo(o.getDisciplina().getNome());
		} else // Se for optativa, vai pro final e é organizado por nome
		if (semestre - o.semestre != 0)
			return o.semestre - semestre;
		else
			return disciplina.getNome().compareTo(o.getDisciplina().getNome());
	}

	public boolean equals(String codigo) {
		if (disciplina.equals(codigo))
			return true;

		return false;
	}

	// GETTERS E SETTERS

	public String getNome() {
		return disciplina.getNome();
	}

	public String getCodigo() {
		return disciplina.getCodigo();
	}

	public int getCh() {
		return disciplina.getCh();
	}

	public List<Disciplina> getPreRequisito() {
		return Collections.unmodifiableList(preRequisitos);
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public boolean isObrigatoria() {
		return obrigatoria;
	}

	public int getSemestre() {
		return semestre;
	}

}