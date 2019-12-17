package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.CrmOperadores;
import onnet.mkapi.domain.repository.CrmOperadoresRepository;

@RestController
@RequestMapping(value = "/crm_operador")
public class CrmOperadoresResource {

	@Autowired
	private CrmOperadoresRepository crmOperadorRepository;
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "")
	public ResponseEntity<List<CrmOperadores>> getCrmOperadores(){
		
		List<CrmOperadores> lstCrmOperadores = this.crmOperadorRepository.findAll();
		
		if(lstCrmOperadores.isEmpty()) {
			return new ResponseEntity<List<CrmOperadores>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CrmOperadores>>(lstCrmOperadores, HttpStatus.OK);
	}

}
