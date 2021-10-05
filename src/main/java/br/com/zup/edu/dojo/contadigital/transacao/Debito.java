package br.com.zup.edu.dojo.contadigital.transacao;

import br.com.zup.edu.dojo.contadigital.conta.Conta;

import java.math.BigDecimal;

public class Debito implements Transacao {

    @Override
    public void executa(Conta conta, BigDecimal valor) {
        conta.debita(valor);
    }
}
