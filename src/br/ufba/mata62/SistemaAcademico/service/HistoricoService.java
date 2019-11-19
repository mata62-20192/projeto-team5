package br.ufba.mata62.SistemaAcademico.service;

import java.util.List;

import br.ufba.mata62.SistemaAcademico.domain.DisciplinaCursada;
import br.ufba.mata62.SistemaAcademico.domain.Historico;
import enums.Conceito;

public class HistoricoService {
		
	// Método para achar uma disciplinaCursada pelo código
		public static DisciplinaCursada getDisciplinaCursada(Historico historico, String codigoDisciplina) {
			List<DisciplinaCursada> disciplinas = historico.getDisciplinaCursada();
			for (int index = 0; index < disciplinas.size(); index++) {
				if (disciplinas.get(index).equals(codigoDisciplina))
					return disciplinas.get(index);
			}
			return null;
		}

		// Método para achar a posição da disciplina na lista
		public static int getDisciplinaCursadaIndex(Historico historico, String codigoDisciplina) {

			DisciplinaCursada aux = getDisciplinaCursada(historico, codigoDisciplina);

			return historico.getDisciplinaCursada().indexOf(aux);
		}
	
		public static int calculaSemestre(Historico historico) {
			DisciplinaCursada aux = null;
			
			List<DisciplinaCursada> disciplinas = historico.getDisciplinaCursada();
			
			for (int index = 0; index < disciplinas.size(); index++) {
				aux = historico.getDisciplinaCursada().get(index);	
				if(aux.getConceito() != Conceito.APROVADO)
					break;
			}
			
			return aux.getSemestre();	//Retorna semestre da disciplina não feita de menor semestre
		}

		public static float calculaScore(Historico historico) {
			float cr = 0;
			int numDisciplinas = 0;

			List<DisciplinaCursada> disciplinas = historico.getDisciplinaCursada();

			
			for (int index = 0; index < disciplinas.size(); index++) {
				Conceito conceito = disciplinas.get(index).getConceito();
				if (disciplinas.get(index).getNota() >= 0 && 
						(conceito.equals(Conceito.REPROVADO_NOTA) || conceito.equals(Conceito.APROVADO))) {
					cr += disciplinas.get(index).getNota();
					numDisciplinas++;
				}
			}
			cr /= (float) numDisciplinas;

			// Trunca cr em duas casas decimais
			cr *= 100;
			int aux = (int) cr;
			cr = aux;
			cr /= 100;

			return cr;
		}

		public static void calculaCHCursado(Historico historico) {
			int chCursada = 0;
			List<DisciplinaCursada> disciplinas = historico.getDisciplinaCursada();

			for (int index = 0; index < disciplinas.size(); index++) {
				DisciplinaCursada aux = disciplinas.get(index);
				if (aux.getConceito().equals(Conceito.APROVADO)) {
					chCursada += aux.getCh();
				}
			}
			historico.setchCursada(chCursada);
		}
}
