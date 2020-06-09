package onnet.mkapi.domain.repository;

import onnet.mkapi.domain.model.Compromisso;
import onnet.mkapi.domain.repository.query.CompromissoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompromissoRepository extends JpaRepository<Compromisso, Long> , CompromissoRepositoryQuery {
}
