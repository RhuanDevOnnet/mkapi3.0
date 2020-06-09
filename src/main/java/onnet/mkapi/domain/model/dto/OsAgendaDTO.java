package onnet.mkapi.domain.model.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class OsAgendaDTO {

    private long id;
    private long resourceId;
    private LocalDateTime start;
    private LocalDateTime end;
    private String title;
    private String color;
    private String cidade;
    private String bairro;
    private String endereco;
    private String tipoAtendimento;
    private String ultimoStatus;
    private String descricaoUltimoStatus;
    private String finalizadoPeloTecnico;
    private String servicoRealizado;
    private String visualizado;
    private String atendimentoIniciado;
    private String deslocamentoIniciado;
    private String atendimentoAtrasado;
    private String txExtra;


    public OsAgendaDTO(Long id, Long resourceId, LocalDateTime start, LocalDateTime end, String title, String cidade, String bairro, String logradouro, String tipoAtendimento, String ultimoStatus, String descricaoUltimoStatus, String finalizadoPeloTecnico, String servicoRealizado, String visualizado, String atendimentoIniciado, String deslocamento) {
        LocalDateTime dataAtual = LocalDateTime.now();
        this.id = id;
        this.resourceId = resourceId;
        this.start = start;
        this.end = end;
        this.title = title;
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.tipoAtendimento = tipoAtendimento;
        this.ultimoStatus = ultimoStatus;
        this.descricaoUltimoStatus = descricaoUltimoStatus;
        this.finalizadoPeloTecnico = finalizadoPeloTecnico;
        this.servicoRealizado = servicoRealizado;
        this.color = "#2980b9";
        this.visualizado = "N";
        this.atendimentoIniciado = "N";

        if (visualizado == null) {
            this.visualizado = "N";
        } else {
            this.visualizado = "S";
        }

        if (atendimentoIniciado == null) {
            this.atendimentoIniciado = "N";
        } else {
            this.atendimentoIniciado = "S";
        }

        if (deslocamento == null) {
            this.deslocamentoIniciado = "N";
        } else {
            this.deslocamentoIniciado = "S";
        }

        if (this.end.isBefore(dataAtual) && this.servicoRealizado.equals("N")) {
            this.atendimentoAtrasado = "S";
            this.color = "#e74c3c";
        }
        if (servicoRealizado.equals("S") || finalizadoPeloTecnico.equals("S")) {
            this.color = "#2ecc71";
        }


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public String getUltimoStatus() {
        return ultimoStatus;
    }

    public void setUltimoStatus(String ultimoStatus) {
        this.ultimoStatus = ultimoStatus;
    }

    public String getDescricaoUltimoStatus() {
        return descricaoUltimoStatus;
    }

    public void setDescricaoUltimoStatus(String descricaoUltimoStatus) {
        this.descricaoUltimoStatus = descricaoUltimoStatus;
    }

    public String getFinalizadoPeloTecnico() {
        return finalizadoPeloTecnico;
    }

    public void setFinalizadoPeloTecnico(String finalizadoPeloTecnico) {
        this.finalizadoPeloTecnico = finalizadoPeloTecnico;
    }

    public String getServicoRealizado() {
        return servicoRealizado;
    }

    public void setServicoRealizado(String servicoRealizado) {
        this.servicoRealizado = servicoRealizado;
    }

    public String getVisualizado() {
        return visualizado;
    }

    public void setVisualizado(String visualizado) {
        this.visualizado = visualizado;
    }

    public String getAtendimentoIniciado() {
        return atendimentoIniciado;
    }

    public void setAtendimentoIniciado(String atendimentoIniciado) {
        this.atendimentoIniciado = atendimentoIniciado;
    }

    public String getDeslocamentoIniciado() {
        return deslocamentoIniciado;
    }

    public void setDeslocamentoIniciado(String deslocamentoIniciado) {
        this.deslocamentoIniciado = deslocamentoIniciado;
    }

    public String getAtendimentoAtrasado() {
        return atendimentoAtrasado;
    }

    public void setAtendimentoAtrasado(String atendimentoAtrasado) {
        this.atendimentoAtrasado = atendimentoAtrasado;
    }

    public String getTxExtra() {
        return txExtra;
    }

    public void setTxExtra(String txExtra) {
        this.txExtra = txExtra;
    }

    @Override
    public String toString() {
        return "OsAgendaDTO{" +
                "id=" + id +
                ", resourceId=" + resourceId +
                ", start=" + start +
                ", end=" + end +
                ", title='" + title + '\'' +
                ", color='" + color + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", endereco='" + endereco + '\'' +
                ", tipoAtendimento='" + tipoAtendimento + '\'' +
                ", ultimoStatus='" + ultimoStatus + '\'' +
                ", descricaoUltimoStatus='" + descricaoUltimoStatus + '\'' +
                ", finalizadoPeloTecnico='" + finalizadoPeloTecnico + '\'' +
                ", servicoRealizado='" + servicoRealizado + '\'' +
                ", visualizado='" + visualizado + '\'' +
                ", atendimentoIniciado='" + atendimentoIniciado + '\'' +
                ", deslocamentoIniciado='" + deslocamentoIniciado + '\'' +
                ", atendimentoAtrasado='" + atendimentoAtrasado + '\'' +
                ", txExtra='" + txExtra + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OsAgendaDTO that = (OsAgendaDTO) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
