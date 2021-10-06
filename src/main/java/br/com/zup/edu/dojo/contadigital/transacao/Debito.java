package br.com.zup.edu.dojo.contadigital.transacao;

import br.com.zup.edu.dojo.contadigital.conta.Conta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Debito implements Transacao {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Override
    public void executa(Conta conta, BigDecimal valor) {
        logger.info("Nova transação de Débito realizada.");
        conta.debita(valor);
    }
}
