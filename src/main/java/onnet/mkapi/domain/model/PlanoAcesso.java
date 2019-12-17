package onnet.mkapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mk_planos_acesso")
public class PlanoAcesso {
	
	@Id
	@Column(name = "codplano")
	private long id;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "vel_up")
	private String vel_up;
	
	@Column(name = "vel_down")
	private String vel_down;
	
	@Column(name = "vlr_mensalidade")
	private String vlr_mensalidade;
	
	@ManyToOne
	@JoinColumn(name = "tipo")
	private PlanoAcessoTipo tipo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getVel_up() {
		return vel_up;
	}

	public void setVel_up(String vel_up) {
		this.vel_up = vel_up;
	}

	public String getVel_down() {
		return vel_down;
	}

	public void setVel_down(String vel_down) {
		this.vel_down = vel_down;
	}

	public String getVlr_mensalidade() {
		return vlr_mensalidade;
	}

	public void setVlr_mensalidade(String vlr_mensalidade) {
		this.vlr_mensalidade = vlr_mensalidade;
	}

	public PlanoAcessoTipo getTipo() {
		return tipo;
	}

	public void setTipo(PlanoAcessoTipo tipo) {
		this.tipo = tipo;
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
		PlanoAcesso other = (PlanoAcesso) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlanoAcesso [id=" + id + ", descricao=" + descricao + ", vel_up=" + vel_up + ", vel_down=" + vel_down
				+ ", vlr_mensalidade=" + vlr_mensalidade + ", tipo=" + tipo + "]";
	}
	
}
