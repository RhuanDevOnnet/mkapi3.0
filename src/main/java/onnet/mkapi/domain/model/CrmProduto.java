package onnet.mkapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mk_crm_produtos")
public class CrmProduto {
	
	@Id
	@Column(name = "codcrmproduto")
	private long id;
	
	@Column(name = "cd_plano_principal")
	private long cd_plano;
	
	@Column(name = "nome_produto")
	private String nome_produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCd_plano() {
		return cd_plano;
	}

	public void setCd_plano(long cd_plano) {
		this.cd_plano = cd_plano;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
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
		CrmProduto other = (CrmProduto) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CrmProduto [id=" + id + ", cd_plano=" + cd_plano + ", nome_produto=" + nome_produto + "]";
	}
	
}
