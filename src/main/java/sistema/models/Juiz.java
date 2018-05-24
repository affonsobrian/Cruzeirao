package sistema.models;

import javax.persistence.*;

//TODO: Criar Hash e Equals
//TODO: Criar toString()
@Entity
public class Juiz extends Usuario{
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "juizes")
	private Partida partida;
	
	private String cref;
	public Juiz() {
		super();
	}
	public String getCref() {
		return cref;
	}
	public void setCref(String cref) {
		this.cref = cref;
	}
	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	@Override
	public String toString() {
		return "Juiz [partida=" + partida + ", cref=" + cref + "]";
	}
	
}
