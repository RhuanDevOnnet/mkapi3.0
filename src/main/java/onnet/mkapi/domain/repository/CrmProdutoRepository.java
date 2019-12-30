package onnet.mkapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onnet.mkapi.domain.model.CrmProduto;

@Repository
public interface CrmProdutoRepository extends JpaRepository<CrmProduto, Long> {

}
