package sistema.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import java.util.List;
import sistema.models.Equipe;
import sistema.models.Tipo;
import sistema.models.Usuario;
import sistema.service.EquipeService;

@ManagedBean
@ViewScoped
public class EquipeMB {

	private Equipe equipe = new Equipe();
	private List<Equipe> equipes;
	private EquipeService equipeService = new EquipeService();

	// Getters and Setters
	public Equipe getEquipe() {
		return equipe;
	}

	public Equipe getEquipeById(int timeId) {
		Equipe equipe = (Equipe) this.getEquipes().get(timeId);

		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		boolean nomeExiste = false;

		for (Equipe t : this.getEquipes()) {
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

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	// Wizard manipulation
	public String onFlowProcess(FlowEvent event) {
		return event.getNewStep();
	}

	// Service communication
	public void salvar() {
		if (!equipe.equals(null)) {
			equipeService.salvar(equipe);
			equipes.add(equipe);
			
			FacesMessage msg = new FacesMessage("Equipe" + equipe.getNome() + "cadastrada com sucesso!");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			
			equipe = new Equipe();
		}
	}
	
	public void remover() {
		equipeService.remover(equipe);
	}
}
