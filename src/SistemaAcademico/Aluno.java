public class Aluno extends Pessoa{

  private int semestre;
  private boolean matriculado;
  private boolean graduado;
  private Float score;

  public Aluno(String nome, String matricula, String senha, String rg, String cpf, int semestre, boolean matriculado, boolean graduado, Float score){
    super(nome, matricula, senha, rg, cpf);
    this.semestre = semestre;
    this.matriculado = matriculado;
    this.graduado = graduado;
    this.score = score;
  }

  // GETTERS E SETTERS

  public void setSemestre(int semestre){
    this.semestre = semestre;
  }

  public void setMatriculado(boolean matriculado){
    this.matriculado = matriculado;
  }

  public void setGraduado(boolean graduado){
    this.graduado = graduado;
  }

  public void setScore(Float score){
    this.score = score;
  }

  public int getSemetre(){
    return semestre;
  }

  public boolean estaMatriculado(){
    return matriculado;
  }

  public boolean estaGraduado(){
    return graduado;
  }

  public Float getScore(){
    return score;
  }

}