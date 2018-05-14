package sistema.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import sistema.dao.CurrentUserDAO;
import sistema.models.Usuario;

@Entity
public class CurrentUser{
	@Id
	private int codCurrentUser = 1;
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public CurrentUser() {
		super();
	}
	public CurrentUser(Usuario usuario) {
		super();
		this.usuario = usuario;
	}
	
	
	

}
