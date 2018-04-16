package sistema.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.models.Campeonato;
import sistema.models.Categoria;
import sistema.service.CampeonatoService;

@ManagedBean
@ViewScoped
public class CampeonatoManagedBean {
	
	private Campeonato campeonato;
	private CampeonatoService service;

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	
	public void onRowEdition(RowEditEvent event)
	{
		Campeonato c = ((Campeonato)event.getObject());
		service.alterar(c);
	}

}
