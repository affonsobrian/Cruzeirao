package sistema.models;

import javax.persistence.*;

//TODO: Criar Hash e Equals
//TODO: Criar toString()
@Entity
public class Juiz extends Usuario{

	private String cref;
	public Juiz() {
		super();
	}
	public String getCref() {
		return cref;
	}
	public void setCref(String cref) {
		this.cref = cref;
	}
	
	
}
