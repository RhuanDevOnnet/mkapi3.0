package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.Contrato;
import onnet.mkapi.domain.repository.ContratoRepository;

@RestController
@RequestMapping(value = "/contrato")
public class ContratoResource {
	
	private ContratoRepository _contratoRepository;
	
	public ContratoResource(ContratoRepository contratoRepository) {
		_contratoRepository = contratoRepository;
	}
	
	@GetMapping
	public ResponseEntity<List<Contrato>> getContrato(){
		List<Contrato> lstContrato = _contratoRepository.findAll();
		
		if(lstContrato.isEmpty()) {
			return new ResponseEntity<List<Contrato>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Contrato>>(lstContrato, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Contrato> findById(@PathVariable long id){
		return _contratoRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
}
