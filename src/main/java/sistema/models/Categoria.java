package sistema.models;

import java.util.List;

//TODO: Criar Hash e Equals

public class Categoria {
	private String nome;
	private int nascidosApartirDe;
	private List<Inscricao> incricoes;
	private Campeonato campeonato;
	private List<Fase> fases;
	private int minJogadores;
	private int maxJogadores;
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
		return "Categoria [nome=" + nome + ", nascidosApartirDe=" + nascidosApartirDe + ", minJogadores=" + minJogadores
				+ ", maxJogadores=" + maxJogadores + ", sexo=" + sexo + "]";
	}
	
}
