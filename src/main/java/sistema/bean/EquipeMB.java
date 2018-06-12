package sistema.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import sistema.models.Equipe;
import sistema.models.Tipo;
import sistema.models.Usuario;
import sistema.service.EquipeService;

@ManagedBean
@ViewScoped
public class EquipeMB {

	private Equipe equipe = new Equipe();
	private List<Equipe> equipes = new ArrayList<Equipe>();
	private List<Usuario> jogadoresSelecionados = new ArrayList<Usuario>();
	private EquipeService equipeService = new EquipeService();

	// Getters and Setters
	public Equipe getEquipe() {
		return equipe;
	}

	public Equipe getEquipeById(int timeId) {
		Equipe equipe = (Equipe) this.buscaEquipes().get(timeId);

		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		boolean nomeExiste = false;

		for (Equipe t : this.buscaEquipes()) {
			if (t.getNome().equals(equipe.getNome()))
				nomeExiste = true;
		}

		if (!nomeExiste) {
			this.equipe = equipe;
		}
	}

	public void setDiretorByEquipe(Equipe equipe, int usuarioId) {

		for (Usuario usuario : equipe.getUsuarios()) {
			if (usuario.getCodUsuario() == usuarioId) {
				usuario.setTipo(Tipo.Diretor);
			}
		}
	}

	public List<Equipe> buscaEquipes() {
		return equipeService.getEquipes();
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public List<Usuario> getJogadoresSelecionados() {
		return jogadoresSelecionados;
	}

	public void setJogadoresSelecionados(List<Usuario> jogadoresSelecionados) {
		this.jogadoresSelecionados = jogadoresSelecionados;
	}

	// Wizard manipulation
	public String onFlowProcess(FlowEvent event) {
		return event.getNewStep();
	}

	// Service communication
	public void salvar() {
		
		if (equipe == null)
			System.out.println("A equipe é um objeto inválido.");
		else {
			equipeService.salvar(equipe);
			
			if(FacesContext.getCurrentInstance().getViewRoot().getLocale() == Locale.ENGLISH)
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Team " + equipe.getNome() + " successfully subscribed!"));
			else
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Equipe " + equipe.getNome() + " cadastrada com sucesso!"));

			equipe = new Equipe();
		}
	}

	public void remover() {
		equipeService.remover(equipe);
	}
	
	public void registrarIntegrantesEquipe(){
		if(equipe != null && jogadoresSelecionados != null) {
			equipe.setUsuarios(jogadoresSelecionados);
			equipeService.alterar(equipe);
		}
	}
}
