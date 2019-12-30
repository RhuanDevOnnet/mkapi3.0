package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.CrmProduto;
import onnet.mkapi.domain.repository.CrmProdutoRepository;

@RestController
@RequestMapping(value = "/crmProduto" )
public class CrmProdutoResource {
	private CrmProdutoRepository _crmProdutoRepository;
	
	public CrmProdutoResource (CrmProdutoRepository crmProdutoRepository) {
		_crmProdutoRepository = crmProdutoRepository;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<CrmProduto>> getCrmProduto(){
		List<CrmProduto> lstCrmProduto = _crmProdutoRepository.findAll();
		
		if(lstCrmProduto.isEmpty()) {
			return new ResponseEntity<List<CrmProduto>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<CrmProduto>>(lstCrmProduto, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<CrmProduto> findById(@PathVariable long id){
		return _crmProdutoRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
}
