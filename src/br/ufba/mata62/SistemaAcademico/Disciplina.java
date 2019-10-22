package br.ufba.mata62.SistemaAcademico;

public class Disciplina {

	private String nome;
	private String codigo;
	private int ch;

	public Disciplina(String nome, String codigo, int ch) {
		this.nome = nome;
		this.codigo = codigo;
		this.ch = ch;
	}

	public boolean equals(String codigo) {
		if (this.codigo.equals(codigo))
			return true;

		return false;
	}

	// GETTES E SETTERS

	public String getNome() {
		return nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getCh() {
		return ch;
	}

}