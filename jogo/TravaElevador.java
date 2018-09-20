public class TravaElevador extends ObjetoFX{

  public TravaElevador(){
    super("Trava elevador ","Trava do elevador quebrada","Trava elevador");
  }

  public boolean usar(Ferramenta f){
    if(f instanceof ChaveDeFenda){
      super.setAcaoOk(true);
      return true;
    }
    return false;
  }
}
