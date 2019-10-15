package br.ufba.mata62.SistemaAcademico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Historico{
	Curso curso;
	ArrayList<DisciplinaCursada> disciplinaCursada;
	
	public Historico(Curso curso){
		this.curso = curso;
		
		disciplinaCursada = new ArrayList<DisciplinaCursada>();
		
		//Adicionando lista de matériaCursada do histórico, que é igual a lista 
		//de matériaSelecionada do curso
		
		Iterator<DisciplinaSelecionada> iterator =  curso.getDisciplinaSelecionada().iterator();
		  while(iterator.hasNext()) {
			  DisciplinaSelecionada aux = iterator.next();
			  disciplinaCursada.add(new DisciplinaCursada(aux));
		  }
	}

	public ArrayList<DisciplinaCursada> getDisciplinaCursada() {
		return disciplinaCursada;
	}
	
	//Método para achar uma disciplina
	public DisciplinaCursada getDisciplinaCursada(String codigo) {
		int index = 0;
		DisciplinaCursada aux = disciplinaCursada.get(index);
		
		while(aux != null) {
			if(aux.disciplinaSelecionada.getDisciplina().getCodigo().equals(codigo))
				return aux;
			aux = disciplinaCursada.get(index++);
		}
		return null;
	}
	
	//Muda uma Disciplina Cursada na lista de acordo com o código
	public void setDisciplinaCursada(String codigo, DisciplinaCursada disciplinaCursada) {
		for(int index = 0; index < this.disciplinaCursada.size(); index++) {
			if(codigo.equals(this.disciplinaCursada.get(index))) {
				this.disciplinaCursada.set(index, disciplinaCursada);
				break;
			}			
		}
	}
	
	public float calculaScore() {
		float cr = 0;
		int numDisciplinas = 0;
		
		for(int index = 0; index < this.disciplinaCursada.size(); index++) {
			if(disciplinaCursada.get(index).getNota() >= 0) {
			cr += disciplinaCursada.get(index).getNota();
			numDisciplinas++;
				}
			}	
		cr /= (float)numDisciplinas;
		return cr;
		}
	
  
}