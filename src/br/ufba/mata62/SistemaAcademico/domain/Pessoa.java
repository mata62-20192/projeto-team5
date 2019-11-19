package br.ufba.mata62.SistemaAcademico.domain;

public abstract class Pessoa {

	private final String nome;
	private final String matricula;
	private final String senha;
	private final String rg;
	private final String cpf;

	public Pessoa(String nome, String matricula, String senha, String rg, String cpf) {
		this.nome = nome;
		this.matricula = matricula;
		this.senha = senha;
		this.rg = rg;
		this.cpf = cpf;
	}

	// GETTES E SETTERS
	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getSenha() {
		return senha;
	}

	public String getRg() {
		return rg;
	}

	public String getCpf() {
		return cpf;
	}

}