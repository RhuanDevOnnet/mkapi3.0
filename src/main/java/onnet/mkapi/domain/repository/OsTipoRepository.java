package onnet.mkapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onnet.mkapi.domain.model.OsTipo;

@Repository
public interface OsTipoRepository extends JpaRepository<OsTipo, Long>{

}
