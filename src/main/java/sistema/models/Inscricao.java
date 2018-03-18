package sistema.models;

import java.util.List;

//TODO: Implementar ToString() para a classe de Inscricao.

public class Inscricao {
	long numero;
	boolean pagamento;
	boolean validada;
	List<Inscrito> inscritos;
	Categoria categoria;
	List<Partida> partidas;
	Equipe equipe;

	public Inscricao() {
		super();
	}

	public Inscricao(long numero, boolean pagamento, boolean validada, List<Inscrito> inscritos, Categoria categoria,
			List<Partida> partidas, Equipe equipe) {
		super();
		this.numero = numero;
		this.pagamento = pagamento;
		this.validada = validada;
		this.inscritos = inscritos;
		this.categoria = categoria;
		this.partidas = partidas;
		this.equipe = equipe;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public boolean isPagamento() {
		return pagamento;
	}

	public void setPagamento(boolean pagamento) {
		this.pagamento = pagamento;
	}

	public boolean isValidada() {
		return validada;
	}

	public void setValidada(boolean validada) {
		this.validada = validada;
	}

	public List<Inscrito> getInscritos() {
		return inscritos;
	}

	public void setInscritos(List<Inscrito> inscritos) {
		this.inscritos = inscritos;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

}
