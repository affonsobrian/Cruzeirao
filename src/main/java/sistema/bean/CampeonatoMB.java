package sistema.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

import sistema.models.Campeonato;
import sistema.models.Local;
import sistema.service.CampeonatoService;
import sistema.service.LocalService;

@ManagedBean
@ViewScoped
public class CampeonatoMB {

	private Campeonato campeonato = new Campeonato();
	private Local local = new Local();
	private CampeonatoService campeonatoService;
	private LocalService localService;

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	// Service communication
	public void salvarLocal() {
		if (this.getLocal().equals(null))
			System.out.println("O local é um objeto inválido.");
		else {
			campeonato.getLocais().add(this.getLocal());
			FacesMessage msg = new FacesMessage("Local " + this.getLocal().getEndereco() + " cadastrado com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			local = new Local();
		}
	}

	public void remover(Local local) {
		if (this.getLocal().equals(null))
			System.out.println("O local é um objeto inválido.");
		else {
			campeonato.getLocais().remove(this.getLocal());
		}
	}

	// Wizard manipulation
	public String onFlowProcess(FlowEvent event) {
		return event.getNewStep();
	}

	public void onRowEdition(RowEditEvent event) {
		Campeonato c = ((Campeonato) event.getObject());
		campeonatoService.alterar(c);
	}

}
