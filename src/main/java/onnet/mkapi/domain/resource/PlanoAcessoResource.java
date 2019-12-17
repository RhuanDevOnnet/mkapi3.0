package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.PlanoAcesso;
import onnet.mkapi.domain.repository.PlanoAcessoRepository;

@RestController
@RequestMapping(value = "/plano_acesso")
public class PlanoAcessoResource {
	
	private PlanoAcessoRepository _planoAcessoRepository;
	
	public PlanoAcessoResource(PlanoAcessoRepository planoAcessoRepository) {
		_planoAcessoRepository = planoAcessoRepository;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<PlanoAcesso>> getPlanoAcesso(){
		List<PlanoAcesso> lstPlanoAcesso = _planoAcessoRepository.findAll();
		
		if(lstPlanoAcesso.isEmpty()) {
			return new ResponseEntity<List<PlanoAcesso>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<PlanoAcesso>>(lstPlanoAcesso, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<PlanoAcesso> findById(@PathVariable long id){
		return _planoAcessoRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
}
