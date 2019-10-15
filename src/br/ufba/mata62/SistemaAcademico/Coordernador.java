package br.ufba.mata62.SistemaAcademico;

import java.util.ArrayList;

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
  
  public void darNota(Aluno aluno, String codigo, float nota) {
		ArrayList<DisciplinaCursada> disciplinaCursada = aluno.getHistorico().getDisciplinaCursada();
			
			for(int index = 0; index < disciplinaCursada.size(); index++) {
				if(codigo.equals(disciplinaCursada.get(index).getDisciplinaSelecionada().getDisciplina().getCodigo())){
					DisciplinaCursada aux = disciplinaCursada.get(index);
					
					aux.setNota(nota);
					
					//Se a nota é maior que 5.0, o aluno está aprovado
					if(nota >= 5.0)
					aux.setConcluida(true);
					
					aluno.getHistorico().getDisciplinaCursada().set(index, aux);	
					break;
				}				
			}
			
			//Tendo uma nota nova, calcula-se o score novo do aluno
			aluno.calculaScore();
  };
  
  public void criaTurma(Turma turma) {
	  turmas.add(turma);
	  
	  //Adicionando a turma ao professor	 
	  Professor professor = turma.getProfessor();
	  
	  for(int index = 0; index < universidade.getProfessores().size(); index++) {
		  if(professor.equals(universidade.getProfessores().get(index))) {
			  professor.adicionaTurma(turma);
			  universidade.setProfessor(professor, index);
			  break;
		  }
	  }
  };
  
  public void excluiTurma(String codigo) {;
  		for(int index = 0; index < turmas.size(); index++) {
  			if(codigo.equals(turmas.get(index).getCodigo())) {
  				turmas.remove(index);
  				break;
  			}
  		}
  			
  }
  
  //GETTERS E SETTERS
  public static ArrayList<Turma> getTurmas(){
		return turmas;  
	  }
  
}