package sistema.service;

import java.util.List;

import sistema.dao.CampeonatoDAO;
import sistema.models.Campeonato;

public class CampeonatoService {
	
	CampeonatoDAO campeonatoDAO = new CampeonatoDAO();
	
	public Campeonato salvar(Campeonato campeonato)
	{
		campeonato = (Campeonato) campeonatoDAO.save(campeonato);
		campeonatoDAO.closeEntityManager();
		return campeonato;
	}
	
	public List<Campeonato> getCampeonatos()
	{
		List<Campeonato> list = campeonatoDAO.getAll(Campeonato.class);
		campeonatoDAO.closeEntityManager();
		return list;
	}
	
	public void alterar(Campeonato campeonato) {
		campeonatoDAO.save(campeonato);
		campeonatoDAO.closeEntityManager();
	}
	
	public void remove(Campeonato campeonato) {
		campeonato = (Campeonato) campeonatoDAO.getById(Campeonato.class, campeonato.getCodCampeonato());
		campeonatoDAO.remove(campeonato);
		campeonatoDAO.closeEntityManager();
	}


}
