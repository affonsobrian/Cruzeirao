package sistema.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

import java.io.IOException;
import java.util.List;

import sistema.models.Tipo;
import sistema.models.Usuario;
import sistema.service.UsuarioService;

@ManagedBean
@ViewScoped
public class UsuarioMB {

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	private List<Usuario> jogadores;
	private UsuarioService usuarioService = new UsuarioService();

	public void onRowEdition(RowEditEvent event) {
		Usuario u = ((Usuario) event.getObject());
		usuarioService.alterar(u);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarioService.getUsuarios();
	}

	public void remove(Usuario usuario) {
		usuarioService.remove(usuario);
		usuarios.remove(usuario);
	}

	public void save() {
		System.out.println("Sending request...");
		usuario = usuarioService.salvar(usuario);
		System.out.println("Success!");

		if (usuario != null)
			usuarios.add(usuario);

		usuario = new Usuario();

	}

	public String onFlowProcess(FlowEvent event) {

		return event.getNewStep();
	}

	public boolean validate() throws IOException {

		usuarios = this.usuarioService.getUsuarios();

		for (Usuario u : usuarios) {
			if (u.getSenha().equals(usuario.getSenha())) {
				System.out.println("Logged in");
				usuario = u;
				this.redirect();
				return true;
			}
		}

		if (FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage() == "pt")
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuário ou senha incorreto!"));
		else
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Warn", "User or password is incorrect!"));

		System.out.println("Failed Logging in");
		return false;
	}

	private void redirect() throws IOException {

		switch (usuario.getTipo()) {

		case Admin:
			FacesContext.getCurrentInstance().getExternalContext().redirect("./users/admin/indexAdmin.xhtml");
			break;
		case Diretor:
			FacesContext.getCurrentInstance().getExternalContext().redirect("./users/diretor/indexDiretor.xhtml");
			break;
		case Jogador:
			FacesContext.getCurrentInstance().getExternalContext().redirect("./users/jogador/indexJogador.xhtml");
			break;
		case Juiz:
			FacesContext.getCurrentInstance().getExternalContext().redirect("./users/juiz/indexJuiz.xhtml");
			break;
		case Massagista:
			FacesContext.getCurrentInstance().getExternalContext().redirect("./users/massagista/indexMassagista.xhtml");
			break;
		case Organizador:
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("./users/organizador/indexOrganizador.xhtml");
			break;
		case Tecnico:
			FacesContext.getCurrentInstance().getExternalContext().redirect("./users/tecnico/indexTecnico.xhtml");
			break;
		default:
			FacesContext.getCurrentInstance().getExternalContext().redirect("./users/torcedor/indexTorcedor.xhtml");
			break;
		}
	}

	public List<Usuario> getJogadores() {
		usuarioService.getUsuarios()
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
}
