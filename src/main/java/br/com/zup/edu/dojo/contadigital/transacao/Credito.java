package br.com.zup.edu.dojo.contadigital.transacao;

import br.com.zup.edu.dojo.contadigital.conta.Conta;

import java.math.BigDecimal;

public class Credito implements Transacao {
    @Override
    public void executa(Conta conta, BigDecimal valor) {
        conta.credita(valor);
    }
}
