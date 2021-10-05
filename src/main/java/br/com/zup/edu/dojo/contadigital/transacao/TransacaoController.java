package br.com.zup.edu.dojo.contadigital.transacao;

import br.com.zup.edu.dojo.contadigital.conta.Conta;
import br.com.zup.edu.dojo.contadigital.conta.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/conta")
public class TransacaoController {

    @Autowired
    private ContaRepository contaRepository;

    @PostMapping("/{idCliente}/transacao")
    @Transactional
    public ResponseEntity<?> creditaConta(@PathVariable UUID idCliente, @RequestBody @Valid TransacaoRequest request) {

        Optional<Conta> conta = contaRepository.findByIdCliente(idCliente);
        if (conta.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado pelo id.");
        Transacao transacao = request.getTipoDaTransacao().getTransacao();
        transacao.executa(conta.get(), request.getValor());
        return ResponseEntity.ok().build();
    }

}
