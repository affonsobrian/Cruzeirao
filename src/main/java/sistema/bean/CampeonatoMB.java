package sistema.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

import sistema.models.Campeonato;
import sistema.models.Local;
import sistema.service.CampeonatoService;

@ManagedBean
@ViewScoped
public class CampeonatoMB {
	
	private Campeonato campeonato = new Campeonato();
	private Local local = new Local();
	private CampeonatoService service;

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
	
	public void salvarLocal() {
		if(!local.equals(null)) {
			//campeonato.addLocal(local);
			local = new Local();
		}
	}
	
	// Wizard manipulation
	public String onFlowProcess(FlowEvent event) {
		return event.getNewStep();
	}
	
	public void onRowEdition(RowEditEvent event)
	{
		Campeonato c = ((Campeonato)event.getObject());
		service.alterar(c);
	}

}
