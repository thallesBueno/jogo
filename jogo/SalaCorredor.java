import javafx.scene.image.Image;

public class SalaCorredor extends Sala{

  public SalaCorredor(){
    super("Corredor", "imagens/corredor");
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
