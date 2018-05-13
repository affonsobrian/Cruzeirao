package sistema.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Inscrito {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Tipo tipo;
	
	//TODO Checar se está correto
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CodUsuario")
	private Usuario usuario;
	
	//TODO Checar se está correto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CodInscricao")
	private Inscricao inscricao;
	
	private	boolean aceiteUsuario;
	private	boolean suspensoJogos;
	private boolean inscricaoValida;
	
	//TODO Checar se está correto
	@OneToMany(mappedBy = "inscrito")
	private List<Gol> gols;
	
	//Construtores
	public Inscrito() {

	}
	
	public Inscrito(Tipo tipo, Usuario usuario, Inscricao inscricao, boolean aceiteUsuario, boolean suspensoJogos,
			boolean inscricaoValida) {
		super();
		this.tipo = tipo;
		this.usuario = usuario;
		this.inscricao = inscricao;
		this.aceiteUsuario = aceiteUsuario;
		this.suspensoJogos = suspensoJogos;
		this.inscricaoValida = inscricaoValida;
	}
	
	//Getters and Setters
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public List<Gol> getGols() {
		return gols;
	}

	public void setGols(List<Gol> gols) {
		this.gols = gols;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Inscricao getInscricao() {
		return inscricao;
	}
	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}
	public boolean isAceiteUsuario() {
		return aceiteUsuario;
	}
	public void setAceiteUsuario(boolean aceiteUsuario) {
		this.aceiteUsuario = aceiteUsuario;
	}
	public boolean isSuspensoJogos() {
		return suspensoJogos;
	}
	public void setSuspensoJogos(boolean suspensoJogos) {
		this.suspensoJogos = suspensoJogos;
	}
	public boolean isInscricaoValida() {
		return inscricaoValida;
	}
	public void setInscricaoValida(boolean inscricaoValida) {
		this.inscricaoValida = inscricaoValida;
	}

	@Override
	public String toString() {
		return "Inscrito [tipo=" + tipo + ", usuario=" + usuario + ", inscricao=" + inscricao + ", aceiteUsuario="
				+ aceiteUsuario + ", suspensoJogos=" + suspensoJogos + ", inscricaoValida=" + inscricaoValida + "]";
	}
	
	//TODO: Criar HashCode e Comparable
	
	
}
