package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.ViUsuario;
import onnet.mkapi.domain.repository.ViUsuarioRepository;

@RestController
@RequestMapping(value = "/usr")
public class ViUsuarioResource {
	
	@Autowired
	private ViUsuarioRepository viUsuarioRepository;
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "")
	public ResponseEntity<List<ViUsuario>> getViUsuarios(){
		List<ViUsuario> lstUsr = viUsuarioRepository.findAll();
		
		if(lstUsr.isEmpty()) {
			return new ResponseEntity<List<ViUsuario>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<ViUsuario>>(lstUsr, HttpStatus.OK);
	}
}
