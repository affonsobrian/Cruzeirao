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
		usuario.setNome("Torcedor");
		usuario.setEmail("torcedor");
		usuario.setSenha("123");
		usuario.setTipo(Tipo.Torcedor);
		usuariodao.save(usuario);
		usuario.setNome("Diretor");
		usuario.setEmail("diretor");
		usuario.setSenha("123");
		usuario.setTipo(Tipo.Diretor);
		usuariodao.save(usuario);
		usuario.setNome("Jogador");
		usuario.setEmail("jogador");
		usuario.setSenha("123");
		usuario.setTipo(Tipo.Jogador);
		usuariodao.save(usuario);
		usuario.setNome("Juiz");
		usuario.setEmail("juiz");
		usuario.setSenha("123");
		usuario.setTipo(Tipo.Juiz);
		usuariodao.save(usuario);
		usuario.setNome("Massagista");
		usuario.setEmail("massagista");
		usuario.setSenha("123");
		usuario.setTipo(Tipo.Massagista);
		usuariodao.save(usuario);
		usuario.setNome("Organizador");
		usuario.setEmail("organizador");
		usuario.setSenha("123");
		usuario.setTipo(Tipo.Organizador);
		usuariodao.save(usuario);
		usuario.setNome("Tecnico");
		usuario.setEmail("tecnico");
		usuario.setSenha("123");
		usuario.setTipo(Tipo.Tecnico);
		usuariodao.save(usuario);
		usuariodao.closeEntityManager();
	}
}
