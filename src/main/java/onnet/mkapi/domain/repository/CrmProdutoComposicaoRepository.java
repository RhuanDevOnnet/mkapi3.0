package onnet.mkapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onnet.mkapi.domain.model.CrmProdutoComposicao;

@Repository
public interface CrmProdutoComposicaoRepository extends JpaRepository<CrmProdutoComposicao, Long>{

}
