package br.ufba.mata62.SistemaAcademico;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import enums.Contrato;
import enums.Nivel;
import escritores.EscreveHTML;
import escritores.EscreveTXT;
import leitorTXT.LeitorTXT;

public class main {

	public static void darNotas(Coordernador coordenador, List<Aluno> alunos) {
		// D� notas aleat�rias para os alunos nas mat�rias obrigat�rias.
		// Utilizado apenas para teste

		for (int i = 0; i < alunos.size(); i++) {
			Aluno aux = alunos.get(i);
			Historico historico = aux.getHistorico();

			for (int j = 0; j < historico.getDisciplinaCursada().size(); j++) {
				DisciplinaCursada disciplinaCursada = historico.getDisciplinaCursada().get(j);

				if (disciplinaCursada.getSemestre() == 0)
					break;
				else {
					Float nota = (new Random()).nextFloat() * 10;
					coordenador.darNota(alunos.get(i), disciplinaCursada.getCodigo(), nota);
				}
			}
		}

	}

	public static void main(String[] args) {

		Universidade universidade = new Universidade("Universidade Federal da Bahia", "UFBA", "20192",
				new ArrayList<Disciplina>());

		// Lendo txt da universidade
		LeitorTXT.leitor(universidade);

		Coordernador coordenador = new Coordernador("Coordenador", "Matricula", "Senha", "rg", "cpf",
				Contrato.DEFINITIVO, Nivel.DOUTORADO, universidade);

		Integer matricula = 1;

		// Criando alunos aleat�rios
		// Criando aluno de engenharia de computa��o
		Aluno aluno = new Aluno("Fulano", (matricula++).toString(), "Senha", "rg", "cpf",
				universidade.getCurso("186140"));

		coordenador.adicionarAluno(aluno);

		// Criando aluno de LC
		Aluno aluno2 = new Aluno("Sicrano", (matricula++).toString(), "Senha", "rg", "cpf",
				universidade.getCurso("196120"));
		coordenador.adicionarAluno(aluno2);

		// Criando aluno de CC
		Aluno aluno3 = new Aluno("Beltrano", (matricula++).toString(), "Senha", "rg", "cpf",
				universidade.getCurso("112140"));
		coordenador.adicionarAluno(aluno3);

		// Criando aluno de SI
		Aluno aluno4 = new Aluno("Fulano Sicrano", (matricula++).toString(), "Senha", "rg", "cpf",
				universidade.getCurso("195140"));
		coordenador.adicionarAluno(aluno4);

		// Dando notas aleat�rias para as disciplinas obrigat�rias
		darNotas(coordenador, universidade.getAlunos());

		EscreveTXT.escreveListaAlunos(universidade.getAlunos());
		
		EscreveHTML.escreveHistoricoHTML(aluno.getHistorico());
	}

}