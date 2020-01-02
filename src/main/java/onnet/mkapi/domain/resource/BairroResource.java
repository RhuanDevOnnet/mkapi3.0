package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.Bairro;
import onnet.mkapi.domain.repository.BairroRepository;

@RestController
@RequestMapping(value = "/bairro")
public class BairroResource {

	private BairroRepository _bairroRepository;
	
	public BairroResource(BairroRepository bairroRepository) {
		_bairroRepository = bairroRepository;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<Bairro>> getBairro(){
		List<Bairro> lstBairro = _bairroRepository.findAll();
		
		if(lstBairro.isEmpty()) {
			return new ResponseEntity<List<Bairro>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Bairro>>(lstBairro, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Bairro> findById(@PathVariable long id){
		return _bairroRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Bairro> findById(@PathVariable long id){
		return bairroRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
}
