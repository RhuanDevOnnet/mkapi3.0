package onnet.mkapi.domain.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onnet.mkapi.domain.model.CrmProdutoComposicao;
import onnet.mkapi.domain.repository.CrmProdutoComposicaoRepository;

@RestController
@RequestMapping(value = "/crmProdutoComposicao")
public class CrmProdutoComposicaoResource {
	private CrmProdutoComposicaoRepository _crmProdutoComposicaoRepository;
	
	public CrmProdutoComposicaoResource(CrmProdutoComposicaoRepository crmProdutoComposicaoRepository) {
		_crmProdutoComposicaoRepository = crmProdutoComposicaoRepository;
	}
	
	@GetMapping
	public ResponseEntity<List<CrmProdutoComposicao>> getCrmProdutoComposicao(){
		List<CrmProdutoComposicao> lstCrmProdutoComposicao = _crmProdutoComposicaoRepository.findAll();
		
		if(lstCrmProdutoComposicao.isEmpty()) {
			return new ResponseEntity<List<CrmProdutoComposicao>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<CrmProdutoComposicao>>(lstCrmProdutoComposicao, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<CrmProdutoComposicao> findById(@PathVariable long id) {
		return _crmProdutoComposicaoRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
}
