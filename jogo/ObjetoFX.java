public abstract class ObjetoFX extends Objeto{
  String nome;

  public ObjetoFX(String descricaoAntesAcao, String descricaoDepoisAcao, String nome){
    super(descricaoAntesAcao, descricaoDepoisAcao);
    this.nome = nome;
  }

  public String getNome(){
    return nome;
  }
}
