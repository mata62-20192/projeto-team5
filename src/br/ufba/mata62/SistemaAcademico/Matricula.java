package br.ufba.mata62.SistemaAcademico;

import java.util.ArrayList;

public class Matricula{
	
	private ArrayList<Turma> turmasEscolhidas;
	private ArrayList<Turma> turmasDisponiveis;
	
	 //Matricula recebe histórico e curso para saber quais matérias 
	//estarão disponíveis para o aluno
	private Historico historico;
	private Curso curso;
	
	public Matricula(Historico historico, Curso curso) {
		this.historico = historico;
		this.curso = curso;
		}

  // GETTERS E SETTERS

  public void setTurmasEscolhidas(ArrayList<Turma> turmas){
    this.turmasEscolhidas = turmas;
  }

  public void setTurmasDisponiveis(ArrayList<Turma> turmas){
    this.turmasDisponiveis = turmas;
  }

  public ArrayList<Turma> getTurmasEscolhidas(){
    return turmasEscolhidas;
  }

  public ArrayList<Turma> getTurmasDisponiveis(){
    return turmasDisponiveis;
  }

}