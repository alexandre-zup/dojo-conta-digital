package br.com.zup.edu.dojo.contadigital.transacao;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TransacaoController {

    //criar interface, isolar a lógica
    @PostMapping
    public void creditaConta(@RequestBody @Valid TransacaoRequest request) {

    }

    @PostMapping
    public void debitaConta(@RequestBody @Valid TransacaoRequest request) {

    }

}
