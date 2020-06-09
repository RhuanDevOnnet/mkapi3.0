package onnet.mkapi.domain.resource.rest;

import onnet.mkapi.domain.model.Contrato;
import onnet.mkapi.domain.model.dto.ResumoContratoApi;
import onnet.mkapi.domain.model.dto.VelocidadeUpDown;
import onnet.mkapi.domain.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping(value = "/api2/contrato")
public class MkContratoResource {

    @Autowired
    private ContratoRepository contrato;

    @CrossOrigin(origins =  "*")
    @GetMapping(value = "/contratoapi")
    public ResponseEntity<List<ResumoContratoApi>> buscarContratosApi(){
        List mkContratos = this.contrato.buscarContratoApi();
        if(mkContratos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(mkContratos, HttpStatus.OK);
    }

    @CrossOrigin(origins =  "*")
    @GetMapping(value = "/contratoTransfer/{cod_contrato}")
    public ResponseEntity<List<ResumoContratoApi>> transferirContratos(@PathVariable(value = "cod_contrato") long contratoNum ){
        List<ResumoContratoApi> lstContrato = this.contrato.buscarContratoMaior(contratoNum);
        if(lstContrato.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        lstContrato.forEach(contrato -> {
            if(contrato.getVelDown() == null && contrato.getVelUp() == null ){
                VelocidadeUpDown velUpDown = this.contrato.buscarVelocidadeUpDown(contrato.getIdPlanoMk());
                contrato.setVelDown(velUpDown.getVelocidade_down());
                contrato.setVelUp(velUpDown.getVelocidade_up());
            }
        });
        return new ResponseEntity<>(lstContrato, HttpStatus.OK);
    }

    @CrossOrigin(origins =  "*")
    @GetMapping(path = "/update/{contratoNum}")
    public ResponseEntity<ResumoContratoApi> updateContrato(@PathVariable("contratoNum") long contratoNum){
        ResumoContratoApi updateContrato = this.contrato.updateContratos(contratoNum);

        if(updateContrato == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(updateContrato.getVelDown() == null && updateContrato.getVelUp() == null){
            VelocidadeUpDown velUpDown =  this.contrato.buscarVelocidadeUpDown(updateContrato.getIdPlanoMk());
            updateContrato.setVelDown(velUpDown.getVelocidade_down());
            updateContrato.setVelUp(velUpDown.getVelocidade_up());
        }
        return new ResponseEntity<ResumoContratoApi>(updateContrato, HttpStatus.OK);
    }

    @GetMapping(path = "/contratoapi/{contratoNum}")
    public ResponseEntity<List<ResumoContratoApi>> buscarContratoMaior(@PathVariable("contratoNum") long contratoNum){
        List mkContratos = this.contrato.buscarContratoMaior(contratoNum);
        if(mkContratos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(mkContratos, HttpStatus.OK);
    }

}
