package sistema.service;

import java.io.IOException;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import sistema.dao.UsuarioDAO;
import sistema.models.Tipo;
import sistema.models.Usuario;

public class UsuarioService {

	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public Usuario salvar(Usuario usuario) {
		System.out.println("Saving user...");
		if(usuario.getTipo() == Tipo.Admin || usuario.getTipo() == Tipo.Organizador)
			usuario.setAceite(false);
		usuario = usuarioDAO.save(usuario);
		usuarioDAO.closeEntityManager();
		System.out.println("User saved successfully");
		return usuario;
	}

	public List<Usuario> getUsuarios() {
		List<Usuario> list = usuarioDAO.getAll(Usuario.class);
		usuarioDAO.closeEntityManager();
		return list;
	}

	public void alterar(Usuario usuario) {
		usuarioDAO.save(usuario);
		usuarioDAO.closeEntityManager();
	}

	public void remove(Usuario usuario) {
		usuario = usuarioDAO.getById(Usuario.class, usuario.getCodUsuario());
		usuarioDAO.remove(usuario);
		usuarioDAO.closeEntityManager();
	}
	
	public Usuario validate(Usuario usuario) throws IOException {
		boolean validated = false;				
		for (Usuario u : this.getUsuarios()) {
			if(u.getEmail().equals(usuario.getEmail()) && u.getSenha().equals(usuario.getSenha()))
			{
				validated = true;
				if(u.isAceite()) {
					System.out.println("Logging in");
					return u;
				}
				else
				{
					if (FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage() == "pt")
						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuário precisa ser validado!"));
					else
						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR, "Warn", "User needs validation!"));
				}
			}
		}
		System.out.println("Failed Logging in");
		if(!validated) {
			if (FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage() == "pt")
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuário ou senha incorreto!"));
			else
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Warn", "User or password is incorrect!"));
		}
		return null;
	}
	
	public void redirect(Usuario usuario) throws IOException {
		switch(usuario.getTipo()) {
			case Admin:
				System.out.println("Redirecting to Admin");
				FacesContext.getCurrentInstance().getExternalContext().redirect("./users/admin/indexAdmin.xhtml");
				break;
			case Diretor:
				System.out.println("Redirecting to Manager");
				FacesContext.getCurrentInstance().getExternalContext().redirect("./users/diretor/indexDiretor.xhtml");
				break;
			case Jogador:
				System.out.println("Redirecting to Player");
				FacesContext.getCurrentInstance().getExternalContext().redirect("./users/jogador/indexJogador.xhtml");
				break;
			case Juiz:
				System.out.println("Redirecting to Judge");
				FacesContext.getCurrentInstance().getExternalContext().redirect("./users/juiz/indexJuiz.xhtml");
				break;
			case Massagista:
				System.out.println("Redirecting to Masseur");
				FacesContext.getCurrentInstance().getExternalContext().redirect("./users/massagista/indexMassagista.xhtml");
				break;
			case Organizador:
				System.out.println("Redirecting to Organizer");
				FacesContext.getCurrentInstance().getExternalContext().redirect("./users/organizador/indexOrganizador.xhtml");
				break;
			case Tecnico:
				System.out.println("Redirecting to Coach");
				FacesContext.getCurrentInstance().getExternalContext().redirect("./users/tecnico/indexTecnico.xhtml");
				break;
			default:
				System.out.println("Redirecting to Fan");
				FacesContext.getCurrentInstance().getExternalContext().redirect("./users/torcedor/indexTorcedor.xhtml");
				break;
		}
	}

	public List<Usuario> getAceiteList() {
		
		List<Usuario> aceites = new ArrayList<Usuario>();
		for(Usuario u : this.usuarioDAO.getAll(Usuario.class)) {
			if(!u.isAceite())
				aceites.add(u);
		}
		return aceites;
		
	}
	
	public void aceitarUsuario(Usuario u) {
		try {
			for(Usuario x : this.getAceiteList()) {
				if(x.getCodUsuario() == u.getCodUsuario()) {
					System.out.println("Aeeeeee");
					System.out.println(u.isAceite());
					u.setAceite(true);
					System.out.println(u.isAceite());
					break;
				}
			}
			System.out.println(u.isAceite());
			this.alterar(u);
		}catch (Exception e) {
			if(FacesContext.getCurrentInstance().getViewRoot().getLocale() == Locale.ENGLISH)
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error on validation!"));
			else
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro ao fazer aceite!"));
		}
	}
	
	public void recusarUsuario(Usuario u) {
		try {
			this.remove(u);
		}catch (Exception e) {
			if(FacesContext.getCurrentInstance().getViewRoot().getLocale() == Locale.ENGLISH)
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error on validation!"));
			else
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro ao fazer aceite!"));
		}
	}
}
