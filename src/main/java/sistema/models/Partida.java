package sistema.models;

import java.util.Date;
import java.util.List;

public class Partida {
	int numero;
	Inscricao equipeMandante;
	Inscricao equipeVisitante;
	Date data;
	Local local;
	Partida proxPartida;
	List<Juiz> juizes;
	Grupo grupo;
	String relatoJuiz;

	public Partida() {
		super();
	}

	public Partida(int numero, Inscricao equipeMandante, Inscricao equipeVisitante, Date data, Local local,
			Partida proxPartida, List<Juiz> juizes, Grupo grupo, String relatoJuiz) {
		super();
		this.numero = numero;
		this.equipeMandante = equipeMandante;
		this.equipeVisitante = equipeVisitante;
		this.data = data;
		this.local = local;
		this.proxPartida = proxPartida;
		this.juizes = juizes;
		this.grupo = grupo;
		this.relatoJuiz = relatoJuiz;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Inscricao getEquipeMandante() {
		return equipeMandante;
	}

	public void setEquipeMandante(Inscricao equipeMandante) {
		this.equipeMandante = equipeMandante;
	}

	public Inscricao getEquipeVisitante() {
		return equipeVisitante;
	}

	public void setEquipeVisitante(Inscricao equipeVisitante) {
		this.equipeVisitante = equipeVisitante;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Partida getProxPartida() {
		return proxPartida;
	}

	public void setProxPartida(Partida proxPartida) {
		this.proxPartida = proxPartida;
	}

	public List<Juiz> getJuizes() {
		return juizes;
	}

	public void setJuizes(List<Juiz> juizes) {
		this.juizes = juizes;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getRelatoJuiz() {
		return relatoJuiz;
	}

	public void setRelatoJuiz(String relatoJuiz) {
		this.relatoJuiz = relatoJuiz;
	}

	@Override
	public String toString() {
		return "Partida [numero=" + numero + ", equipeMandante=" + equipeMandante + ", equipeVisitante="
				+ equipeVisitante + ", data=" + data + ", local=" + local + ", proxPartida=" + proxPartida + ", juizes="
				+ juizes + ", grupo=" + grupo + ", relatoJuiz=" + relatoJuiz + "]";
	}
	
	
}
