package sistema.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
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
	
	public boolean validate() throws Exception {
		
		usuarios = this.service.getUsuarios();
		if(usuario.getEmail().isEmpty() || usuario.getSenha().isEmpty()) {
			if(FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage() == "pt")
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", "Usuário ou senha vazio!"));
			else
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", "User or password is empty!"));
			return false;
		}
		for (Usuario u : usuarios) {
			if(u.getSenha().equals(usuario.getSenha()))
			{			
				FacesContext.getCurrentInstance().getExternalContext().redirect("indexLogged.xhtml");
				System.out.println("Logged in");
				usuario = u;
				return true;
			}
		}
		if(FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage() == "pt")
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuário ou senha incorreto!"));
		else
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Warn", "User or password is incorrect!"));

		System.out.println("Failed Logging in");
		return false;
	}

}
