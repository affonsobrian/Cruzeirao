package sistema.service;

import java.util.List;

import sistema.dao.LocalDAO;
import sistema.models.Local;

public class LocalService {
	
	LocalDAO localDAO = new LocalDAO();
	
	public List<Local> getLocais(){
		List<Local> locais = localDAO.getAll(Local.class);
		localDAO.closeEntityManager();
		
		return locais;
	}
	
	public Local salvar(Local local) {
		System.out.println("Salvando local...");
		local = (Local) localDAO.save(local);
		localDAO.closeEntityManager();
		System.out.println("Local salvo com sucesso!");
		
		return local;
	}
	
	public void alterar(Local local) {
		local = (Local) localDAO.save(local);
		localDAO.closeEntityManager();
	}
	
	public void remover(Local local) {
		local = (Local) localDAO.getById(local.getClass(), local.getCodLocal());
		localDAO.remove(local);
		localDAO.closeEntityManager();
	}
	
}
