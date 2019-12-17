package onnet.mkapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onnet.mkapi.domain.model.PlanoAcessoTipo;

@Repository
public interface PlanoAcessoTipoRepository extends JpaRepository<PlanoAcessoTipo, Long>{
	
}
