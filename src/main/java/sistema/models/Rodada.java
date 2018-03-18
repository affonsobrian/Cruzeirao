package sistema.models;

import java.util.List;

public class Rodada {
	int numero;
	Grupo grupo;
	List<Partida> partidas;

	public Rodada() {
		super();
	}

	public Rodada(int numero, Grupo grupo, List<Partida> partidas) {
		super();
		this.numero = numero;
		this.grupo = grupo;
		this.partidas = partidas;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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
		return "Rodada [numero=" + numero + ", grupo=" + grupo + ", partidas=" + partidas + "]";
	}
	
	
}
