package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.OsTipo;
import onnet.mkapi.domain.repository.OsTipoRepository;

@RestController
@RequestMapping(value = "/os_tipo")
public class OsTipoResource {

	@Autowired
	private OsTipoRepository osTipoRepository;
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "")
	public ResponseEntity<List<OsTipo>> getOsTipo(){
		
		List<OsTipo> lstOsTipo = this.osTipoRepository.findAll();
		
		if(lstOsTipo.isEmpty()) {
			return new ResponseEntity<List<OsTipo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<OsTipo>>(lstOsTipo, HttpStatus.OK);
	}
	
}