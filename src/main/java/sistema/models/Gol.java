package sistema.models;

import javax.persistence.*;

@Entity
public class Gol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codGol;
	//@Column(nullable = false)
	
	//TODO Checar se está correto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CodInscrito")
	private Inscrito inscrito;
	
	//TODO Checar se está correto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CodPartidaFutebol")
	private PartidaFutebol partidaFutebol;
	
	@Column(nullable = false)
	private int tempo;
	private boolean penalty;

	public Gol() {
		super();
	}

	public Gol(Inscrito inscrito, int tempo, boolean penalty) {
		super();
		this.inscrito = inscrito;
		this.tempo = tempo;
		this.penalty = penalty;
	}

	public Inscrito getInscrito() {
		return inscrito;
	}

	public void setInscrito(Inscrito inscrito) {
		this.inscrito = inscrito;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public boolean isPenalty() {
		return penalty;
	}

	public void setPenalty(boolean penalty) {
		this.penalty = penalty;
	}

	public int getCodGol() {
		return codGol;
	}

	public void setCodGol(int codGol) {
		this.codGol = codGol;
	}

	public PartidaFutebol getPartidaFutebol() {
		return partidaFutebol;
	}

	public void setPartidaFutebol(PartidaFutebol partidaFutebol) {
		this.partidaFutebol = partidaFutebol;
	}

	@Override
	public String toString() {
		return "Gol [codGol=" + codGol + ", inscrito=" + inscrito + ", partidaFutebol=" + partidaFutebol + ", tempo="
				+ tempo + ", penalty=" + penalty + "]";
	}
		
}