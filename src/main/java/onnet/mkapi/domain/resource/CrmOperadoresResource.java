package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.CrmOperadores;
import onnet.mkapi.domain.repository.CrmOperadoresRepository;

@RestController
@RequestMapping(value = "/crm_operador")
public class CrmOperadoresResource {

	
	private CrmOperadoresRepository _crmOperadorRepository;
	
	public CrmOperadoresResource(CrmOperadoresRepository crmOperadoresRepository) {
		_crmOperadorRepository = crmOperadoresRepository;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "")
	public ResponseEntity<List<CrmOperadores>> getCrmOperadores(){
		
		List<CrmOperadores> lstCrmOperadores = this._crmOperadorRepository.findAll();
		
		if(lstCrmOperadores.isEmpty()) {
			return new ResponseEntity<List<CrmOperadores>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CrmOperadores>>(lstCrmOperadores, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<CrmOperadores> findById(@PathVariable long id){
		return _crmOperadorRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
}
