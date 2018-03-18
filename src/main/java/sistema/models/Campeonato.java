package sistema.models;

import java.util.Date;
import java.util.List;

public class Campeonato {
	//Atributos
	private String nome;
	private List<Local> locais;
	private List<Juiz> juizes;
	private List<Categoria> categorias;
	private Date dataInicioInscricao;
	private Date dataFimInscricao;
	private double valorTaxa;
	
	
	//Constutores
	public Campeonato() {

	}

	public Campeonato(String nome, List<Local> locais, List<Juiz> juizes, List<Categoria> categorias,
			Date dataInicioInscricao, Date dataFimInscricao, double valorTaxa) {
		super();
		this.nome = nome;
		this.locais = locais;
		this.juizes = juizes;
		this.categorias = categorias;
		this.dataInicioInscricao = dataInicioInscricao;
		this.dataFimInscricao = dataFimInscricao;
		this.valorTaxa = valorTaxa;
	}
	
	//Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Local> getLocais() {
		return locais;
	}

	public void setLocais(List<Local> locais) {
		this.locais = locais;
	}

	public List<Juiz> getJuizes() {
		return juizes;
	}

	public void setJuizes(List<Juiz> juizes) {
		this.juizes = juizes;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Date getDataInicioInscricao() {
		return dataInicioInscricao;
	}

	public void setDataInicioInscricao(Date dataInicioInscricao) {
		this.dataInicioInscricao = dataInicioInscricao;
	}

	public Date getDataFimInscricao() {
		return dataFimInscricao;
	}

	public void setDataFimInscricao(Date dataFimInscricao) {
		this.dataFimInscricao = dataFimInscricao;
	}

	public double getValorTaxa() {
		return valorTaxa;
	}

	public void setValorTaxa(double valorTaxa) {
		this.valorTaxa = valorTaxa;
	}

	@Override
	public String toString() {
		return "Campeonato [nome=" + nome + ", locais=" + locais + ", juizes=" + juizes + ", categorias=" + categorias
				+ ", dataInicioInscricao=" + dataInicioInscricao + ", dataFimInscricao=" + dataFimInscricao
				+ ", valorTaxa=" + valorTaxa + "]";
	}
	
	//TODO: Criar HashCode e Comparable
	
	
	
}
