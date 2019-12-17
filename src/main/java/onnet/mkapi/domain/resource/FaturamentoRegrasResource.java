package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.FaturamentoRegras;
import onnet.mkapi.domain.repository.FaturamentoRegrasRepository;

@RestController
@RequestMapping(value = "/faturamento_regras")
public class FaturamentoRegrasResource {

	@Autowired
	private FaturamentoRegrasRepository faturamentoRegrasRepository;
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "")
	public ResponseEntity<List<FaturamentoRegras>> getFaturamentoRegras(){
		
		List<FaturamentoRegras> lstFaturamentoRegras = this.faturamentoRegrasRepository.findAll();
		
		if(lstFaturamentoRegras.isEmpty()) {
			return new ResponseEntity<List<FaturamentoRegras>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FaturamentoRegras>>(lstFaturamentoRegras, HttpStatus.OK);
	}
	
}
