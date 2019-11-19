package br.ufba.mata62.SistemaAcademico.service;

import java.util.Iterator;

import br.ufba.mata62.SistemaAcademico.domain.Aluno;
import br.ufba.mata62.SistemaAcademico.domain.Curso;
import br.ufba.mata62.SistemaAcademico.domain.DisciplinaCursada;
import br.ufba.mata62.SistemaAcademico.domain.DisciplinaSelecionada;
import br.ufba.mata62.SistemaAcademico.domain.Historico;
import br.ufba.mata62.SistemaAcademico.repository.EscreveHtmlRepository;

public class EscritorHtmlService extends EscritorService{
	
	@Override
	public String escreveHistorico(Historico historico) {
		Aluno aluno = historico.getAluno();    
        
        StringBuilder string = new StringBuilder();
        string.append("<html><head><meta charset = \"utf-8\"><title>Histórico "+ aluno.getNome() +"</title><style>td{padding: 5px;}</style></head><body>");
        string.append("<p>Aluno: " + aluno.getNome() + "</p>");
        string.append("<p>Matrícula: " + aluno.getMatricula() + "</p>");         
        string.append("<p>Curso: " + aluno.getCurso().getNome() + "</p>");
        string.append("<p>Score: " + aluno.getScore() + "</p>");
        string.append("<p>Carga horária cursada: " + historico.getchCursada() + " Horas</p>");
        
        for(int i=0; i<3; i++)
            string.append("<br>");

        string.append("<h1>IMPRESSÃO DE HISTÓRICO</h1>");
        
        
        //código, nome, carga horária, natureza, nota e conceito 
        
        int semestreAtual = 1;

            string.append("<br><br>");
            string.append("<h2>Semestre 1</h2><br>");
            string.append("<table>");

        
        for(int index = 0; index < historico.getDisciplinaCursada().size(); index++) {
            
            
            DisciplinaCursada aux = historico.getDisciplinaCursada().get(index);
            
            if(semestreAtual != aux.getSemestre() && aux.getSemestre() != 0) {
                //Se o semestreAtual é diferente do semestre da matéria e ela não
                //é optativa
            		string.append("</table>");
                    string.append("<h2>Semestre " + aux.getSemestre() + "</h2><br>");
                    string.append("<table>");
                    semestreAtual = aux.getSemestre();
            }
            
            else if(semestreAtual != aux.getSemestre() && aux.getSemestre() == 0){
                    string.append("<br><br>");
                    string.append("</table><table>");
                    string.append("<h1>Optativas</h1><br>");
                    semestreAtual = aux.getSemestre();
            }
            
            string.append("<tr>");
            string.append("<td>" + aux.getCodigo() + "</td>");
            
            string.append("<td>" + aux.getNome() + "</td>");
            string.append("<td>" + aux.getCh() + "</td>");
            
            if(aux.isObrigatoria())
              string.append("<td>OB</td>");
            else
              string.append("<td>OP</td>");
            
            if(aux.getNota() == -1)
                string.append("<td>----</td>");
            else
                string.append("<td>" + String.format("%.2f", aux.getNota()) + "</td>");              
            
            string.append("<td>" + aux.getConceito() + "</td>");
            
            string.append("</tr>");                    
            
        }

        string.append("</table></body></html>");

        return string.toString();
    }

	@Override
	public String escreveCurriculo(Curso curso) {

        StringBuilder string = new StringBuilder();
        string.append("<html><head><meta charset = \"utf-8\"><title>Currículo "+ curso.getNome() +"</title><style>td{padding: 5px;}</style></head><body>");
        string.append("<p>Curso: " + curso.getNome() + "</p>");
        string.append("<p>Código: " + curso.getCodigo() + "</p>");         
        string.append("<p>CH: " + curso.getCh() + "</p>");
        string.append("<p>Número de semestres: " + curso.getNumeroSemestres() + "</p>");
        
        for(int i=0; i<3; i++)
            string.append("<br>");

        string.append("<h1>IMPRESSÃO DE CURRÍCULO</h1>");
        
        
        //código, nome, carga horária, natureza, nota e conceito 
        
        int semestreAtual = 1;

            string.append("<br><br>");
            string.append("<h2>Semestre 1</h2><br>");
            string.append("<table>");        
            
        	Iterator<DisciplinaSelecionada> disciplinas = curso.getDisciplinaSelecionada().iterator();
        	
        	while(disciplinas.hasNext()) {
        	DisciplinaSelecionada aux = disciplinas.next();
        	            
            if(semestreAtual != aux.getSemestre() && aux.getSemestre() != 0) {
                //Se o semestreAtual é diferente do semestre da matéria e ela não
                //é optativa
            		string.append("</table>");
                    string.append("<h2>Semestre " + aux.getSemestre() + "</h2><br>");
                    string.append("<table>");
                    semestreAtual = aux.getSemestre();
            }
            
            else if(semestreAtual != aux.getSemestre() && aux.getSemestre() == 0){
                    string.append("<br><br>");
                    string.append("</table><table>");
                    string.append("<h1>Optativas</h1><br>");
                    semestreAtual = aux.getSemestre();
            }
            
            string.append("<tr>");
            string.append("<td>" + aux.getCodigo() + "</td>");
            
            string.append("<td>" + aux.getNome() + "</td>");
            string.append("<td>" + aux.getCh() + "</td>");
            
            if(aux.isObrigatoria())
              string.append("<td>OB</td>");
            else
              string.append("<td>OP</td>");
            
            string.append("</tr>");                    
            
        }

        string.append("</table></body></html>");

        return string.toString();
	}


}
