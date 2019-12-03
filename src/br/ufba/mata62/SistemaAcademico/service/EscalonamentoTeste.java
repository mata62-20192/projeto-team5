package br.ufba.mata62.SistemaAcademico.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import br.ufba.mata62.SistemaAcademico.domain.Aluno;
import br.ufba.mata62.SistemaAcademico.domain.Coordenador;
import br.ufba.mata62.SistemaAcademico.domain.Disciplina;
import br.ufba.mata62.SistemaAcademico.domain.DisciplinaCursada;
import br.ufba.mata62.SistemaAcademico.domain.Historico;
import br.ufba.mata62.SistemaAcademico.domain.Universidade;

public class EscalonamentoTeste {
	
	Universidade universidade = new Universidade("Universidade Federal da Bahia", "UFBA", "20192",
			new ArrayList<Disciplina>());
	Coordenador coordenador;
	Aluno aluno;
	
	
	
	@BeforeEach
	public void inicializaUniversidade() {
		UniversidadeService.inicializaUniversidade(universidade);
		
		//Instanciando coordenador de engenhara de computação
		coordenador = UniversidadeService.getCoordenador(universidade, "2161");
		
		//Adicionando aluno qualquer
		aluno = new Aluno("Aluno", "222", "senha", "4041", "5050", UniversidadeService.getCurso(universidade, "186140"));
		
			try {
			CoordenadorService.adicionarAluno(universidade, coordenador, aluno);
		} catch (Exception e) {
			// Falha se deu exceção
			assertEquals(1, 0);
			e.printStackTrace();
		}
			
			adicionaAlunosAleatorios();
			darNotasAleatorias();
	}
	
	private void adicionaAlunosAleatorios() {
		Aluno aux;
		for(Integer i = 0; i < 50; i++) {
			aux = new Aluno( i.toString(), i.toString(), i.toString(), i.toString(), 
					i.toString(), UniversidadeService.getCurso(universidade, "186140"));
				
		
	
			try {
				CoordenadorService.adicionarAluno(universidade, coordenador, aux);
			} catch (Exception e) {
				// Falha se deu exceção
				assertEquals(1, 0);
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	private void darNotasAleatorias() {
		// Dá notas aleatórias para um aluno nas matérias obrigatórias.
		// Utilizado apenas para teste
		
			List<Aluno> alunos = coordenador.getAlunos();

			for (int i = 0; i < alunos.size(); i++) {
				Aluno aux = alunos.get(i);
				Historico historico = aux.getHistorico();

				for (int j = 0; j < historico.getDisciplinaCursada().size(); j++) {
					DisciplinaCursada disciplinaCursada = historico.getDisciplinaCursada().get(j);

					if (disciplinaCursada.getSemestre() == 0)
						break;
					else {
						Float nota = (new Random()).nextFloat() * 10;
						try {
							CoordenadorService.darNota(coordenador, aux, disciplinaCursada.getCodigo(), nota);
						} catch (Exception e) {
							assertEquals(1, 0);							
							e.printStackTrace();
						}
					}
				}
			}
	}
	
	
	@Test
	public void testeEscalonamentoPorScore() {
		if(coordenador.getAlunos().equals(null))
			System.out.println("OLÁ");

		//System.out.println(coordenador.getAlunos().size());
		
		List<Aluno> alunosOrdenados = 
				(new EscalonamentoScoreService()).organizaAlunos(coordenador.getAlunos());
		
		//Verificando se os alunos estão ordenados por score, do maior para o menor
		for(int index = 0; index < (alunosOrdenados.size() - 1); index++) {
			Aluno alunoAtual = alunosOrdenados.get(index);
			Aluno proximoAluno = alunosOrdenados.get(index + 1);
			
			if(alunoAtual.getScore() < proximoAluno.getScore())
				assertEquals(1, 0);	//Se não estiver ordenado, dá erro
		}
		
		assertEquals(1, 1);
	}
	
	@Test
	public void testeEscalonamentoPorSemestre() {
		List<Aluno> alunosOrdenados = 
				(new EscalonamentoSemestreService()).organizaAlunos(coordenador.getAlunos());
		
		//Verificando se os alunos estão ordenados por score, do maior para o menor
		for(int index = 0; index < (alunosOrdenados.size() - 1); index++) {
			Aluno alunoAtual = alunosOrdenados.get(index);
			Aluno proximoAluno = alunosOrdenados.get(index + 1);
			
			if(alunoAtual.getSemestre() < proximoAluno.getSemestre())
				assertEquals(1, 0);	//Se não estiver ordenado, dá erro
		}
		
		assertEquals(1, 1);
	}
	
}
