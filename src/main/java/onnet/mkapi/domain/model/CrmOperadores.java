package onnet.mkapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mk_crm_operadores")
public class CrmOperadores {

	@Id
	@Column(name="codcrmoperadores")
	private long id;
	
	@Column(name="cd_operador")
	private long cd_operador;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCd_operador() {
		return cd_operador;
	}

	public void setCd_operador(long cd_operador) {
		this.cd_operador = cd_operador;
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
		CrmOperadores other = (CrmOperadores) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CrmOperadores [id=" + id + ", cd_operador=" + cd_operador + "]";
	}	
}
