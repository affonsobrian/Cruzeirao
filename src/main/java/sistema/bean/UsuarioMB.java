package sistema.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;

import java.io.IOException;
import java.util.List;

import sistema.models.Tipo;
import sistema.models.Usuario;
import sistema.service.UsuarioService;

@ManagedBean
@SessionScoped
public class UsuarioMB {

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	private List<Usuario> jogadores;
	private UsuarioService service = new UsuarioService();
	private UploadedFile file;

	public void onRowEdition(RowEditEvent event) {
		Usuario u = ((Usuario) event.getObject());
		service.alterar(u);
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return service.getUsuarios();
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void remove(Usuario usuario) {
		service.remove(usuario);
		usuarios.remove(usuario);
	}

	public void save() {
		System.out.println("Sending request...");
		this.usuario = service.salvar(this.usuario);
		System.out.println("Success!");

		if (this.usuario != null)
			this.usuarios.add(this.usuario);

		this.usuario = new Usuario();
		System.out.println(this.usuario);
	}

	public String onFlowProcess(FlowEvent event) {

		return event.getNewStep();
	}

	// public void upload() {
	// Byte [] foto = this.usuario.getFoto();
	// System.out.println(file.getContentType());
	// if(file.getContentType() == "jpg")
	// if(this.usuario.getFoto() != null) {
	// FacesMessage message = new FacesMessage("Succesful", file.getFileName() + "
	// is uploaded.");
	// FacesMessage message = new FacesMessage("Succesful", file.getContentType() +
	// " is uploaded.");
	// FacesContext.getCurrentInstance().addMessage(null, message);
	// }
	// }

	public void validate() throws IOException {

		Usuario u = this.service.validate(this.usuario);
		if (u != null) {
			this.usuario = u;
			service.redirect(this.usuario);
		}
	}
	
	public List<Usuario> getJogadores() {
		service.getUsuarios()
		.stream()
		.filter(usuario -> usuario.getTipo() == Tipo.Jogador)
		.forEach(usuario -> {
			this.jogadores = null;
			
			if (!usuario.equals(null))
				this.jogadores.add(usuario);
		});
		
		return this.jogadores;
	}

	public void setJogadores(List<Usuario> jogadores) {
		this.jogadores = jogadores;
	}
	
	public String logout() throws IOException {
		this.usuario = new Usuario();
		System.out.println(this.usuario);
		FacesContext.getCurrentInstance().getExternalContext().redirect("./index.xhtml");
		return "sohvai";
	}
	

}
