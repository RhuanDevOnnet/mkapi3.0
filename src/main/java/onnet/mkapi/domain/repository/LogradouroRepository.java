package onnet.mkapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onnet.mkapi.domain.model.Logradouro;

@Repository
public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {
	
	

}
