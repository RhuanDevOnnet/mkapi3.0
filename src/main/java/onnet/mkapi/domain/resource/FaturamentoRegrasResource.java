package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.FaturamentoRegras;
import onnet.mkapi.domain.repository.FaturamentoRegrasRepository;

@RestController
@RequestMapping(value = "/faturamento_regras")
public class FaturamentoRegrasResource {

	private FaturamentoRegrasRepository _faturamentoRegrasRepository;
		
	public FaturamentoRegrasResource(FaturamentoRegrasRepository faturamentoRegrasRepository) {
		_faturamentoRegrasRepository  = faturamentoRegrasRepository;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<FaturamentoRegras>> getFaturamentoRegras(){
		List<FaturamentoRegras> lstFaturamentoRegras = _faturamentoRegrasRepository.findAll();
		
		if(lstFaturamentoRegras.isEmpty()) {
			return new ResponseEntity<List<FaturamentoRegras>>(HttpStatus.NO_CONTENT);
    }		
		return new ResponseEntity<List<FaturamentoRegras>>(lstFaturamentoRegras, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<FaturamentoRegras> findById(@PathVariable long id){
		return _faturamentoRegrasRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
}
