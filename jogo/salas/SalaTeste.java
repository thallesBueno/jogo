import javafx.scene.image.Image;

public class SalaTeste extends Sala{

  public SalaTeste(){
    super("salaTeste","imagens/salaTeste");
    }

  @Override
  public boolean usa(String ferramenta){
    return true;
  }

  @Override
  public String textoDescricao(){
    return super.getNome();
  }
}
