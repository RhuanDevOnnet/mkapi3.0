package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.Cidade;
import onnet.mkapi.domain.repository.CidadeRepository;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeResource {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "")
	
	public ResponseEntity<List<Cidade>> getCidade(){
		
		List<Cidade> lstCidade = this.cidadeRepository.findAll();
		
		if(lstCidade.isEmpty()) {
			return new ResponseEntity<List<Cidade>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Cidade>>(lstCidade, HttpStatus.OK);
	}
	
	@GetMapping(path = "{id}")
	public ResponseEntity<Cidade> findById(@PathVariable long id){
		return cidadeRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
}
