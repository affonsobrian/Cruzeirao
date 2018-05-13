package sistema.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Partida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codPartida;

	//TODO Checar se está correto
	@ManyToMany(mappedBy = "partidas")
	private List<Inscricao> incricoes;
	
	private Date data;
	//TODO Checar se está correto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CodLocal")
	private Local local;
	
	//TODO Checar se está correto
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CodPartida")
	private Partida proxPartida;
	
	//TODO Checar se está correto
	@OneToMany(mappedBy = "partida")
	private List<Juiz> juizes;
	
	//TODO Checar se está correto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CodGrupo")
	private Grupo grupo;
	
	//TODO Checar se está correto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CodRodada")
	private Rodada rodada;
	
	private String relatoJuiz;

	public Partida() {
		super();
	}

	public Partida(int codPartida, Inscricao equipeMandante, Inscricao equipeVisitante, Date data, Local local,
			Partida proxPartida, List<Juiz> juizes, Grupo grupo, String relatoJuiz) {
		super();
		this.codPartida = codPartida;
		this.data = data;
		this.local = local;
		this.proxPartida = proxPartida;
		this.juizes = juizes;
		this.grupo = grupo;
		this.relatoJuiz = relatoJuiz;
	}
	
	
	public int getCodPartida() {
		return codPartida;
	}

	public void setCodPartida(int codPartida) {
		this.codPartida = codPartida;
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

	public List<Inscricao> getIncricoes() {
		return incricoes;
	}

	public void setIncricoes(List<Inscricao> incricoes) {
		this.incricoes = incricoes;
	}

	public Rodada getRodada() {
		return rodada;
	}

	public void setRodada(Rodada rodada) {
		this.rodada = rodada;
	}

	@Override
	public String toString() {
		return "Partida [codPartida=" + codPartida + ", incricoes=" + incricoes + ", data=" + data + ", local=" + local
				+ ", proxPartida=" + proxPartida + ", juizes=" + juizes + ", grupo=" + grupo + ", rodada=" + rodada
				+ ", relatoJuiz=" + relatoJuiz + "]";
	}

}