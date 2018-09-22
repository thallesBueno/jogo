package jogo.objetos;

import jogo.ferramentas.*;

public class Fechadura extends ObjetoFX{

  public Fechadura(){
    super("Fechadura trancada ","Fechadura aberta","Fechadura");
  }

  public boolean usar(Ferramenta f){
    if(f instanceof Arame){
      super.setAcaoOk(true);
      return true;
    }
    return false;
  }
}
