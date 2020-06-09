package onnet.mkapi.domain.repository.implementation;

import onnet.mkapi.domain.model.dto.OsAgendaDTO;
import onnet.mkapi.domain.repository.query.CompromissoRepositoryQuery;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CompromissoRepositoryImpl implements CompromissoRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<OsAgendaDTO> searchOsAgendaList() {
        StringBuilder consulta = new StringBuilder();
        String visualizado = "000";
        String atendimentoIniciado = "001";
        String tecnicoDeslocamento = "009";

        consulta.append("SELECT new onnet.mkapi.domain.model.dto.OsAgendaDTO(os.id, cp.cdOperador, cp.comInicio, cp.comFim, cliente.nome, cidade.cidade, bairro.bairro, logradouro.logradouro, ostipo.descricao, os.ultimoStatusAppMk, os.ultimoStatusAppMkTx, os.fechamentoTecnico, os.encerrado, (SELECT MAX(mb.evento) FROM OsMobileAtuStatus mb WHERE os.id = mb.os and mb.evento = :visualizado) as visualizado, (SELECT MAX(mb.evento) FROM OsMobileAtuStatus mb WHERE os.id = mb.os and mb.evento = :atendimentoIniciado) as atendimentoIniciado , (SELECT MAX(mb.evento) FROM OsMobileAtuStatus mb WHERE os.id = mb.os and mb.evento = :tecnicoDeslocamento) as deslocamento ) ")
                .append("FROM Compromisso cp, Pessoa cliente, Cidade cidade, Bairro bairro, Logradouro logradouro, Os os, OsTipo ostipo ")
                .append("WHERE cliente.id = cp.cliente ")
                .append("AND ")
                .append("cidade.id = cliente.cidade ")
                .append("AND ")
                .append("bairro.id = cliente.bairro ")
                .append("AND ")
                .append("logradouro.id = cliente.logradouro ")
                .append("AND ")
                .append("os.id = cp.integracao ")
                .append("AND ")
                .append("ostipo.id = os.tipoos ")
                .append("AND ")
                .append("cp.comFim IS NOT NULL ")
                .append("AND ")
                .append("year(cp.comInicio) >= 2019 ");

        try {
            return this.manager.createQuery(consulta.toString(), OsAgendaDTO.class)
                    .setParameter("visualizado", visualizado)
                    .setParameter("atendimentoIniciado", atendimentoIniciado)
                    .setParameter("tecnicoDeslocamento", tecnicoDeslocamento)
                    .getResultList();
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        }
    }
}
