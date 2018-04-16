package sistema.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.models.Categoria;
import sistema.models.Usuario;
import sistema.service.CategoriaService;

@ManagedBean
@ViewScoped
public class CategoriaManagedBean {
	
	private Categoria categoria;
	private CategoriaService service;

	
	public void onRowEdition(RowEditEvent event)
	{
		Categoria c = ((Categoria)event.getObject());
		service.alterar(c);
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
