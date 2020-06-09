package onnet.mkapi.domain.resource;

import onnet.mkapi.domain.model.dto.OsAgendaDTO;
import onnet.mkapi.domain.repository.CompromissoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/compromissos")
public class CompromissoResource {

    @Autowired
    private CompromissoRepository compromissoRepository;


    @CrossOrigin(origins = "*")
    @GetMapping(path = "/os/agendas")
    public ResponseEntity<List<OsAgendaDTO>> dashboardData(){
        LocalDateTime dataAtual = LocalDateTime.now();
        List<OsAgendaDTO> osAgendadaList = this.compromissoRepository.searchOsAgendaList();
        osAgendadaList.forEach(compromisso -> {
            if (compromisso.getDeslocamentoIniciado().equals("S") && compromisso.getAtendimentoIniciado().equals("N"))
                compromisso.setColor("#696969");
            if (compromisso.getAtendimentoIniciado().equals("S") && compromisso.getServicoRealizado().equals("N") && compromisso.getFinalizadoPeloTecnico().equals("N"))
                compromisso.setColor("#40e0d0");
            if (compromisso.getServicoRealizado().equals("S") || compromisso.getFinalizadoPeloTecnico().equals("S")) {
                compromisso.setColor("#2ecc71");
                compromisso.setAtendimentoAtrasado("N");
            }
            if (LocalDateTime.now().isAfter(compromisso.getEnd()) && compromisso.getFinalizadoPeloTecnico().equals("N") && compromisso.getServicoRealizado().equals("N")) {
                compromisso.setColor("#e74c3c");
                compromisso.setAtendimentoAtrasado("S");
            }
            if (compromisso.getUltimoStatus() == null) {
                compromisso.setUltimoStatus("");
            } else if (compromisso.getDescricaoUltimoStatus().equals("Atividade encerrada sem solução.")) {
                    compromisso.setColor("#f1c40f");
        }
    });
    if (osAgendadaList.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
    return new ResponseEntity(osAgendadaList, HttpStatus.OK);
    }
}
