package onnet.mkapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vi_usuarios")
public class ViUsuario {
	
	@Id
	@Column(name = "usr_codigo")
	private long id;
	
	@Column(name = "usr_nome")
	private String usr_nome;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsr_nome() {
		return usr_nome;
	}

	public void setUsr_nome(String usr_nome) {
		this.usr_nome = usr_nome;
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
		ViUsuario other = (ViUsuario) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ViUsuario [id=" + id + ", usr_nome=" + usr_nome + "]";
	}
	
}
