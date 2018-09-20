public abstract class FerramentaFX extends Ferramenta{

  private String img;
  private String nome;

  public FerramentaFX(String nome, String descricao, String img){
    super(descricao);
    this.nome = nome;
    this.img = img;
  }

  public String getImg(){
    return img;
  }

  public String getNome(){
    return nome;
  }
}
