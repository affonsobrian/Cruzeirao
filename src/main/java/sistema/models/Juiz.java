package sistema.models;

//TODO: Criar Hash e Equals

public class Juiz {
	private Tipo tipo;
	private Usuario usuario;
	
	public Juiz() {
		super();
	}
	public Juiz(Tipo tipo, Usuario usuario) {
		super();
		this.tipo = tipo;
		this.usuario = usuario;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Juiz [tipo=" + tipo + ", usuario=" + usuario + "]";
	}
	
	
}
