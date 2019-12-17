package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.PlanoAcessoTipo;
import onnet.mkapi.domain.repository.PlanoAcessoTipoRepository;

@RestController
@RequestMapping(value="/plano_acesso_tipo")
public class PlanoAcessoTipoResource {
	
	@Autowired
	private PlanoAcessoTipoRepository planoAcessoTipoRepository;
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "")
	public ResponseEntity<List<PlanoAcessoTipo>> getPlanoAcesso(){
		
		List<PlanoAcessoTipo> lstPlanoAcessoTipo = this.planoAcessoTipoRepository.findAll();
		
		if(lstPlanoAcessoTipo.isEmpty()) {
			return new ResponseEntity<List<PlanoAcessoTipo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PlanoAcessoTipo>>(lstPlanoAcessoTipo, HttpStatus.OK);
	}
	
}
