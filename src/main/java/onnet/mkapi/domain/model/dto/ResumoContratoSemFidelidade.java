package onnet.mkapi.domain.model.dto;

import java.time.LocalDate;

public class ResumoContratoSemFidelidade {

    public LocalDate dataCarga;
    public long semFidelidade;
    public long contratoAtivo;

    public ResumoContratoSemFidelidade(LocalDate dataCarga, long semFidelidade, long contratoAtivo){
        this.dataCarga = dataCarga;
        this.semFidelidade = semFidelidade;
        this.contratoAtivo = contratoAtivo;
    }

    public LocalDate getDataCarga() {
        return dataCarga;
    }

    public void setDataCarga(LocalDate dataCarga) {
        this.dataCarga = dataCarga;
    }

    public long getSemFidelidade() {
        return semFidelidade;
    }

    public void setSemFidelidade(long semFidelidade) {
        this.semFidelidade = semFidelidade;
    }

    public long getContratoAtivo() {
        return contratoAtivo;
    }

    public void setContratoAtivo(long contratoAtivo) {
        this.contratoAtivo = contratoAtivo;
    }

    @Override
    public String toString() {
        return "ResumoContratoSemFidelidade{" +
                "dataCarga=" + dataCarga +
                ", semFidelidade=" + semFidelidade +
                ", contratoAtivo=" + contratoAtivo +
                '}';
    }
}
