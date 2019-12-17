package onnet.mkapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onnet.mkapi.domain.model.FaturamentoRegras;

@Repository
public interface FaturamentoRegrasRepository extends JpaRepository<FaturamentoRegras, Long> {

}
