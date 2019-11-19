package br.ufba.mata62.SistemaAcademico.service;

import java.util.Iterator;

import br.ufba.mata62.SistemaAcademico.domain.Curso;
import br.ufba.mata62.SistemaAcademico.domain.DisciplinaSelecionada;

public class CursoService {
	// Método para retornar uma disciplinaSelecionada pelo seu código
		public static DisciplinaSelecionada getDisciplinaSelecionada(Curso curso, String codigo) {

			Iterator<DisciplinaSelecionada> iterator = curso.getDisciplinaSelecionada().iterator();
			DisciplinaSelecionada aux;
			while (iterator.hasNext()) {
				aux = iterator.next();
				if (aux.equals(codigo))
					return aux;
			}
			return null;
		}
		
		//Verifica se a disciplina existe no curso pelo código
		public static boolean existeDisciplinaSelecionada(Curso curso, String codigo) {

			Iterator<DisciplinaSelecionada> iterator = curso.getDisciplinaSelecionada().iterator();
			DisciplinaSelecionada aux;
			while (iterator.hasNext()) {
				aux = iterator.next();
				if (aux.equals(codigo))
					return true;
			}
			return false;
		}
}
