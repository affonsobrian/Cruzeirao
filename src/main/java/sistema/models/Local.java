package sistema.models;

import javax.persistence.*;

@Entity
public class Local {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codLocal;
	@Column(nullable = false)
	String endereco;

	public Local() {
		super();
	}

	//Getters and Setters
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

	@Override
	public String toString() {
		return "Local [endereco=" + endereco + "]";
	}

}
