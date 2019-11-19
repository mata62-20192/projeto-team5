package br.ufba.mata62.SistemaAcademico.service;

import java.util.ArrayList;
import java.util.List;

import br.ufba.mata62.SistemaAcademico.domain.Aluno;

public class EscalonamentoSemestreService implements EscalonamentoService{
	
	//Organiza alunos por semestre
	public List<Aluno> organizaAlunos(List<Aluno> alunos) {
		int i, j;		
		
		List<Aluno> alunosOrdenados = alunos;
		
		for(i = 0; i < alunos.size(); i++) {
			
			for(j = i+1; j < alunos.size(); j++) {
				if(alunos.get(j).getSemetre() > alunos.get(i).getSemetre()) {
					Aluno aluno = alunos.get(j);
					alunosOrdenados.set(i, alunos.get(j));
					alunosOrdenados.set(j, aluno);
				}
				
				else if(alunos.get(j).getSemetre() == alunos.get(i).getSemetre()) {
					//Caso o score seja igual, organiza por semestre
					if(alunos.get(j).getScore() > alunos.get(i).getScore()) {
						Aluno aluno = alunos.get(j);
						alunosOrdenados.set(i, alunos.get(j));	
						alunosOrdenados.set(j, aluno);						
					}
					
					
				}
			}
			
		}
		
		return alunosOrdenados;
	}
}
