package sistema.models;

import java.util.Date;
import java.util.List;

public class Usuario {
	
	//Atributos
	private String email;
	private String nome;
	private Date dataNascimento;
	private List<Equipe> equipes;
	private List<Inscrito> inscricoes;
	private List<Campeonato> campeonatos;
	private Tipo tipo;
	private String telefoneFixo;
	private	String telefoneModel;
	private	String endereco;
	private String rg;
	private	String cpf;
	private String cref;
	private Sexo sexo;
	private String foto;
	
	//Constutores
	public Usuario() {
		
	}
	public Usuario(String email, String nome, Date dataNascimento, List<Equipe> equipes, List<Inscrito> inscricoes,
			List<Campeonato> campeonatos, Tipo tipo, String telefoneFixo, String telefoneModel, String endereco,
			String rg, String cpf, String cref, Sexo sexo, String foto) {
		super();
		this.email = email;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.equipes = equipes;
		this.inscricoes = inscricoes;
		this.campeonatos = campeonatos;
		this.tipo = tipo;
		this.telefoneFixo = telefoneFixo;
		this.telefoneModel = telefoneModel;
		this.endereco = endereco;
		this.rg = rg;
		this.cpf = cpf;
		this.cref = cref;
		this.sexo = sexo;
		this.foto = foto;
	}
	
	
	//Getters and Setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public List<Equipe> getEquipes() {
		return equipes;
	}
	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
	public List<Inscrito> getInscricoes() {
		return inscricoes;
	}
	public void setInscricoes(List<Inscrito> inscricoes) {
		this.inscricoes = inscricoes;
	}
	public List<Campeonato> getCampeonatos() {
		return campeonatos;
	}
	public void setCampeonatos(List<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public String getTelefoneModel() {
		return telefoneModel;
	}
	public void setTelefoneModel(String telefoneModel) {
		this.telefoneModel = telefoneModel;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCref() {
		return cref;
	}
	public void setCref(String cref) {
		this.cref = cref;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	//TODO: Gerar toString
}
