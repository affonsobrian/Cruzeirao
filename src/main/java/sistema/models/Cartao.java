package sistema.models;

import javax.persistence.*;

//TODO: Criar Hash e Equals
@Entity
public class Cartao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codCartao;
	//@Column(nullable = false)
	private Inscrito inscrito;
	@Column(nullable = false)
	private TipoCartao tipo;
	@Column(nullable = false)
	private int tempo;
	
	public Cartao() {
		super();
	}
	public Cartao(Inscrito inscrito, TipoCartao tipo, int tempo) {
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
	public TipoCartao getTipo() {
		return tipo;
	}
	public void setTipo(TipoCartao tipo) {
		this.tipo = tipo;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	@Override
	public String toString() {
		return "Cartao [inscrito=" + inscrito + ", tipo=" + tipo + ", tempo=" + tempo + "]";
	}
	
}
