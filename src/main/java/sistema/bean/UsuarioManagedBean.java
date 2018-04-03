package sistema.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.logging.ConsoleHandler;

import sistema.models.Usuario;
import sistema.service.UsuarioService;

@ManagedBean
@ViewScoped
public class UsuarioManagedBean {
	
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	private UsuarioService service = new UsuarioService();
	
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
	
	public void save() {
		System.out.println("Sending request...");
		usuario = service.salvar(usuario);
		System.out.println("Success!");

		if (usuario != null)
			usuarios.add(usuario);

		usuario = new Usuario();

	}
	
	public String onFlowProcess(FlowEvent event) {

		return event.getNewStep();
	}
	
	public boolean validate() {
		
		usuarios = this.service.getUsuarios();
		for (Usuario u : usuarios) {
			if(u.getSenha().equals(usuario.getSenha()))
			{			
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("indexLogged.xhtml");
					System.out.println("Logged in");
					usuario = u;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		}
		System.out.println("Failed Logging in");
		return false;
	}

}
