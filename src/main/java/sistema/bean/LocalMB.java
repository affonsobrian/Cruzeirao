package sistema.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sistema.models.Local;
import sistema.service.LocalService;

@ManagedBean
@ViewScoped
public class LocalMB {
	private Local local = new Local();
	private List<Local> locais;
	private LocalService localService = new LocalService();

	// Getters and Setters
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

	// Service
	public void salvar() {
		if (this.getLocal().equals(null))
			System.out.println("O local é um objeto inválido.");
		else {
			locais.add(this.getLocal());
			localService.salvar(this.getLocal());
			FacesMessage msg = new FacesMessage("Local " + this.getLocal() + " cadastrado com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			local = new Local();
		}
	}

	public void remover(Local local) {
		if (this.getLocal().equals(null))
			System.out.println("O local é um objeto inválido.");
		else {
			locais.remove(local);
			localService.remover(local);
		}
	}
}
