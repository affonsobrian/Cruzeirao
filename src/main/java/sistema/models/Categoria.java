package sistema.models;

import java.util.List;

import javax.persistence.*;

//TODO: Criar Hash e Equals
@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codCategoria;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private int nascidosApartirDe;
	
	//TODO Cheacar se estpa correto
	@OneToMany(mappedBy = "categoria")
	private List<Inscricao> incricoes;
	
	//TODO Checar se está correto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CodCampeonato")
	private Campeonato campeonato;
	
	//TODO Checar se está correto
	@OneToMany(mappedBy = "categoria")
	private List<Fase> fases;
	
	@Column(nullable = false)
	private int minJogadores;
	@Column(nullable = false)
	private int maxJogadores;
	@Column(nullable = false)
	private Sexo sexo;
	
	public Categoria() {
		super();
	}
	
	public Categoria(String nome, int nascidosApartirDe, List<Inscricao> incricoes, Campeonato campeonato,
			List<Fase> fases, int minJogadores, int maxJogadores, Sexo sexo) {
		super();
		this.nome = nome;
		this.nascidosApartirDe = nascidosApartirDe;
		this.incricoes = incricoes;
		this.campeonato = campeonato;
		this.fases = fases;
		this.minJogadores = minJogadores;
		this.maxJogadores = maxJogadores;
		this.sexo = sexo;
	}
	
	public int getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNascidosApartirDe() {
		return nascidosApartirDe;
	}
	public void setNascidosApartirDe(int nascidosApartirDe) {
		this.nascidosApartirDe = nascidosApartirDe;
	}
	public List<Inscricao> getIncricoes() {
		return incricoes;
	}
	public void setIncricoes(List<Inscricao> incricoes) {
		this.incricoes = incricoes;
	}
	public Campeonato getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	public List<Fase> getFases() {
		return fases;
	}
	public void setFases(List<Fase> fases) {
		this.fases = fases;
	}
	public int getMinJogadores() {
		return minJogadores;
	}
	public void setMinJogadores(int minJogadores) {
		this.minJogadores = minJogadores;
	}
	public int getMaxJogadores() {
		return maxJogadores;
	}
	public void setMaxJogadores(int maxJogadores) {
		this.maxJogadores = maxJogadores;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Categoria [codCategoria=" + codCategoria + ", nome=" + nome + ", nascidosApartirDe=" + nascidosApartirDe
				+ ", incricoes=" + incricoes + ", campeonato=" + campeonato + ", fases=" + fases + ", minJogadores="
				+ minJogadores + ", maxJogadores=" + maxJogadores + ", sexo=" + sexo + "]";
	}

}
