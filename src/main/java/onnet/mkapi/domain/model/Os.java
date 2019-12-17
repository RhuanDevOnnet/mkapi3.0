package onnet.mkapi.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mk_os")
public class Os {
	
	@Id
	@Column(name = "codos")
	private long id;
	
	@Column(name = "data_abertura")
	private LocalDate dataAbertura;
	
	@Column(name = "defeito_associado")
	private String defeitoAssociado;
	
	@ManyToOne
	@JoinColumn(name = "cliente")
	private Pessoa cliente;
	
	@ManyToOne
	@JoinColumn(name = "tipo_os")
	private OsTipo tipoos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getDefeitoAssociado() {
		return defeitoAssociado;
	}

	public void setDefeitoAssociado(String defeitoAssociado) {
		this.defeitoAssociado = defeitoAssociado;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public OsTipo getTipoos() {
		return tipoos;
	}

	public void setTipoos(OsTipo tipoos) {
		this.tipoos = tipoos;
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
		Os other = (Os) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Os [id=" + id + ", dataAbertura=" + dataAbertura + ", defeitoAssociado=" + defeitoAssociado
				+ ", cliente=" + cliente + ", tipoos=" + tipoos + "]";
	}

}
