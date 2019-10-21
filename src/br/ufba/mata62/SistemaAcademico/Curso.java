package br.ufba.mata62.SistemaAcademico;

import java.util.Iterator;

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

	// Método para retornar uma disciplinaSelecionada pelo seu código
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

	// GETTERS E SETTERS
	public void adicionaDisciplinaSelecionada(DisciplinaSelecionada disciplinaSelecionada) {
		this.disciplinaSelecionada.add(disciplinaSelecionada);
	}

	public TreeSet<DisciplinaSelecionada> getDisciplinaSelecionada() {
		return disciplinaSelecionada;
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
