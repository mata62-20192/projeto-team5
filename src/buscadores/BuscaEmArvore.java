package buscadores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import br.ufba.mata62.SistemaAcademico.DisciplinaCursada;
import br.ufba.mata62.SistemaAcademico.DisciplinaSelecionada;

public class BuscaEmArvore {
		
	//M�todo para retornar um elemento gen�rico de um TreeSet gen�rico
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
	
	//M�todo para retornar um disciplinaSelecionada de um TreeSet pelo seu c�digo
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
 	 
 	 /*M�todo para preencher lista de DisciplinaCursada do hist�rico com
 	 o TreeSet de DisciplinaSelecionada do curso */
 	 public void preencheHistorico(ArrayList<DisciplinaCursada> lista, TreeSet<DisciplinaSelecionada> arvore) {
 		Iterator<DisciplinaSelecionada> iterator =  arvore.iterator();
 		
		  while(iterator.hasNext()) {
			  DisciplinaSelecionada aux = iterator.next();
			  lista.add(new DisciplinaCursada(aux));
		  }
 	 }

}
