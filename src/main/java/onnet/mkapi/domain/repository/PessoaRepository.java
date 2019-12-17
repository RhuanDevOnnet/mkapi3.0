package onnet.mkapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import onnet.mkapi.domain.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
