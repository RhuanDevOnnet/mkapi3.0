package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.Estado;
import onnet.mkapi.domain.repository.EstadoRepository;

@RestController
@RequestMapping(value = "/estado")
public class EstadoResource {

private EstadoRepository _estadoRepository;
	
	public EstadoResource(EstadoRepository estadoRepository) {
		_estadoRepository = estadoRepository;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<Estado>> getEstado(){
		List<Estado> lstEstado = _estadoRepository.findAll();
		
		if(lstEstado.isEmpty()) {
			return new ResponseEntity<List<Estado>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Estado>>(lstEstado, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Estado> findById(@PathVariable long id){
		return _estadoRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
}
