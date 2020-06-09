package onnet.mkapi.domain.resource.rest;

import onnet.mkapi.domain.model.dto.ResumoOsAgenda;
import onnet.mkapi.domain.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/os/service")
public class MkOsResource {

    @Autowired
    private ContratoRepository contrato;

    @GetMapping(path = "/number/{os}")
    public ResponseEntity<ResumoOsAgenda> searchOsNumber(@PathVariable("os") long os){
        ResumoOsAgenda osData = this.contrato.searchOsNumber(os);
        if(osData == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(osData , HttpStatus.OK);
    }
}
