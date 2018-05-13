package sistema.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Rodada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codRodada;
	Grupo grupo;

	//TODO Checar se está correto
	@OneToMany(mappedBy = "rodada")
	List<Partida> partidas;

	public Rodada() {
		super();
	}
	
	public Rodada(Grupo grupo, List<Partida> partidas) {
		super();
		this.grupo = grupo;
		this.partidas = partidas;
	}


	public int getCodRodada() {
		return codRodada;
	}


	public void setCodRodada(int codRodada) {
		this.codRodada = codRodada;
	}


	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	@Override
	public String toString() {
		return "Rodada [codRodada=" + codRodada + ", grupo=" + grupo + ", partidas=" + partidas + "]";
	}
	
	
}
