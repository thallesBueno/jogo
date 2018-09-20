import javafx.scene.image.Image;
import java.util.List;

public class Engine{

  private Sala salaAtual;
  Sala cela;
  Sala corredor;
  Sala lab;
  Sala computador ;
  Sala elevador;
  Sala trava;
  Sala fechadura;
  Sala tela;
  boolean vitoria;

  public Engine(){
    vitoria = false;
    criaLabirinto();
    salaAtual.entra(new Mochila());
    salaAtual.getMochila().guardar(new Arame());
  }

  public void criaLabirinto(){
    cela = new SalaCela();
    salaAtual = cela;
    corredor = new SalaCorredor();
    lab = new SalaLaboratorio();
    computador = new SalaComputador();
    elevador = new SalaElevador();
    trava = new SalaTravaElevador();
    fechadura = new SalaFechadura();
    tela = new SalaTelaComputador();

    salaAtual.getPortas().put(fechadura.getNome(), fechadura);

    Fechadura f = new Fechadura();
    fechadura.getObjetos().put(f.getNome(), f);

    fechadura.getPortas().put(salaAtual.getNome(), salaAtual);

    corredor.getPortas().put(salaAtual.getNome(), salaAtual);
    corredor.getPortas().put(lab.getNome(), lab);

    computador.getPortas().put(lab.getNome(),lab);
    computador.getPortas().put(tela.getNome(),tela);

    Computador pc = new Computador();
    tela.getObjetos().put(pc.getNome(),pc);
    tela.getPortas().put(computador.getNome(),computador);


    ChaveDeFenda chave = new ChaveDeFenda();

    lab.getPortas().put(corredor.getNome(),corredor);
    lab.getPortas().put(elevador.getNome(),elevador);
    lab.getPortas().put(computador.getNome(),computador);
    lab.getFerramentas().put(chave.getNome(), chave);

    elevador.getPortas().put(lab.getNome(),lab);
    elevador.getPortas().put(trava.getNome(),trava);

    TravaElevador t = new TravaElevador();
    trava.getObjetos().put(t.getNome(),t);
    trava.getPortas().put(elevador.getNome(),elevador);

  }

  public List<String> entrar(String s){
    Mochila m = salaAtual.getMochila();
    salaAtual = salaAtual.getPortas().get(s);
    salaAtual.entra(m);
    List<String> aux = salaAtual.ferramentasDisponiveis();
    for(String ferramenta : aux)
      salaAtual.pega(ferramenta);
    return aux;
  }

  public List<String> portasDisponiveis(){
    return salaAtual.portasDisponiveis();
  }

  public List<String> inventario(){
    return salaAtual.getMochila().inventario();
  }

  public List<String> objetosDisponiveis(){
    return salaAtual.objetosDisponiveis();
  }

  public List<String> ferramentasDisponiveis(){
    return salaAtual.ferramentasDisponiveis();
  }

  public String getRepVisual(){
    return salaAtual.getRepVisual();
  }

  public void usar(String ferramenta, String objeto){
    ObjetoFX o = null;
    for(String s : salaAtual.getObjetos().keySet())
        if(getObjeto(s).getDescricao().equals(objeto))
          o = getObjeto(s);

    if(o.usar(this.salaAtual.getMochila().usar(ferramenta))){
      if(salaAtual instanceof SalaFechadura)
          this.abrirCela();
      if(salaAtual instanceof SalaTravaElevador)
          this.abrirElevador();
      if(salaAtual instanceof SalaTelaComputador)
          this.bugarPc();
      }
  }
  private void bugarPc(){
    salaAtual.setRepVisual("imagens/tela2");
    this.ganhar();
  }

  public void ganhar(){
    vitoria = true;
  }

  public boolean getVitoria(){
      return vitoria;
  }
  
  private void abrirElevador(){
    salaAtual.setRepVisual("imagens/travaElevador2");

    Sala aux = new SalaElevador();
    Cartao c = new Cartao();
    aux.getFerramentas().put(c.getNome(),c);
    aux.setRepVisual("imagens/elevadorDentro");
    aux.getPortas().put("Elevador", elevador);

    elevador.setRepVisual("imagens/elevador2");
    elevador.getPortas().put("Elevador dentro",aux);
  }

  private void abrirCela(){
    salaAtual.setRepVisual("imagens/fechadura2");
    cela.getPortas().put(corredor.getNome(), corredor);
    cela.setRepVisual("imagens/cela2");
  }

  public FerramentaFX getFerramenta(String s){
    return salaAtual.getMochila().usar(s);
  }

  public ObjetoFX getObjeto(String s){
    return salaAtual.getObjetos().get(s);
  }
}
