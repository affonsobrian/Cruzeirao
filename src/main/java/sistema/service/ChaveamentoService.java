package sistema.service;

import java.util.List;

import sistema.dao.CampeonatoDAO;
import sistema.models.Campeonato;

public class ChaveamentoService {
	
	private CampeonatoDAO dao = new CampeonatoDAO();
	
	public List<Campeonato> campeonatos() {
		return dao.getAll(Campeonato.class);
	}
}
