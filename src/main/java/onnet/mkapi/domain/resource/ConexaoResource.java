package onnet.mkapi.domain.resource;

import java.util.List;

import onnet.mkapi.domain.model.dto.ResumoConexao;
import onnet.mkapi.domain.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import onnet.mkapi.domain.model.Conexao;
import onnet.mkapi.domain.repository.ConexaoRepository;

@RestController
@RequestMapping(value = "/api/clientes")
public class ConexaoResource {


}
