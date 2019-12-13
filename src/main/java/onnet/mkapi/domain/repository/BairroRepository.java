package onnet.mkapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onnet.mkapi.domain.model.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {

}
