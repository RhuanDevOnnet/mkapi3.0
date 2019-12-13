package onnet.mkapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onnet.mkapi.domain.model.ViUsuario;

@Repository
public interface ViUsuarioRepository extends JpaRepository<ViUsuario, Long> {

}
