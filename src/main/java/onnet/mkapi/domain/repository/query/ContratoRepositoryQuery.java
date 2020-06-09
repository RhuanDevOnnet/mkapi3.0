package onnet.mkapi.domain.repository.query;

import onnet.mkapi.domain.model.dto.*;

import java.util.List;

public interface ContratoRepositoryQuery {

    public TotalSemFidelidade buscarSemFidelidade();

    public List<ResumoContratoApi> buscarContratoApi();

    public List<ResumoContratoApi> buscarContratoMaior(long contractId);

    public VelocidadeUpDown buscarVelocidadeUpDown(long plano);

    public ResumoOsAgenda searchOsNumber(long os);

    public ResumoContratoApi updateContratos(long id);

    public ResumoContratoAtivo buscarContratoAtivo();

}
