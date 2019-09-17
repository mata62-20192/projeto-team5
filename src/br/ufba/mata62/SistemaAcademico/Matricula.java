import java.util.ArrayList;

public class MateriaCursada{

  private ArrayList<Turma> turmasEscolhidas;
  private ArrayList<Turma> turmasDisponiveis;



  // GETTERS E SETTERS

  public void setTurmasEscolhidas(ArrayList<Turma> turmas){
    this.turmasEscolhidas = turmas;
  }

  public void setTurmasDisponiveis(ArrayList<Turma> turmas){
    this.turmasDisponiveis = turmas;
  }

  public ArrayList<Turma> getTurmasEscolhidas(){
    return turmasEscolhidas;
  }

  public ArrayList<Turma> getTurmasDisponiveis(){
    return turmasDisponiveis;
  }

}