package sistema.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;
import java.util.List;
import sistema.models.Usuario;
import sistema.service.UsuarioService;

@ManagedBean
@ViewScoped
public class UsuarioManagedBean {
	
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	private UsuarioService service;
	
	public void onRowEdition(RowEditEvent event)
	{
		Usuario u = ((Usuario)event.getObject());
		service.alterar(u);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void remove(Usuario usuario)
	{
		service.remove(usuario);
		usuarios.remove(usuario);
	}

}
