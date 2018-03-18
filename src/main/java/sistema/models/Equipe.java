package sistema.models;

import java.util.Date;
import java.util.List;

public class Equipe {
	//Atributos
	private String nome;
	private Date dataFundacao;
	private String cidade;
	private List<Usuario> diretores;
	
	//Construtores
	public Equipe() {
		
	}

	public Equipe(String nome, Date dataFundacao, String cidade, List<Usuario> diretores) {
		super();
		this.nome = nome;
		this.dataFundacao = dataFundacao;
		this.cidade = cidade;
		this.diretores = diretores;
	}
	
	
	//Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<Usuario> getDiretores() {
		return diretores;
	}

	public void setDiretores(List<Usuario> diretores) {
		this.diretores = diretores;
	}

	//TODO: Implementar Hash e Comparable
	
	@Override
	public String toString() {
		return "Equipe [nome=" + nome + ", dataFundacao=" + dataFundacao + ", cidade=" + cidade + ", diretores="
				+ diretores + "]";
	}
}
