package onnet.mkapi.domain.resource;

import java.util.List;

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
@RequestMapping(value = "/conexao")
public class ConexaoResource {

	private ConexaoRepository _conexaoRepository;
	
	public ConexaoResource(ConexaoRepository conexaoRepository) {
		_conexaoRepository = conexaoRepository;
	}
		
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<Conexao>> getCidade(){
		List<Conexao> lstConexao = _conexaoRepository.findAll();
		
		if(lstConexao.isEmpty()) {
			return new ResponseEntity<List<Conexao>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Conexao>>(lstConexao, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Conexao> findById(@PathVariable long id) {
		return _conexaoRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
}
