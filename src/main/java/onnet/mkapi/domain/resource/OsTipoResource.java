package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.OsTipo;
import onnet.mkapi.domain.repository.OsTipoRepository;

@RestController
@RequestMapping(value = "/os_tipo")
public class OsTipoResource {

	private OsTipoRepository _osTipoRepository;
	
	public OsTipoResource(OsTipoRepository osTipoRepository) {
		_osTipoRepository = osTipoRepository;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<OsTipo>> getOsTipo(){
		List<OsTipo> lstOsTipo = _osTipoRepository.findAll();
		
		if(lstOsTipo.isEmpty()) {
			return new ResponseEntity<List<OsTipo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<OsTipo>>(lstOsTipo, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<OsTipo> findById(@PathVariable long id) {
		return _osTipoRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

}