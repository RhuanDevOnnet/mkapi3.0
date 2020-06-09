package onnet.mkapi.domain.model.dto;

public class ResumoConexao {

    private String cliente;
    private long contrato;
    private String cpf;
    private String conexaoBloqueada;

    public ResumoConexao(String cliente, long contrato, String cpf, String conexaoBloqueada){
        this.cliente = cliente;
        this.contrato = contrato;
        this.cpf = cpf;
        this.conexaoBloqueada = conexaoBloqueada;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public long getContrato() {
        return contrato;
    }

    public void setContrato(long contrato) {
        this.contrato = contrato;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getConexaoBloqueada() {
        return conexaoBloqueada;
    }

    public void setConexaoBloqueada(String conexaoBloqueada) {
        this.conexaoBloqueada = conexaoBloqueada;
    }

    @Override
    public String toString() {
        return "ResumoConexao{" +
                "cliente='" + cliente + '\'' +
                ", contrato=" + contrato +
                ", cpf='" + cpf + '\'' +
                ", conexaoBloqueada='" + conexaoBloqueada + '\'' +
                '}';
    }
}
