package sistema.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sistema.models.Local;

@ManagedBean
@ViewScoped
public class LocalMB {
	private Local local = new Local();
	private List<Local> locais;
	
	//Getters and Setters
	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public List<Local> getLocais() {
		return locais;
	}

	public void setLocais(List<Local> locais) {
		this.locais = locais;
	}

	//Service
	public void salvar() {

			locais.add(this.getLocal());	
			FacesMessage msg = new FacesMessage("Local cadastrado com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			
			local = new Local();

	}
}
