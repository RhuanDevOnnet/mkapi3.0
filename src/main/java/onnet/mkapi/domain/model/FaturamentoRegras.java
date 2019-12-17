package onnet.mkapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mk_faturamentos_regras")
public class FaturamentoRegras {
   
	@Id
    @Column(name="codfaturamentoregra")
    private long id;
    
    @Column(name="periodo1_vencimento")
    private Integer dia_vencimento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
    public Integer getDia_vencimento() {
		return dia_vencimento;
	}

	public void setDia_vencimento(Integer dia_vencimento) {
		this.dia_vencimento = dia_vencimento;
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
		FaturamentoRegras other = (FaturamentoRegras) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FaturamentoRegras [id=" + id + ", dia_vencimento=" + dia_vencimento + "]";
	}        
}