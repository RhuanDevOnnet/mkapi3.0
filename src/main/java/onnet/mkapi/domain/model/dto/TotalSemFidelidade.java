package onnet.mkapi.domain.model.dto;

public class TotalSemFidelidade {

    private long semFidelidade;

    public TotalSemFidelidade(long semFidelidade){
            this.semFidelidade = semFidelidade;
    }

    public long getSemFidelidade() {
        return semFidelidade;
    }

    public void setSemFidelidade(long semFidelidade) {
        this.semFidelidade = semFidelidade;
    }

    @Override
    public String toString() {
        return "TotalSemFidelidade{" +
                "semFidelidade=" + semFidelidade +
                '}';
    }
}
