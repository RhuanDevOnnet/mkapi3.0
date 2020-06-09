package onnet.mkapi.domain.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "mk_compromissos")
public class Compromisso {

    @Id
    @Column(name = "codcompromisso")
    private long id;

    @Column(name = "com_inicio")
    private LocalDateTime comInicio;

    @Column(name = "com_fim")
    private LocalDateTime comFim;

    @Column(name = "cd_operador")
    private long cdOperador;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Pessoa cliente;

    @ManyToOne
    @JoinColumn(name = "cd_integracao")
    private Os integracao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getComInicio() {
        return comInicio;
    }

    public void setComInicio(LocalDateTime comInicio) {
        this.comInicio = comInicio;
    }

    public LocalDateTime getComFim() {
        return comFim;
    }

    public void setComFim(LocalDateTime comFim) {
        this.comFim = comFim;
    }

    public long getCdOperador() {
        return cdOperador;
    }

    public void setCdOperador(long cdOperador) {
        this.cdOperador = cdOperador;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Os getIntegracao() {
        return integracao;
    }

    public void setIntegracao(Os integracao) {
        this.integracao = integracao;
    }

    @Override
    public String toString() {
        return "Compromisso{" +
                "id=" + id +
                ", comInicio=" + comInicio +
                ", comFim=" + comFim +
                ", cdOperador=" + cdOperador +
                ", cliente=" + cliente +
                ", integracao=" + integracao +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compromisso that = (Compromisso) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
