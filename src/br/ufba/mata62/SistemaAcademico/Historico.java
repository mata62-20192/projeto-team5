package br.ufba.mata62.SistemaAcademico;

import java.util.ArrayList;

import buscadores.BuscaEmArvore;
import buscadores.BuscaEmLista;

public class Historico{
	Aluno aluno;
	ArrayList<DisciplinaCursada> disciplinaCursada;
	
	public Historico(Aluno aluno){
		this.aluno = aluno;
		
		disciplinaCursada = new ArrayList<DisciplinaCursada>();
		 
		//Adicionando lista de mat�riaCursada do hist�rico, que � igual a lista 
		//de mat�riaSelecionada do curso
		BuscaEmArvore busca = new BuscaEmArvore();
		busca.preencheHistorico(disciplinaCursada, aluno.getCurso().getDisciplinaSelecionada());
	}

	public ArrayList<DisciplinaCursada> getDisciplinaCursada() {
		return disciplinaCursada;
	}
	
	//M�todo para achar uma disciplina
	public DisciplinaCursada getDisciplinaCursada(String codigoDisciplina) {
		
		BuscaEmLista busca = new BuscaEmLista();
		return busca.getDisciplinaCursada(disciplinaCursada, codigoDisciplina);
	}
	
	//M�todo para achar a posi��o da disciplina na lista
	public int getDisciplinaCursadaIndex(String codigo) {
		
		BuscaEmLista busca = new BuscaEmLista();
		
		return busca.getDisciplinaCursadaIndex(disciplinaCursada, codigo);
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