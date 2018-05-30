package sistema.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sistema.models.Usuario;
import sistema.service.UsuarioService;

@ManagedBean
@ViewScoped
public class AceiteMB {
	
	private UsuarioService service = new UsuarioService();
	private Usuario currentaceite;
	
	public Usuario getCurrentaceite() {
		return currentaceite;
	}

	public void setCurrentaceite(Usuario currentaceite) {
		this.currentaceite = currentaceite;
	}

	public List<Usuario> aceiteList() {
		return this.service.getAceiteList();
	}
	
	public void atualizarAceite(Usuario u) {
		this.currentaceite = u;
	}
	
	public Usuario currentUser() {
		return this.currentaceite;
	}
	
	public void aceitarUsuario() {
		
	}
}
