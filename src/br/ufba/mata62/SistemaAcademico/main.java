package br.ufba.mata62.SistemaAcademico;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import LeitorTXT.LeitorTXT;
import enums.Contrato;
import enums.Nivel;


public class main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Universidade universidade = new Universidade("Universidade Federal da Bahia", 
				"UFBA", "20192", new ArrayList<Disciplina>());
		
		//Lendo txt
		LeitorTXT.leitor(universidade);
		
		
		
		
		
		/*********************************************************/
		
		// Imprimindo disciplinas da universidade, lidas no txt 
		for(Disciplina d : universidade.getDisciplinas())
			System.out.println(d.getNome());
		
		
		
		
		
		
		
		
		
		
		/*********************************************************/
		/* Imprimindo  disciplinas de engenharia de computação, que tem código 186140 
		  As disciplinas são impressas em ordem de semestre e por último as optativas*/
		/* 
		Curso curso = null;
		for(int index = 0; index < universidade.getCursos().size(); index++) {
			if(universidade.getCursos().get(index).getCodigo().equals("186140")) {
				curso = universidade.getCursos().get(index);
				break;
			}
		}
		
		for(DisciplinaSelecionada d : curso.getDisciplinaSelecionada())
			System.out.println(d.getDisciplina().getNome());
		*/
	
		
		
		
		
		
		
		
		
		
		
		
		
		/*********************************************************/
		/*Criando coordenador e um aluno de engenharia de computação, 
		  passando o código 186140 do curso para o aluno*/
		
		/*
		Coordernador coordenador = new Coordernador("Coordenador", "Matricula", "Senha", 
				"rg", "cpf", Contrato.DEFINITIVO, Nivel.DOUTORADO, universidade);
		
		Aluno aluno = new Aluno("Aluno", "Matricula", "Senha", "1111", 
				"1112365", universidade.getCurso("186140"));
		
		coordenador.adicionarAluno(aluno);	
		
		//Dando nota de 7.3 ao aluno para a disciplina MATA02 (primeira disciplina)
		//As disciplinas sem notas, ficam com -1.0
		coordenador.darNota(aluno, "MATA02", (float)7.3);
		
		
			//Imprimindo notas do aluno no histórico
			for(DisciplinaCursada disciplinaCursada : aluno.getHistorico().getDisciplinaCursada())
				System. out .println(disciplinaCursada.getNota());
		
					
			 	//Imprimindo score do aluno
				System.out.println("Score: " + aluno.getScore());
			
		*/
	}
		
}