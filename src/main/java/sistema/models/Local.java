package sistema.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Local {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codLocal;
	@Column(nullable = false)
	String endereco;
	//TODO Checar se está coreto
	@ManyToMany(mappedBy = "locais")
	private List<Campeonato> campeonatos;

	public Local() {
		super();
	}

	public Local(String endereco) {
		super();
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCodLocal() {
		return codLocal;
	}

	public void setCodLocal(int codLocal) {
		this.codLocal = codLocal;
	}

	public List<Campeonato> getCampeonatos() {
		return campeonatos;
	}

	public void setCampeonatos(List<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
	}

	@Override
	public String toString() {
		return "Local [codLocal=" + codLocal + ", endereco=" + endereco + ", campeonatos=" + campeonatos + "]";
	}

}
