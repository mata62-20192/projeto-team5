package src.br.ufba.mata62.SistemaAcademico;

public class DisciplinaCursada extends DisciplinaSelecionada{

  private boolean concluida;
  private Float nota;

  public DisciplinaCursada(String nome, String codigo, int ch, ArrayList<Disciplina> preRequisito, boolean obrigatoria, int semestre, boolean concluida, Float nota){
    super(nome, codigo, ch, preRequisito, obrigatoria, semestre);
    this.concluida = concluida;
    this.nota = nota;
  }

  // GETTERS E SETTERS

  private void setConcluida(boolean concluida){
    this.concluida = concluida;
  }

  private void setNota(String nome, String codigo, int ch, Float nota){
    this.nota = nota;
  }

  private boolean estaConcluida(){
    return concluida;
  }

  private Float getNota(){
    return nota;
  }

}