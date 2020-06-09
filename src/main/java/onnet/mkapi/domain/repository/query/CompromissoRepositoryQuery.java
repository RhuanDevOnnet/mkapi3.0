package onnet.mkapi.domain.repository.query;

import onnet.mkapi.domain.model.dto.OsAgendaDTO;
import onnet.mkapi.domain.model.dto.ResumoOsAgenda;

import java.util.List;

public interface CompromissoRepositoryQuery {

    List<OsAgendaDTO> searchOsAgendaList();
}
