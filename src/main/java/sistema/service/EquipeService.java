package sistema.service;

import java.util.List;

import sistema.dao.EquipeDAO;
import sistema.models.Equipe;
import sistema.models.Usuario;

public class EquipeService {

	EquipeDAO equipeDAO = new EquipeDAO();

	public Equipe salvar(Equipe equipe) {
		System.out.println("Saving team...");
		equipe = equipeDAO.save(equipe);
		equipeDAO.closeEntityManager();
		System.out.println("Team saved successfully");

		return equipe;
	}

	public List<Equipe> getEquipes() {
		List<Equipe> equipes = equipeDAO.getAll(Equipe.class);
		equipeDAO.closeEntityManager();

		return equipes;
	}
	
	public void alterar(Equipe equipe) {
		equipeDAO.save(equipe);
		equipeDAO.closeEntityManager();
	}
	
	public void remover(Equipe equipe) {
		equipe = equipeDAO.getById(Equipe.class, equipe.getCodEquipe());
		equipeDAO.remove(equipe);
		equipeDAO.closeEntityManager();
	}
}
