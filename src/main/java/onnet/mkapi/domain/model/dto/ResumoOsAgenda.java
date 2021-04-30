package onnet.mkapi.domain.model.dto;

public class ResumoOsAgenda {

    private String cliente;
    private String tipoos;
    private String cidade;

    public ResumoOsAgenda(String cliente, String tipoos, String cidade){
        this.cliente = cliente;
        this.tipoos = tipoos;
        this.cidade = cidade;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipoos() {
        return tipoos;
    }

    public void setTipoos(String tipoos) {
        this.tipoos = tipoos;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "ResumoOsAgenda{" +
                "cliente='" + cliente + '\'' +
                ", tipoos='" + tipoos + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
