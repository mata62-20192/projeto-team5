package br.ufba.mata62.SistemaAcademico.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import enums.Conceito;
import enums.Contrato;
import enums.Nivel;

public class Coordenador extends Professor {

	private Curso curso;
	private List<Aluno> alunos;	//Lista de alunos do curso inscritos na universidade
	private static ArrayList<Turma> turmas;

	public Coordenador(String nome, String matricula, String senha, String rg, String cpf, Contrato contrato,
			Nivel nivel, List<Aluno> alunos, Curso curso) {

		super(nome, matricula, senha, rg, cpf, contrato, nivel);
		
		this.alunos = alunos;
		
		turmas = new ArrayList<Turma>();	
		this.curso = curso;
	}
	
	//Verifica se o aluno já existe
	public void adicionarAluno(Aluno aluno) {
		alunos.add(aluno);
	}
			
	public Curso getCurso() {
		return curso;
	}


	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void criaTurma(Turma turma) {
		/*turmas.add(turma);

		Professor professor = turma.getProfessor();

		// Buscando índice do professor
		int index = universidade.getProfessores().indexOf(professor);

		// Adicionando a turma ao professor
		professor.adicionaTurma(turma);

		universidade.alteraProfessor(professor, index);*/
	}

	public void excluiTurma(Turma turma) {

		int index = turmas.indexOf(turma);
		turmas.remove(index);
	}

	// GETTERS E SETTERS
	public static List<Turma> getTurmas() {
		return Collections.unmodifiableList(turmas);
	}

}