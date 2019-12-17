package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.ViUsuario;
import onnet.mkapi.domain.repository.ViUsuarioRepository;

@RestController
@RequestMapping(value = "/vi_usuario")
public class ViUsuarioResource {
	
	private ViUsuarioRepository _viUsuarioRepository;
	
	public ViUsuarioResource(ViUsuarioRepository viUsuarioRepository) {
		_viUsuarioRepository = viUsuarioRepository;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<ViUsuario>> getViUsuarios(){
		List<ViUsuario> lstUsr = _viUsuarioRepository.findAll();
		
		if(lstUsr.isEmpty()) {
			return new ResponseEntity<List<ViUsuario>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<ViUsuario>>(lstUsr, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ViUsuario> findById(@PathVariable long id) {
		return _viUsuarioRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
}