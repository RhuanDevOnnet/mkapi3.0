package onnet.mkapi.domain.model.dto;

public class ResumoContratoAtivo {

    private long contratoAtivos;

    public ResumoContratoAtivo(long contratoAtivos){
        this.contratoAtivos = contratoAtivos;
    }

    public long getContratoAtivos() {
        return contratoAtivos;
    }

    public void setContratoAtivos(long contratoAtivos) {
        this.contratoAtivos = contratoAtivos;
    }

    @Override
    public String toString() {
        return "ResumoContratoAtivo{" +
                "contratoAtivos=" + contratoAtivos +
                '}';
    }
}
