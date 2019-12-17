package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.Pessoa;
import onnet.mkapi.domain.repository.PessoaRepository;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {
	
	private PessoaRepository _pessoaRepository;
	
	public PessoaResource(PessoaRepository pessoaRepository) {
		_pessoaRepository = pessoaRepository;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<Pessoa>> getPessoa(){
		List<Pessoa> lstPessoa = _pessoaRepository.findAll();
		
		if(lstPessoa.isEmpty()) {
			return new ResponseEntity<List<Pessoa>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Pessoa>>(lstPessoa, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable long id){
		return _pessoaRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
}
