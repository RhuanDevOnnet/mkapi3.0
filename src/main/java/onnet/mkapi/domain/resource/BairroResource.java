package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.Bairro;
import onnet.mkapi.domain.repository.BairroRepository;

@RestController
@RequestMapping(value = "/bairro")
public class BairroResource {

	@Autowired
	private BairroRepository bairroRepository;
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "")
	public ResponseEntity<List<Bairro>> getBairros(){
		
		List<Bairro> lstBairros = this.bairroRepository.findAll();
		
		if(lstBairros.isEmpty()) {
			return new ResponseEntity<List<Bairro>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Bairro>>(lstBairros, HttpStatus.OK);
		
	}
	
}
