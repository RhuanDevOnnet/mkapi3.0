package onnet.mkapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onnet.mkapi.domain.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
