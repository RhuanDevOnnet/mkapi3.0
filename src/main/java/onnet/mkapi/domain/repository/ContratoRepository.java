package onnet.mkapi.domain.repository;

import onnet.mkapi.domain.repository.query.ContratoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import onnet.mkapi.domain.model.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long>, ContratoRepositoryQuery {

}
