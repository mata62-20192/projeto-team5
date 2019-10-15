package br.ufba.mata62.SistemaAcademico;

public class DisciplinaCursada{

  DisciplinaSelecionada disciplinaSelecionada;	
  private boolean concluida;
  private Float nota;

  public DisciplinaCursada(DisciplinaSelecionada disciplinaSelecionada){
	  this.disciplinaSelecionada = disciplinaSelecionada;
	  this.concluida = false;
	  this.nota = (float) -1;
  }

  // GETTERS E SETTERS
  public void setConcluida(boolean concluida){
    this.concluida = concluida;
  }

  public void setNota(Float nota){
	    this.nota = nota;
	  }
  
  public DisciplinaSelecionada getDisciplinaSelecionada() {
	return disciplinaSelecionada;
}

  public boolean getConcluida(){
    return concluida;
  }

  public Float getNota(){
    return nota;
  }

}