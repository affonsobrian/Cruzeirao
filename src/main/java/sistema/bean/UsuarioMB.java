package sistema.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;

import java.io.IOException;
import java.util.List;

import sistema.models.Usuario;
import sistema.service.UsuarioService;

@ManagedBean
@ViewScoped
public class UsuarioMB {
	
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	private UsuarioService service = new UsuarioService();
	private UploadedFile file;
	
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
	
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
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
	
//	public void upload() {
//		Byte [] foto = this.usuario.getFoto();
//		System.out.println(file.getContentType());
		//if(file.getContentType() == "jpg")
//        if(this.usuario.getFoto() != null) {
            //FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
//            FacesMessage message = new FacesMessage("Succesful", file.getContentType() + " is uploaded.");
//            FacesContext.getCurrentInstance().addMessage(null, message);
//        }
//    }
	
	public void validate() throws IOException {
		
		Usuario u = this.service.validate(this.usuario);
		if(u.equals(this.usuario))
		{
			if(FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage() == "pt")
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuário ou senha incorreto!"));
			else
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Warn", "User or password is incorrect!"));
		}
		else
		{
			this.usuario = u;
			service.redirect(this.usuario);
		}
		
	}
	
}
