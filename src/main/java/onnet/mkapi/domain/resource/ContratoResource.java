package onnet.mkapi.domain.resource;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import onnet.mkapi.domain.model.dto.ResumoContratoApi;
import onnet.mkapi.domain.model.dto.VelocidadeUpDown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import onnet.mkapi.domain.repository.ContratoRepository;

@RestController
@RequestMapping(value = "/api/contrato")
public class ContratoResource {

    @Autowired
    private ContratoRepository contratoRepository;

    @CrossOrigin(origins =  "*")
    @GetMapping(path = "/contratoapi")
    public ResponseEntity<List<ResumoContratoApi>> buscarContratosApi() {
        List<ResumoContratoApi> mkContratos = this.contratoRepository.buscarContratoApi();

        if(mkContratos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ResumoContratoApi>>(mkContratos, HttpStatus.OK);
    }

    @CrossOrigin(origins =  "*")
    @GetMapping(path = "/contratoTransfer/{contratoNum}")
    public ResponseEntity<List<ResumoContratoApi>> transferirContratos(@PathVariable("contratoNum") long contratoNum){
        Date date = new Date();

        System.out.println("----------------- IMPORTAR " + date + " -----------------");

        List<ResumoContratoApi> mkContratos = this.contratoRepository.buscarContratoMaior(contratoNum);
        if(mkContratos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        mkContratos.forEach((contratos) -> {
            if(contratos.getVelDown() == null && contratos.getVelUp() == null){
                VelocidadeUpDown velUpDown = this.contratoRepository.buscarVelocidadeUpDown(contratos.getIdPlanoMk());
                contratos.setVelDown(velUpDown.getVelocidade_down());
                contratos.setVelUp(velUpDown.getVelocidade_up());
            }
        });

        return new ResponseEntity<>(mkContratos, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/update/{contratoNum}")
    public ResponseEntity<ResumoContratoApi> updateContrato(@PathVariable("contratoNum") long contratoNum){
        Date date = new Date();

        System.out.println("----------------- ATUALIZAR " + date + " -----------------");

        ResumoContratoApi updatecontrato = this.contratoRepository.updateContratos(contratoNum);

        if(updatecontrato == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(updatecontrato.getVelDown() == null && updatecontrato.getVelUp() == null){
            VelocidadeUpDown velUpdown = this.contratoRepository.buscarVelocidadeUpDown(updatecontrato.getIdPlanoMk());
            updatecontrato.setVelDown(velUpdown.getVelocidade_down());
            updatecontrato.setVelUp(velUpdown.getVelocidade_up());
        }
        return new ResponseEntity<ResumoContratoApi>(updatecontrato, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/contratoapi/{contratoNum}")
    public ResponseEntity<List<ResumoContratoApi>> buscarContratoMaior(@PathVariable("contratoNum") long contratoNum){
        List<ResumoContratoApi> mkContratos = this.contratoRepository.buscarContratoMaior(contratoNum);
        if(mkContratos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ResumoContratoApi>>(mkContratos, HttpStatus.OK);
    }

	

}
