package br.ufba.mata62.SistemaAcademico.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import enums.Conceito;

public class Historico {
	Aluno aluno;
	int chCursada;
	ArrayList<DisciplinaCursada> disciplinaCursada;

	public Historico(Aluno aluno) {
		this.aluno = aluno;

		disciplinaCursada = new ArrayList<DisciplinaCursada>();

		// Adicionando lista de matériaCursada do histórico, que é igual a lista
		// de matériaSelecionada do curso
		
		System.out.println(aluno.getCurso());

		this.preencheHistorico(disciplinaCursada, aluno.getCurso().getDisciplinaSelecionada());
	}

	// Preenche histórico com disciplinas do curso
			// Private pois só pode ser feito uma vez
	private void preencheHistorico(ArrayList<DisciplinaCursada> lista, Set<DisciplinaSelecionada> arvore) {
		Iterator<DisciplinaSelecionada> iterator = arvore.iterator();

		while (iterator.hasNext()) {
			DisciplinaSelecionada aux = iterator.next();
			lista.add(new DisciplinaCursada(aux));
		}
	}

	// Muda uma disciplinaCursada na lista
	public void alteraDisciplinaCursada(int index, DisciplinaCursada disciplinaCursada) {
		this.disciplinaCursada.set(index, disciplinaCursada);
	}


	public List<DisciplinaCursada> getDisciplinaCursada() {
		return Collections.unmodifiableList(disciplinaCursada);
	}

	public Aluno getAluno() {
		return aluno;
	}

	public int getchCursada() {
		return chCursada;
	}
	
	public void setchCursada(int chCursada) {
		this.chCursada = chCursada;
	}
	
}