package sistema.models;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@SequenceGenerator(name="USU_SEQ", sequenceName="codUsuarioSequence", initialValue=1, allocationSize=1, schema="APP")
public class Usuario {
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codUsuario;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String senha;
	private Date dataNascimento;
	
	//TODO checar se está correto
	@ManyToMany
    @JoinTable(name="Usuario_Equipe",
    joinColumns = {@JoinColumn(name="CodUsuario")},
    inverseJoinColumns = {@JoinColumn(name="CodEquipe")})
	private List<Equipe> equipes;
	
	private List<Inscrito> inscricoes;
	@ManyToMany(mappedBy = "juizes")
	private List<Campeonato> campeonatos;
	private Tipo tipo;
	private String telefoneFixo;
	private	String telefoneMovel;
	private	String endereco;
	@Column(unique = true)
	private String rg;
	@Column(unique = true)
	private	String cpf;
	private String cref;
	private Sexo sexo;
	private Byte[] foto;
	private boolean aceite = true;
	
	//Constutores
	public Usuario() {
	}
	public Usuario(String email, String nome, Date dataNascimento, List<Equipe> equipes, List<Inscrito> inscricoes,
			List<Campeonato> campeonatos, Tipo tipo, String telefoneFixo, String telefoneMovel, String endereco,
			String rg, String cpf, String cref, Sexo sexo, Byte[] foto, boolean aceite) {
		super();
		this.email = email;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.equipes = equipes;
		this.inscricoes = inscricoes;
		this.campeonatos = campeonatos;
		this.tipo = tipo;
		this.telefoneFixo = telefoneFixo;
		this.telefoneMovel = telefoneMovel;
		this.endereco = endereco;
		this.rg = rg;
		this.cpf = cpf;
		this.cref = cref;
		this.sexo = sexo;
		this.foto = foto;
		this.aceite = aceite;
	}
	
	//Getters and Setters
	public int getCodUsuario() {
		return codUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
	public String getTelefoneMovel() {
		return telefoneMovel;
	}
	public void setTelefoneMovel(String telefoneMovel) {
		this.telefoneMovel = telefoneMovel;
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
	public Byte [] getFoto() {
		return foto;
	}
	public void setFoto(Byte [] foto) {
		this.foto = foto;
	}
	public boolean isAceite() {
		return aceite;
	}
	public void setAceite(boolean aceite) {
		this.aceite = aceite;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codUsuario;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		if (codUsuario != other.codUsuario)
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	
	
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	
	@Override
	public String toString() {
		return "Usuario [codUsuario=" + codUsuario + ", email=" + email + ", nome=" + nome + ", senha=" + senha
				+ ", dataNascimento=" + dataNascimento + ", equipes=" + equipes + ", inscricoes=" + inscricoes
				+ ", campeonatos=" + campeonatos + ", tipo=" + tipo + ", telefoneFixo=" + telefoneFixo
				+ ", telefoneMovel=" + telefoneMovel + ", endereco=" + endereco + ", rg=" + rg + ", cpf=" + cpf
				+ ", cref=" + cref + ", sexo=" + sexo + ", foto=" + foto + "aceite=" + aceite +"]";
	}
	
}