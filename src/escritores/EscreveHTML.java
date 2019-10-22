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
            //Escreve histórico de cada aluno
            escreveHistoricoHTML(alunos.get(index).getHistorico());
            //Escreve Curso
            //escreveCursoHTML(alunos.get(index).getCurso(), alunos.get(index).getNome());
        }
        
    }
    
    
    //Escreve o histórico do aluno
    public static void escreveHistoricoHTML(Historico historico) {
        
        BufferedWriter html = null;
        try {
            Aluno aluno = historico.getAluno();
            
            //Cria arquivo com o nome "Historico_nomeAluno"
            FileWriter writer = new FileWriter("Historico_" + aluno.getNome() + ".html");

            
            html = new BufferedWriter(writer);
            
            //Onde o html será escrito
            StringBuilder string = new StringBuilder();
            string.append("<!DOCTYPE html><html><head><title>Histórico "+ aluno.getNome() +"</title></head><body>");
            string.append("<h3>Aluno: " + aluno.getNome() + "</h3>");
            string.append("<h3>Matrícula: " + aluno.getMatricula() + "</h3>");         
            string.append("<h3>Curso: " + aluno.getCurso().getNome() + "</h3>");
            string.append("<h3>Score: " + aluno.getScore() + "</h3>");
            string.append("<h3>Carga horária cursada: " + historico.getchCursada() + " Horas</h3>");
            
            for(int i=0; i<5; i++)
                string.append("<br>");
 
            string.append("<h1>IMPRESSÃO DE HISTÓRICO</h1>");
            
            
            //código, nome, carga horária, natureza, nota e conceito 
            
            //semestreAtual é usado para escrever o semestre no Html
            int semestreAtual = 1;

                string.append("<br><br>");
                string.append("<h2>Semestre 1</h2><br>");

            
            for(int index = 0; index < historico.getDisciplinaCursada().size(); index++) {
                
                
                DisciplinaCursada aux = historico.getDisciplinaCursada().get(index);
                
                if(semestreAtual != aux.getSemestre() && aux.getSemestre() != 0) {
                    //Se o semestreAtual é diferente do semestre da matéria e ela não
                    //é optativa
                        string.append("<h2>Semestre " + aux.getSemestre() + "</h2><br>");
                        semestreAtual = aux.getSemestre();
                }
                
                else if(semestreAtual != aux.getSemestre() && aux.getSemestre() == 0){
                        string.append("<br><br>");
                        string.append("<h2>Optativas</h2><br>");
                        semestreAtual = aux.getSemestre();
                }
                
                string.append("<table><tr>");
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