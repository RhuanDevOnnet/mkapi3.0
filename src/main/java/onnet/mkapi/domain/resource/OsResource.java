package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.Os;
import onnet.mkapi.domain.repository.OsRepository;

@RestController
@RequestMapping(value = "/os")
public class OsResource {
	
	private OsRepository _osRepository;
	
	public OsResource(OsRepository osRepository) {
		_osRepository = osRepository;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<Os>> getOs(){
		List<Os> lstOs = _osRepository.findAll();
		
		if(lstOs.isEmpty()) {
			return new ResponseEntity<List<Os>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Os>>(lstOs, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Os> findById(@PathVariable long id){
		return _osRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
}
