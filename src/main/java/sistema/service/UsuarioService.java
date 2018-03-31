package sistema.service;

import java.util.List;

import sistema.dao.UsuarioDAO;
import sistema.models.Usuario;

public class UsuarioService {

	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public Usuario salvar(Usuario usuario)
	{
		usuario = usuarioDAO.save(usuario);
		usuarioDAO.closeEntityManager();
		return usuario;
	}
	
	public List<Usuario> getUsuarios()
	{
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

}
