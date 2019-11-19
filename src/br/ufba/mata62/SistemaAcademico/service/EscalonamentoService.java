package br.ufba.mata62.SistemaAcademico.service;

import java.util.ArrayList;

import java.util.List;

import br.ufba.mata62.SistemaAcademico.domain.Aluno;

public interface EscalonamentoService {
	public List<Aluno> organizaAlunos(List<Aluno> alunos);
}
