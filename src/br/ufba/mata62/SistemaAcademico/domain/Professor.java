package br.ufba.mata62.SistemaAcademico.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import enums.Contrato;
import enums.Nivel;

public class Professor extends Pessoa {
	private final Nivel nivel;
	private final Contrato contrato;
	private ArrayList<Turma> turmas;

	public Professor(String nome, String matricula, String senha, String rg, String cpf, Contrato contrato,
			Nivel nivel) {
		super(nome, matricula, senha, rg, cpf);
		this.contrato = contrato;
		this.nivel = nivel;
		turmas = new ArrayList<Turma>();
	}

	public void adicionaTurma(Turma turma) {
		turmas.add(turma);
	}

	public Nivel getNivel() {
		return nivel;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public List<Turma> getTurmasProfessor() {
		return Collections.unmodifiableList(turmas);
	}

}