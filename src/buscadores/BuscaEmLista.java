package buscadores;

import java.util.ArrayList;

import br.ufba.mata62.SistemaAcademico.Curso;
import br.ufba.mata62.SistemaAcademico.Disciplina;
import br.ufba.mata62.SistemaAcademico.DisciplinaCursada;

public class BuscaEmLista {
	
	//Pegar índice de um elemento qualquer em uma lista qualquer
	public <T> int getIndex(ArrayList<T> lista, T elemento) {
		for(int index = 0; index < lista.size(); index++) {
			if(lista.get(index).equals(elemento))
				return index;
		}
		return -1;
	}
	
	//Pegar um elemento qualquer em uma lista qualquer
		public <T> T getElemento(ArrayList<T> lista, T elemento) {
			for(int index = 0; index < lista.size(); index++) {
				if(lista.get(index).equals(elemento))
					return lista.get(index);
			}
			return null;
		}
	
	//Pegar Curso pelo código do Curso
		public Curso getCurso(ArrayList<Curso> lista, String codigoCurso) {
			for(int index = 0; index < lista.size(); index++) {
				if(lista.get(index).getCodigo().equals(codigoCurso))
					return lista.get(index);
			}
			return null;
		}
	
	//Pegar Disciplina pelo código da Disciplina
		public Disciplina getDisciplina(ArrayList<Disciplina> lista, String codigoDisciplina) {
			for(int index = 0; index < lista.size(); index++) {
				if(lista.get(index).getCodigo().equals(codigoDisciplina))
					return lista.get(index);
			}
			return null;
		}

	
	//Pegar uma DisciplinaSelecionada pelo código da Disciplina
	public DisciplinaCursada getDisciplinaCursada(ArrayList<DisciplinaCursada> lista, String codigoDisciplina) {
		for(int index = 0; index < lista.size(); index++) {
			if(lista.get(index).getDisciplinaSelecionada().getDisciplina().getCodigo().equals(codigoDisciplina))
				return lista.get(index);
		}
		return null;
	}
	
	//Pegar índice de uma DisciplinaSelecionada pelo código da Disciplina
		public int getDisciplinaCursadaIndex(ArrayList<DisciplinaCursada> lista, String codigoDisciplina) {
			for(int index = 0; index < lista.size(); index++) {
				if(lista.get(index).getDisciplinaSelecionada().getDisciplina().getCodigo().equals(codigoDisciplina))
					return index;
			}
			return -1;
		}
	
}
