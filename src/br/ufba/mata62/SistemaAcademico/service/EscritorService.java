package br.ufba.mata62.SistemaAcademico.service;

import br.ufba.mata62.SistemaAcademico.domain.Curso;
import br.ufba.mata62.SistemaAcademico.domain.Historico;
import br.ufba.mata62.SistemaAcademico.repository.EscreveHtmlRepository;

public abstract class EscritorService {
	public abstract String escreveHistorico(Historico historico);
	public abstract String escreveCurriculo(Curso curso);
	
	
	//Métodos para salvar histórico e currículo. Deve ser sobreescrito em EscritorTxtService
	public void salvarHistorico(String nomeHtml, String historico) {
		EscreveHtmlRepository.salvarHistoricoHtml(nomeHtml, historico);
	}
	
	public void salvarCurriculo(String nomeHtml, String curriculo) {
		EscreveHtmlRepository.salvarCurriculoHtml(nomeHtml, curriculo);
	}

}
