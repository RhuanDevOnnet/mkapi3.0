package onnet.mkapi.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mk_pessoas")
public class Pessoa {
	
	@Id
	@Column(name = "codpessoa")
	private long id;
	
	@Column(name = "nome_razaosocial")
	private String nome;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "rg")
	private String rg;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "fone01")
	private String celular;
	
	@Column(name = "fone02")
	private String telefone01;
	
	@Column(name = "fax")
	private String telefone02;
	
	@Column(name = "nascimento")
	private LocalDate nascimento;
	
	@Column(name = "nomepai")
	private String nomePai;
	
	@Column(name = "nomemae")
	private String nomeMae;
	
	@Column(name = "complementoendereco")
	private String complemento;
	
	@Column(name = "fundacao")
	private LocalDate fundacao;
	
	@Column(name = "tipopessoa")
	private long tipo_pessoa;
	
	@ManyToOne
    @JoinColumn(name = "codcidade")
    private Cidade cidade;
	
	@Column(name = "cep")
	private String cep;
	
	@ManyToOne
    @JoinColumn(name = "codestado")
    private Estado uf;
	
	@ManyToOne
	@JoinColumn(name = "codbairro")
	private Bairro bairro;
	
	@ManyToOne
	@JoinColumn(name = "codlogradouro")
	private Logradouro logradouro;
	
	@Column(name = "numero")
	private Long numero;
	
	@Column(name = "ie")
	private String ie;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone01() {
		return telefone01;
	}

	public void setTelefone01(String telefone01) {
		this.telefone01 = telefone01;
	}

	public String getTelefone02() {
		return telefone02;
	}

	public void setTelefone02(String telefone02) {
		this.telefone02 = telefone02;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public LocalDate getFundacao() {
		return fundacao;
	}

	public void setFundacao(LocalDate fundacao) {
		this.fundacao = fundacao;
	}

	public long getTipo_pessoa() {
		return tipo_pessoa;
	}

	public void setTipo_pessoa(long tipo_pessoa) {
		this.tipo_pessoa = tipo_pessoa;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Estado getUf() {
		return uf;
	}

	public void setUf(Estado uf) {
		this.uf = uf;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Pessoa other = (Pessoa) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", cnpj=" + cnpj + ", rg=" + rg + ", email="
				+ email + ", celular=" + celular + ", telefone01=" + telefone01 + ", telefone02=" + telefone02
				+ ", nascimento=" + nascimento + ", nomePai=" + nomePai + ", nomeMae=" + nomeMae + ", complemento="
				+ complemento + ", fundacao=" + fundacao + ", tipo_pessoa=" + tipo_pessoa + ", cep=" + cep + ", uf="
				+ uf + ", bairro=" + bairro + ", logradouro=" + logradouro + ", numero=" + numero + ", ie=" + ie + "]";
	}
	
}
