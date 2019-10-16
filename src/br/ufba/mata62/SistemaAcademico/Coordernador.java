package br.ufba.mata62.SistemaAcademico;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import buscadores.BuscaEmLista;
import enums.Conceito;
import enums.Contrato;
import enums.Nivel;

public class Coordernador extends Professor{
	
	private Universidade universidade;
	private static ArrayList<Turma> turmas;
	
  public Coordernador(String nome, String matricula, String senha, String rg, 
		  String cpf, Contrato contrato, Nivel nivel, Universidade universidade) {
	  
		super(nome, matricula, senha, rg, cpf, contrato, nivel);
		this.universidade = universidade;
		
		turmas = new ArrayList<Turma>();
  }
  
  public void adicionarAluno(Aluno aluno) {
	  universidade.adicionaAluno(aluno);
  };
  
  public void aprovaMatricula(Aluno aluno) {
	  
  };
  
  	//Método para o Coordenador dar conceito a uma matéria de um aluno
  public void darConceito(Aluno aluno, String codigoDisciplina, Conceito conceito) {
	  
	  		//Cria DisciplinaCursada e busca na lista do histórico
			DisciplinaCursada disciplinaCursada = aluno.getHistorico().getDisciplinaCursada(codigoDisciplina);
			
			//Faz busca na lista pela posição da disciplina que receberá a nota
			int index = aluno.getHistorico().getDisciplinaCursadaIndex(codigoDisciplina);
			
			if(index == -1) //Disciplina não existe para o aluno
				throw new NoSuchElementException("Disciplina não existe para o aluno");
			
			//Se o conceito for aprovado ou reprovado por nota, não será possível dar o conceito sem nota
			if(conceito.equals(Conceito.APROVADO) || conceito.equals(Conceito.REPROVADONOTA))
				System.out.println("Não é possível dar o conceito " + conceito + " sem nota" );
			
			else {
				disciplinaCursada.setConceito(conceito);
				aluno.getHistorico().getDisciplinaCursada().set(index, disciplinaCursada);
			}
  }
  
  public void darNota(Aluno aluno, String codigoDisciplina, float nota) {	
	  
		//Cria DisciplinaCursada e busca na lista do histórico
		DisciplinaCursada disciplinaCursada = aluno.getHistorico().getDisciplinaCursada(codigoDisciplina);
		
		//Faz busca na lista pela posição da disciplina que receberá a nota
		int index = aluno.getHistorico().getDisciplinaCursadaIndex(codigoDisciplina);
		
		if(index == -1) //Disciplina não existe para o aluno
			throw new NoSuchElementException("Disciplina não existe para o aluno");
		
		disciplinaCursada.setNota(nota);
		
		if(nota >= 5.0)
			disciplinaCursada.setConceito(Conceito.APROVADO);
		else
			disciplinaCursada.setConceito(Conceito.REPROVADONOTA);

		
		//Altera disciplina com nova nota
		aluno.getHistorico().getDisciplinaCursada().set(index, disciplinaCursada);	
			
		//Tendo uma nota nova, calcula-se o score novo do aluno
		aluno.calculaScore();
  }
  
  public void criaTurma(Turma turma) {
	  turmas.add(turma);
	  
	  	Professor professor = turma.getProfessor();
	  
		BuscaEmLista busca = new BuscaEmLista();
		
		//Buscando índice do professor
		int index = busca.getIndex(universidade.getProfessores(), professor);
		
		//Adicionando a turma ao professor	 
		professor.adicionaTurma(turma);

		universidade.setProfessor(professor, index);
  }
  
  public void excluiTurma(Turma turma) {;
		BuscaEmLista busca = new BuscaEmLista();
 		int index = busca.getIndex(turmas, turma);
 		turmas.remove(index);
  }
  
  //GETTERS E SETTERS
  public static ArrayList<Turma> getTurmas(){
		return turmas;  
	  }
  
}