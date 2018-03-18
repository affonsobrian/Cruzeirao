package sistema.models;


//TODO: Criar Hash e Equals
//TODO: Criar toString


public class Cartao {
	private Inscrito inscrito;
	private Tipo tipo;
	private int tempo;
	
	
	public Cartao() {
		super();
	}
	public Cartao(Inscrito inscrito, Tipo tipo, int tempo) {
		super();
		this.inscrito = inscrito;
		this.tipo = tipo;
		this.tempo = tempo;
	}
	public Inscrito getInscrito() {
		return inscrito;
	}
	public void setInscrito(Inscrito inscrito) {
		this.inscrito = inscrito;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	
}
