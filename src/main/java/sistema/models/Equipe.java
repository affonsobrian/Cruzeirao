package sistema.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codEquipe;
	@Column(nullable = false, unique = true)
	private String nome;
	private Date dataFundacao;
	private String cidade;
	private List<Usuario> usuarios;

	public Equipe() {
		super();
	}

	public Equipe(String nome, Date dataFundacao, String cidade, List<Usuario> usuarios) {
		super();
		this.nome = nome;
		this.dataFundacao = dataFundacao;
		this.cidade = cidade;
		this.usuarios = usuarios;
	}
	
	public int getCodEquipe() {
		return codEquipe;
	}

	public void setCodEquipe(int codEquipe) {
		this.codEquipe = codEquipe;
	}


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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Equipe [nome=" + nome + ", dataFundacao=" + dataFundacao + ", cidade=" + cidade + ", usuarios="
				+ usuarios + "]";
	}

	
}
