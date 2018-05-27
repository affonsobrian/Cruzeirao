package sistema.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

import sistema.models.Campeonato;
import sistema.models.Categoria;
import sistema.models.Local;
import sistema.service.CampeonatoService;


@ManagedBean
@ViewScoped
public class CampeonatoMB {

	private Campeonato campeonato = new Campeonato();
	private Local local = new Local();
	private Categoria categoria = new Categoria();
	private CampeonatoService campeonatoService;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
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
		if (this.getLocal().getEndereco() == "") {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! O campo de local está inválido.", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		else {
			campeonato.getLocais().add(this.getLocal());
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso! O Local " + this.getLocal().getEndereco() + " foi cadastrado", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);			
			local = new Local();
		}
	}

	public void removerLocal(Local local) {
		if(local.getEndereco() != "") {
			campeonato.getLocais().remove(local);
		}
	}
	
	public void salvarCategoria() {					
			System.out.println("Salvar categoria");
			System.out.println(this.getCategoria().getNome());

			campeonato.getCategorias().add(this.getCategoria());
			//FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso! A Categoria " + this.getCategoria().getNome() + " foi cadastrada", null);
			//FacesContext.getCurrentInstance().addMessage(null, msg);
			categoria = new Categoria();
		
	}
	
	public void removerCategoria(Categoria categoria) {
		if(categoria.getNome() != "") {
			campeonato.getCategorias().remove(categoria);
		}
	}
	
	public void salvarCampeonato() {
		System.out.println(this.campeonato.getLocais());
		System.out.println(this.campeonato.getCategorias());
		
		//this.campeonatoService.salvar(this.getCampeonato());
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso! O campeonato foi criado", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		campeonato = new Campeonato();
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
