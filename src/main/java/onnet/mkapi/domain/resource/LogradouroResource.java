package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.Logradouro;
import onnet.mkapi.domain.repository.LogradouroRepository;

@RestController
@RequestMapping(value = "/logradouro")
public class LogradouroResource {
	
	private LogradouroRepository _logradouroRepository;
	
	public LogradouroResource(LogradouroRepository logradouroRepository) {
		_logradouroRepository = logradouroRepository;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<Logradouro>> getLogradouro(){
		List<Logradouro> lstLogradouro = _logradouroRepository.findAll();
		
		if(lstLogradouro.isEmpty()) {
			return new ResponseEntity<List<Logradouro>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Logradouro>>(lstLogradouro, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Logradouro> findById(@PathVariable long id) {
		return _logradouroRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

}
