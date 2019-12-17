package onnet.mkapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onnet.mkapi.domain.model.CrmOperadores;

@Repository
public interface CrmOperadoresRepository extends JpaRepository<CrmOperadores, Long>{

}
