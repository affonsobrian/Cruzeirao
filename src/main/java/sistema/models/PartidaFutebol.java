package sistema.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class PartidaFutebol {
	//TODO checar a logica
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codPartidaFutebol;
	@OneToMany(mappedBy = "partidaFutebol")
	private List<Gol> golsMandantes;
	@OneToMany(mappedBy = "partidaFutebol")
	private List<Gol> golsVisitantes;
	@OneToMany(mappedBy = "partidaFutebol")
	private List<Gol> golsPenaltesMandantes;
	@OneToMany(mappedBy = "partidaFutebol")
	private List<Gol> golsPenaltesVisitantes;
	@OneToMany(mappedBy = "partidaFutebol")
	private List<Cartao> cartoesMandante;
	@OneToMany(mappedBy = "partidaFutebol")
	private List<Cartao> cartoesVisitante;

	public PartidaFutebol() {
		super();
	}
	
	public PartidaFutebol(int codPartidaFutebol, List<Gol> golsMandantes, List<Gol> golsVisitantes,
			List<Gol> golsPenaltesMandantes, List<Gol> golsPenaltesVisitantes, List<Cartao> cartoesMandante,
			List<Cartao> cartoesVisitante) {
		super();
		this.codPartidaFutebol = codPartidaFutebol;
		this.golsMandantes = golsMandantes;
		this.golsVisitantes = golsVisitantes;
		this.golsPenaltesMandantes = golsPenaltesMandantes;
		this.golsPenaltesVisitantes = golsPenaltesVisitantes;
		this.cartoesMandante = cartoesMandante;
		this.cartoesVisitante = cartoesVisitante;
	}

	public int getCodPartidaFutebol() {
		return codPartidaFutebol;
	}

	public void setCodPartidaFutebol(int codPartidaFutebol) {
		this.codPartidaFutebol = codPartidaFutebol;
	}

	public List<Gol> getGolsMandantes() {
		return golsMandantes;
	}

	public void setGolsMandantes(List<Gol> golsMandantes) {
		this.golsMandantes = golsMandantes;
	}

	public List<Gol> getGolsVisitantes() {
		return golsVisitantes;
	}

	public void setGolsVisitantes(List<Gol> golsVisitantes) {
		this.golsVisitantes = golsVisitantes;
	}

	public List<Gol> getGolsPenaltesMandantes() {
		return golsPenaltesMandantes;
	}

	public void setGolsPenaltesMandantes(List<Gol> golsPenaltesMandantes) {
		this.golsPenaltesMandantes = golsPenaltesMandantes;
	}

	public List<Gol> getGolsPenaltesVisitantes() {
		return golsPenaltesVisitantes;
	}

	public void setGolsPenaltesVisitantes(List<Gol> golsPenaltesVisitantes) {
		this.golsPenaltesVisitantes = golsPenaltesVisitantes;
	}

	public List<Cartao> getCartoesMandante() {
		return cartoesMandante;
	}

	public void setCartoesMandante(List<Cartao> cartoesMandante) {
		this.cartoesMandante = cartoesMandante;
	}

	public List<Cartao> getCartoesVisitante() {
		return cartoesVisitante;
	}

	public void setCartoesVisitante(List<Cartao> cartoesVisitante) {
		this.cartoesVisitante = cartoesVisitante;
	}

	@Override
	public String toString() {
		return "PartidaFutebol [codPartidaFutebol=" + codPartidaFutebol + ", golsMandantes=" + golsMandantes
				+ ", golsVisitantes=" + golsVisitantes + ", golsPenaltesMandantes=" + golsPenaltesMandantes
				+ ", golsPenaltesVisitantes=" + golsPenaltesVisitantes + ", cartoesMandante=" + cartoesMandante
				+ ", cartoesVisitante=" + cartoesVisitante + "]";
	}

}