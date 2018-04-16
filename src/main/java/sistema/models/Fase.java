package sistema.models;

import sistema.models.Categoria;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

//TODO: Criar Hash e Equals
@Entity
public class Fase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codFase;
	private Date datainicio;
	private Formato formato;
	private Categoria categoria;
	private List<Grupo> grupo;
	private int numero;
	
	
	public Fase() {
		super();
	}
	public Fase(Date datainicio, Formato formato, Categoria categoria, List<Grupo> grupo, int numero) {
		super();
		this.datainicio = datainicio;
		this.formato = formato;
		this.categoria = categoria;
		this.grupo = grupo;
		this.numero = numero;
	}
	public Date getDatainicio() {
		return datainicio;
	}
	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}
	public Formato getFormato() {
		return formato;
	}
	public void setFormato(Formato formato) {
		this.formato = formato;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<Grupo> getGrupo() {
		return grupo;
	}
	public void setGrupo(List<Grupo> grupo) {
		this.grupo = grupo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "Fase [datainicio=" + datainicio + ", formato=" + formato + ", categoria=" + categoria + ", grupo="
				+ grupo + ", numero=" + numero + "]";
	}
	
	
}
