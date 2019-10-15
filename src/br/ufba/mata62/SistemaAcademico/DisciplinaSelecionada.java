package br.ufba.mata62.SistemaAcademico;

import java.util.ArrayList;

public class DisciplinaSelecionada implements Comparable<DisciplinaSelecionada>{

  private Disciplina disciplina;	
  private ArrayList<Disciplina> preRequisito;
  private boolean obrigatoria;
  private int semestre;

  public DisciplinaSelecionada(String codigoDisciplina, ArrayList<String> codigosPreRequisitos, 
		  						boolean obrigatoria, int semestre){
	this.obrigatoria = obrigatoria;
	
	if(obrigatoria)
		this.semestre = semestre;
	else
		this.semestre = 0;
	
	//Pelos códigos, serão encontrados os pré-requisitos na lista de disciplinas da universidade
    int index = 0;
    int index2 = 0;

    if(!codigosPreRequisitos.isEmpty()) {
    	preRequisito = new ArrayList<Disciplina>();
    while(index < codigosPreRequisitos.size()) {
    	
        while(index2 < Universidade.getDisciplinas().size()) {
        	
        	if(codigosPreRequisitos.get(index).equals(Universidade.getDisciplinas().get(index2).getCodigo())) {
        		preRequisito.add(Universidade.getDisciplinas().get(index));
        		break;
        		}

        	index2++;
        	}
        index2 = 0;
        index++;
    	}
    }
    
    //Pelo código, será encontrada a disciplina de DisciplinaSelecionada, na lista da universidade
    index = 0;
    while(index < Universidade.getDisciplinas().size()) {
    	if(codigoDisciplina.equals(Universidade.getDisciplinas().get(index).getCodigo())) {
    	this.disciplina = Universidade.getDisciplinas().get(index);
    	break;
    	}
    index++;
    }
  }
  
  //Implementando TreeSet
  //Organiza por semestre. Caso o semestre seja o mesmo,
  //organiza por ordem alfabética
  @Override
  public int compareTo(DisciplinaSelecionada o) {
	if(semestre != 0) {  //Se a matéria é obrigatória
  	if(semestre - o.semestre != 0)
  		return semestre - o.semestre;
  	else
  		return disciplina.getNome().compareTo(o.getDisciplina().getNome());
	}
	else				//Se for optativa, vai pro final e é organizado por nome
	  	if(semestre - o.semestre != 0)
	  		return o.semestre - semestre;
	  	else
	  		return disciplina.getNome().compareTo(o.getDisciplina().getNome());
  }

  // GETTERS E SETTERS

  public ArrayList<Disciplina> getPreRequisito(){
    return preRequisito;
  }

  public Disciplina getDisciplina() {
	return disciplina;
  }

  public boolean isObrigatoria() {
	return obrigatoria;
  }

  public int getSemestre() {
	return semestre;
  }

}