package onnet.mkapi.domain.resource.rest;

import onnet.mkapi.domain.model.Conexao;
import onnet.mkapi.domain.model.Contrato;
import onnet.mkapi.domain.model.dto.ResumoConexao;
import onnet.mkapi.domain.model.dto.ResumoContratoAtivo;
import onnet.mkapi.domain.model.dto.ResumoContratoSemFidelidade;
import onnet.mkapi.domain.model.dto.TotalSemFidelidade;
import onnet.mkapi.domain.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api/clientes")
public class MkConexaoResource  {



    @Autowired
    private ContratoRepository contrato;


    public ResponseEntity<ResumoContratoSemFidelidade> getContratos(){
        TotalSemFidelidade contratoSemfidelidade = this.contrato.buscarSemFidelidade();
        ResumoContratoAtivo contratoAtivo = this.contrato.buscarContratoAtivo();
        ResumoContratoSemFidelidade contratoSemFidelidadeAtivos = new ResumoContratoSemFidelidade(LocalDate.now(), contratoSemfidelidade.getSemFidelidade(), contratoAtivo.getContratoAtivos());
        if(contratoSemfidelidade == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contratoSemFidelidadeAtivos , HttpStatus.OK);
    }
}

