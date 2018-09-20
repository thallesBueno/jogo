import javafx.scene.image.Image;

public class SalaElevador extends Sala{

  public SalaElevador(){
    super("Elevador", "imagens/elevador");
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
