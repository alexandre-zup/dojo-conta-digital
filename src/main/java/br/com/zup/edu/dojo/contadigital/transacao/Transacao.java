package br.com.zup.edu.dojo.contadigital.transacao;

import br.com.zup.edu.dojo.contadigital.conta.Conta;

import java.math.BigDecimal;

public interface Transacao {
    void executa(Conta conta, BigDecimal valor);
}
