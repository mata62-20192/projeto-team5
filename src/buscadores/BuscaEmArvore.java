package buscadores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import br.ufba.mata62.SistemaAcademico.DisciplinaCursada;
import br.ufba.mata62.SistemaAcademico.DisciplinaSelecionada;

public class BuscaEmArvore {
		
	//Método para retornar um elemento genérico de um TreeSet genérico
	public <T> T getElemento(TreeSet<T> arvore, T elemento) {
		Iterator<T> iterator = arvore.iterator();
		T aux;
		while(iterator.hasNext()) {
			aux = iterator.next();
			if(aux.equals(elemento))
				return aux;
		}
		return null;
	}
	
	//Método para retornar um disciplinaSelecionada de um TreeSet pelo seu código
 	 public DisciplinaSelecionada getElemento(TreeSet<DisciplinaSelecionada> arvore, String codigo) {
 		 Iterator<DisciplinaSelecionada> iterator = arvore.iterator();
 		
 		 DisciplinaSelecionada aux; 
 		 while(iterator.hasNext()) {
 			  aux = iterator.next();
 			 
 			 if(aux.getDisciplina().getCodigo().equals(codigo))
 				 return aux;
 		 }
 		 return null;
 	 }
 	 
 	 /*Método para preencher lista de DisciplinaCursada do histórico com
 	 o TreeSet de DisciplinaSelecionada do curso */
 	 public void preencheHistorico(ArrayList<DisciplinaCursada> lista, TreeSet<DisciplinaSelecionada> arvore) {
 		Iterator<DisciplinaSelecionada> iterator =  arvore.iterator();
 		
		  while(iterator.hasNext()) {
			  DisciplinaSelecionada aux = iterator.next();
			  lista.add(new DisciplinaCursada(aux));
		  }
 	 }

}
