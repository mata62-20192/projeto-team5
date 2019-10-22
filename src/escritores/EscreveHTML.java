package escritores;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import br.ufba.mata62.SistemaAcademico.Aluno;
import br.ufba.mata62.SistemaAcademico.Curso;
import br.ufba.mata62.SistemaAcademico.DisciplinaCursada;
import br.ufba.mata62.SistemaAcademico.DisciplinaSelecionada;
import br.ufba.mata62.SistemaAcademico.Historico;

public class EscreveHTML {
    
    public static void escreveListaAlunos(List<Aluno> alunos) {
        
        for(int index = 0; index < alunos.size(); index++) {
            //Escreve histÃ³rico de cada aluno
            escreveHistoricoHTML(alunos.get(index).getHistorico());
            //Escreve Curso
            //escreveCursoHTML(alunos.get(index).getCurso(), alunos.get(index).getNome());
        }
        
    }
    
    
    //Escreve o histÃ³rico do aluno
    public static void escreveHistoricoHTML(Historico historico) {
        
        BufferedWriter html = null;
        try {
            Aluno aluno = historico.getAluno();
            
            //Cria arquivo com o nome "Historico_nomeAluno"
            FileWriter writer = new FileWriter("Historico_" + aluno.getNome() + ".html");

            
            html = new BufferedWriter(writer);
            
            //Onde o html serÃ¡ escrito
            StringBuilder string = new StringBuilder();
            string.append("<!DOCTYPE html><html><head><title>Histórico "+ aluno.getNome() +"</title><style>td{padding: 5px;}</style></head><body>");
            string.append("<p>Aluno: " + aluno.getNome() + "</p>");
            string.append("<p>Matrí­cula: " + aluno.getMatricula() + "</p>");         
            string.append("<p>Curso: " + aluno.getCurso().getNome() + "</p>");
            string.append("<p>Score: " + aluno.getScore() + "</p>");
            string.append("<p>Carga horária cursada: " + historico.getchCursada() + " Horas</p>");
            
            for(int i=0; i<5; i++)
                string.append("<br>");
 
            string.append("<h1>IMPRESSÃO DE HISTÓRICO</h1>");
            
            
            //cÃ³digo, nome, carga horÃ¡ria, natureza, nota e conceito 
            
            //semestreAtual Ã© usado para escrever o semestre no Html
            int semestreAtual = 1;

                string.append("<br><br>");
                string.append("<h2>Semestre 1</h2><br>");
                string.append("<table>");

            
            for(int index = 0; index < historico.getDisciplinaCursada().size(); index++) {
                
                
                DisciplinaCursada aux = historico.getDisciplinaCursada().get(index);
                
                if(semestreAtual != aux.getSemestre() && aux.getSemestre() != 0) {
                    //Se o semestreAtual Ã© diferente do semestre da matÃ©ria e ela nÃ£o
                    //Ã© optativa
                		string.append("</table>");
                        string.append("<h2>Semestre " + aux.getSemestre() + "</h2><br>");
                        string.append("<table>");
                        semestreAtual = aux.getSemestre();
                }
                
                else if(semestreAtual != aux.getSemestre() && aux.getSemestre() == 0){
                        string.append("<br><br>");
                        string.append("</table><table>");
                        string.append("<h2>Optativas</h2><br>");
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

            html.write(string.toString());
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
        
        finally {
            try {
               html.close();
            }
               catch(Exception e){
            }
        }
    }

}