package sistema.service;

import sistema.dao.CurrentUserDAO;
import sistema.models.CurrentUser;
import sistema.models.Usuario;

public class CurrentUserService {
	
	CurrentUserDAO currentDAO = new CurrentUserDAO();
	
	public Usuario getCurrentUser() {
		CurrentUser user;
		if((user = currentDAO.getById(CurrentUser.class, 1)) == null)
			user = new CurrentUser(new Usuario());
		return user.getUsuario();
	}
	
	public void setCurrentUser(CurrentUser current) {
		currentDAO.save(current);
	}

}
