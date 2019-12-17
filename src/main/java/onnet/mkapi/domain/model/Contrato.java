package onnet.mkapi.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mk_contratos")
public class Contrato {
	
	@Id
	@Column(name = "codcontrato")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "cliente")
	private Pessoa cliente;
	
	@Column(name = "cancelado")
	private String cancelado;
	
	@Column(name = "adesao")
	private LocalDate adesao;
	
	@Column(name = "previsao_vencimento")
	private LocalDate previsaoVencimento;
	
	@ManyToOne
	@JoinColumn(name = "plano_acesso")
	private PlanoAcesso plano;
	
	@Column(name = "operador")
	private String operador;
	
	@ManyToOne
	@JoinColumn(name = "consultor_crm")
	private ViUsuario consultor_crm;
	
	@ManyToOne
	@JoinColumn(name = "cd_regra_faturamento")
	private FaturamentoRegras faturamento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public String getCancelado() {
		return cancelado;
	}

	public void setCancelado(String cancelado) {
		this.cancelado = cancelado;
	}

	public LocalDate getAdesao() {
		return adesao;
	}

	public void setAdesao(LocalDate adesao) {
		this.adesao = adesao;
	}

	public LocalDate getPrevisaoVencimento() {
		return previsaoVencimento;
	}

	public void setPrevisaoVencimento(LocalDate previsaoVencimento) {
		this.previsaoVencimento = previsaoVencimento;
	}

	public PlanoAcesso getPlano() {
		return plano;
	}

	public void setPlano(PlanoAcesso plano) {
		this.plano = plano;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public ViUsuario getConsultor_crm() {
		return consultor_crm;
	}

	public void setConsultor_crm(ViUsuario consultor_crm) {
		this.consultor_crm = consultor_crm;
	}

	public FaturamentoRegras getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(FaturamentoRegras faturamento) {
		this.faturamento = faturamento;
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
		Contrato other = (Contrato) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", cliente=" + cliente + ", cancelado=" + cancelado + ", adesao=" + adesao
				+ ", previsaoVencimento=" + previsaoVencimento + ", plano=" + plano + ", operador=" + operador
				+ ", consultor_crm=" + consultor_crm + ", faturamento=" + faturamento + "]";
	}
	
}
