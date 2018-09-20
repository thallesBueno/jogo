import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.scene.image.Image;


public abstract class Sala {
	private String nome;
	private Mochila mochila;
	private Map<String,ObjetoFX> objetos;
	private Map<String,FerramentaFX> ferramentas;
	private Map<String,Sala> portas;
	private String repVisual;

	public Sala(String nome) {
		this.nome = nome;
		objetos = new HashMap<>();
		ferramentas = new HashMap();
		portas = new HashMap();
	}

	public Sala(String nome,String repVisual) {
		this(nome);
		this.repVisual = repVisual;
	}

	public String getNome() {
		return nome;
	}

	public String getRepVisual() {
		return repVisual;
	}

	public void setRepVisual(String s) {
		repVisual = s;
	}

	public Mochila getMochila() {
		return mochila;
	}

	public Map<String, ObjetoFX> getObjetos() {
		return objetos;
	}

	public Map<String, FerramentaFX> getFerramentas() {
		return ferramentas;
	}

	public Map<String,Sala> getPortas(){
		return portas;
	}

	public List<String> objetosDisponiveis(){
    	return objetos.values()
    			      .stream()
    			      .map(obj->obj.getDescricao())
    			      .collect(Collectors.toList());
	}

	public List<String> ferramentasDisponiveis(){
    	return ferramentas.keySet().stream().collect(Collectors.toList());
	}

	public List<String> portasDisponiveis(){
    	return portas.keySet().stream().collect(Collectors.toList());
	}

	public void entra(Mochila mochila) {
		this.mochila = mochila;
	}

	public boolean pega(String nomeFerramenta) {
		FerramentaFX f = this.getFerramentas().get(nomeFerramenta);
		if (f != null) {
			this.getFerramentas().remove(nomeFerramenta);
			mochila.guardar(f);
			return true;
		}else {
			return false;
		}
	}

	public Sala sai(String porta) {
		return portas.get(porta);
	}

	public abstract String textoDescricao();

	public abstract boolean usa(String ferramenta);
}
