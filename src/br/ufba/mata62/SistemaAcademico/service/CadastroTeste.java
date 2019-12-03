package br.ufba.mata62.SistemaAcademico.service;

import static org.junit.Assert.assertEquals;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ufba.mata62.SistemaAcademico.domain.Aluno;
import br.ufba.mata62.SistemaAcademico.domain.Coordenador;
import br.ufba.mata62.SistemaAcademico.domain.Disciplina;
import br.ufba.mata62.SistemaAcademico.domain.Universidade;

public class CadastroTeste {
	//Inicializando universidade e coordenador
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
		}
	}
	
	@Test
	public void testeAdicionandoAluno() {
		//Adicionando aluno
		Aluno aluno = new Aluno("Aluno2", "333", "senha", "5050", "7071", UniversidadeService.getCurso(universidade, "186140"));
		try {
			CoordenadorService.adicionarAluno(universidade, coordenador, aluno);
			//Se adicionou, deu certo
			assertEquals(1, 1);
		} catch (Exception e) {
			//Se não adicionou, deu errado
			assertEquals(1, 0);
			e.printStackTrace();
		}
			
	}
	
	@Test
	public void testeAdicionandoAlunoQueJaExisteMatricula() {
			//Adiciona aluno que já existe outro com mesma matrícula
			Aluno aluno = new Aluno("Aluno", "222", "senha", "4789", "8487", UniversidadeService.getCurso(universidade, "186140"));
			
			//Se lançar exceção, deu certo
			assertThrows(Exception.class, () -> {
				CoordenadorService.adicionarAluno(universidade, coordenador, aluno);
			});	
	}

	@Test
	public void testeAdicionandoAlunoQueJaExisteRg() {
			//Adiciona aluno que já existe outro com mesmo rg
			Aluno aluno = new Aluno("Aluno", "400", "senha", "4041", "3126", UniversidadeService.getCurso(universidade, "186140"));
			//Se lançar exceção, deu certo
			assertThrows(Exception.class, () -> {
				CoordenadorService.adicionarAluno(universidade, coordenador, aluno);
			});	
	}
	
	@Test
	public void testeAdicionandoAlunoQueJaExisteCpf() {
			//Adiciona aluno que já existe outro com mesmo cpf
			Aluno aluno = new Aluno("Aluno", "400", "senha", "1461", "5050", UniversidadeService.getCurso(universidade, "186140"));
			
			//Se lançar exceção, deu certo
			assertThrows(Exception.class, () -> {
				CoordenadorService.adicionarAluno(universidade, coordenador, aluno);
			});	
	}
	

	@Test
	public void testeBuscarAlunoAdicionado() {
			assertTrue(CoordenadorService.alunoExiste(coordenador, aluno));
	}
	
	@Test
	public void testeBuscarAlunoNaoAdicionado() {
			Aluno aluno = new Aluno("Aluno", "400", "senha", "1461", "5198", UniversidadeService.getCurso(universidade, "186140"));
			assertFalse(CoordenadorService.alunoExiste(coordenador, aluno));
	}
	
	
	
}

