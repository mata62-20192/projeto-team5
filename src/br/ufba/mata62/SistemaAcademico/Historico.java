package br.ufba.mata62.SistemaAcademico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Historico {
	Aluno aluno;
	ArrayList<DisciplinaCursada> disciplinaCursada;

	public Historico(Aluno aluno) {
		this.aluno = aluno;

		disciplinaCursada = new ArrayList<DisciplinaCursada>();

		// Adicionando lista de mat�riaCursada do hist�rico, que � igual a lista
		// de mat�riaSelecionada do curso
		this.preencheHistorico(disciplinaCursada, aluno.getCurso().getDisciplinaSelecionada());
	}

	// Preenche hist�rico com disciplinas do curso
	// Private pois s� pode ser feito uma vez
	private void preencheHistorico(ArrayList<DisciplinaCursada> lista, TreeSet<DisciplinaSelecionada> arvore) {
		Iterator<DisciplinaSelecionada> iterator = arvore.iterator();

		while (iterator.hasNext()) {
			DisciplinaSelecionada aux = iterator.next();
			lista.add(new DisciplinaCursada(aux));
		}
	}

	public float calculaScore() {
		float cr = 0;
		int numDisciplinas = 0;

		for (int index = 0; index < this.disciplinaCursada.size(); index++) {
			if (disciplinaCursada.get(index).getNota() >= 0) {
				cr += disciplinaCursada.get(index).getNota();
				numDisciplinas++;
			}
		}
		cr /= (float) numDisciplinas;
		return cr;
	}

	// Muda uma disciplinaCursada na lista
	public void alteraDisciplinaCursada(int index, DisciplinaCursada disciplinaCursada) {
		this.disciplinaCursada.set(index, disciplinaCursada);
	}

	// M�todo para achar uma disciplinaCursada pelo c�digo
	public DisciplinaCursada getDisciplinaCursada(String codigoDisciplina) {
		for (int index = 0; index < disciplinaCursada.size(); index++) {
			if (disciplinaCursada.get(index).equals(codigoDisciplina))
				return disciplinaCursada.get(index);
		}
		return null;
	}

	// M�todo para achar a posi��o da disciplina na lista
	public int getDisciplinaCursadaIndex(String codigoDisciplina) {

		DisciplinaCursada aux = this.getDisciplinaCursada(codigoDisciplina);

		return disciplinaCursada.indexOf(aux);
	}

	public List<DisciplinaCursada> getDisciplinaCursada() {
		return Collections.unmodifiableList(disciplinaCursada);
	}
}