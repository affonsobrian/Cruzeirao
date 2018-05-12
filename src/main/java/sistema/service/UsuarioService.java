package sistema.service;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;

import sistema.dao.UsuarioDAO;
import sistema.models.Usuario;

public class UsuarioService {

	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public Usuario salvar(Usuario usuario) {
		System.out.println("Saving user...");
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
				
		for (Usuario u : this.getUsuarios()) {
			if(u.getSenha().equals(usuario.getSenha()))
			{			
				System.out.println("Logged in");
				return u;
			}
		}
		System.out.println("Failed Logging in");
		return usuario;
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

}
