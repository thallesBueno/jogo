import javafx.scene.image.Image;

public class SalaCela extends Sala{

  public SalaCela(){
    super("Cela", "imagens/cela");
    }

  @Override
  public boolean usa(String ferramenta){
    return false;
  }

  @Override
  public String textoDescricao(){
    return super.getNome();
  }
}
