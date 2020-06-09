package onnet.mkapi.domain.model.dto;

public class ResumoOsAgenda {

    private String cliente;
    private String tipoos;

    public ResumoOsAgenda(String cliente, String tipoos){
        this.cliente = cliente;
        this.tipoos = tipoos;
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

    @Override
    public String toString() {
        return "ResumoOsAgenda{" +
                "cliente='" + cliente + '\'' +
                ", tipoos='" + tipoos + '\'' +
                '}';
    }
}
