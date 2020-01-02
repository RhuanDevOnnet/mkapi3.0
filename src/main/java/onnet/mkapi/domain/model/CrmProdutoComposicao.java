package onnet.mkapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mk_crm_produtos_composicao")
public class CrmProdutoComposicao {
	
	@Id
	@Column(name = "codcrmprodcompo")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "cd_plano")
	private PlanoAcesso cd_plano;
	
	@ManyToOne
	@JoinColumn(name = "cd_produto")
	private CrmProduto cd_produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PlanoAcesso getCd_plano() {
		return cd_plano;
	}

	public void setCd_plano(PlanoAcesso cd_plano) {
		this.cd_plano = cd_plano;
	}

	public CrmProduto getCd_produto() {
		return cd_produto;
	}

	public void setCd_produto(CrmProduto cd_produto) {
		this.cd_produto = cd_produto;
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
		CrmProdutoComposicao other = (CrmProdutoComposicao) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CrmProdutosComposicao [id=" + id + ", cd_plano=" + cd_plano + ", cd_produto=" + cd_produto + "]";
	}
	
}
