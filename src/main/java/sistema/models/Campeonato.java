package sistema.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Campeonato {
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codCampeonato;
	private String nome;
	
	//TODO Checar se está correto
	@ManyToMany
    @JoinTable(name="Campeonato_Local",
    joinColumns = {@JoinColumn(name="CodCampeonato")},
    inverseJoinColumns = {@JoinColumn(name="CodLocal")})
	private List<Local> locais;
	
	//TODO Checar se está correto
	@ManyToMany
    @JoinTable(name="Campeonato_Juiz",
    joinColumns = {@JoinColumn(name="CodCampeonato")},
    inverseJoinColumns = {@JoinColumn(name="CodJuiz")})
	private List<Juiz> juizes;
	
	//TODO Checar se está correto
	@OneToMany(mappedBy = "campeonato")
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

	public int getCodCampeonato() {
		return codCampeonato;
	}

	public void setCodCampeonato(int codCampeonato) {
		this.codCampeonato = codCampeonato;
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
		return "Campeonato [codCampeonato=" + codCampeonato + ", nome=" + nome + ", locais=" + locais + ", juizes="
				+ juizes + ", categorias=" + categorias + ", dataInicioInscricao=" + dataInicioInscricao
				+ ", dataFimInscricao=" + dataFimInscricao + ", valorTaxa=" + valorTaxa + "]";
	}
	//TODO: Criar HashCode e Comparable
		
}
