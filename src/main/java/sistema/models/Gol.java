package sistema.models;

//TODO: Implementar ToString() para a classe de Gol.

public class Gol {
	Inscrito inscrito;
	int tempo;
	boolean penalty;

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
}
