package br.ufba.mata62.SistemaAcademico;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Curso {

	private String nome;
	private String codigo;
	private int numeroSemestres;
	private int ch;

	// TreeSet organiza disciplinas pelo semestre
	private TreeSet<DisciplinaSelecionada> disciplinaSelecionada;

	// Instanciar curso sem disciplinas
	public Curso(String nome, String codigo) {
		this.nome = nome;
		this.codigo = codigo;
		disciplinaSelecionada = new TreeSet<DisciplinaSelecionada>();
	}

	// Instanciar curso com disciplinas
	public Curso(String nome, String codigo, TreeSet<DisciplinaSelecionada> disciplinaSelecionada) {
		this.nome = nome;
		this.codigo = codigo;
		this.disciplinaSelecionada = disciplinaSelecionada;
	}

	public boolean equals(String codigo) {

		if (this.codigo.equals(codigo))
			return true;

		return false;
	}

	// M�todo para retornar uma disciplinaSelecionada pelo seu c�digo
	public DisciplinaSelecionada getDisciplinaSelecionada(String codigo) {

		Iterator<DisciplinaSelecionada> iterator = disciplinaSelecionada.iterator();
		DisciplinaSelecionada aux;
		while (iterator.hasNext()) {
			aux = iterator.next();
			if (aux.equals(codigo))
				return aux;
		}
		return null;
	}

	public void adicionaDisciplinaSelecionada(DisciplinaSelecionada disciplinaSelecionada) {
		this.ch += disciplinaSelecionada.getCh();
		this.disciplinaSelecionada.add(disciplinaSelecionada);
	}

	// GETTERS E SETTERS
	public Set<DisciplinaSelecionada> getDisciplinaSelecionada() {
		return Collections.unmodifiableSet(disciplinaSelecionada);
	}

	public void setNumeroSemestres(int num) {
		this.numeroSemestres = num;
	}

	// Getters
	public String getNome() {
		return nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getNumeroSemestres() {
		return numeroSemestres;
	}

	public int getCh() {
		return ch;
	}

}
