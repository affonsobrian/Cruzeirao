package sistema.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sistema.dao.UsuarioDAO;
import sistema.models.Grupo;
import sistema.models.Tipo;
import sistema.models.Usuario;

public class TesteBanco {

	public static void main(String[] args) {

		EntityManagerFactory factory;
		EntityManager em;
		factory = Persistence.createEntityManagerFactory("Cruzeirao");
		em = factory.createEntityManager();
		//em.find(Grupo.class, 1);
		Usuario usuario = new Usuario();
		UsuarioDAO usuariodao = new UsuarioDAO();
		usuario.setNome("Leonardo Danone");
		usuario.setEmail("leo");
		usuario.setSenha("leo123");
		usuario.setTipo(Tipo.Admin);
		usuariodao.save(usuario);
		usuario.setNome("Gustavo Ajuda");
		usuario.setEmail("gu");
		usuario.setSenha("gu123");
		usuario.setTipo(Tipo.Admin);
		usuariodao.save(usuario);
		usuario.setNome("Affunção Brian");
		usuario.setEmail("affs");
		usuario.setSenha("affs123");
		usuario.setTipo(Tipo.Admin);
		usuariodao.save(usuario);
		usuariodao.closeEntityManager();
	}
}
