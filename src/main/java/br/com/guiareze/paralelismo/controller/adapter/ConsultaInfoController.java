package br.com.guiareze.paralelismo.controller.adapter;

import br.com.guiareze.paralelismo.controller.dto.RetornoConsultaDto;
import br.com.guiareze.paralelismo.core.ports.controller.PesquisaDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultadados")
public class ConsultaInfoController {

    @Autowired
    private PesquisaDados pesquisaDados;

    @GetMapping
    public ResponseEntity<RetornoConsultaDto> consultaDados(){

        var retorno = pesquisaDados.buscarDados();

        return new ResponseEntity<RetornoConsultaDto>(retorno, HttpStatus.OK);

    }

}
