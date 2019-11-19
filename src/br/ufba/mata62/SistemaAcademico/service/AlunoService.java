package br.ufba.mata62.SistemaAcademico.service;

import br.ufba.mata62.SistemaAcademico.domain.Aluno;

public class AlunoService {
	
	public static void calculaSemestre(Aluno aluno) {
		aluno.setSemestre(HistoricoService.calculaSemestre(aluno.getHistorico()));
	}

	public static void calculaScore(Aluno aluno) {
		aluno.setScore(HistoricoService.calculaScore((aluno.getHistorico())));
	}	
	
}
