package onnet.mkapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "mk_os_mobile_atu_status")
public class OsMobileAtuStatus {

    @Id
    @Column(name = "codosatustatus")
    private long id;

    @Column(name = "evento")
    private String evento;

    @Column(name = "cd_os")
    private long os;

    @Column(name = "tx_extra")
    private String txtExtra;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public long getOs() {
        return os;
    }

    public void setOs(long os) {
        this.os = os;
    }

    public String getTxtExtra() {
        return txtExtra;
    }

    public void setTxtExtra(String txtExtra) {
        this.txtExtra = txtExtra;
    }

    @Override
    public String toString() {
        return "OsMobileAtuStatus{" +
                "id=" + id +
                ", evento='" + evento + '\'' +
                ", os=" + os +
                ", txtExtra='" + txtExtra + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OsMobileAtuStatus that = (OsMobileAtuStatus) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

