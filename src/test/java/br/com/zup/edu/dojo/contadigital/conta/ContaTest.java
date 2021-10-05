package br.com.zup.edu.dojo.contadigital.conta;

import br.com.zup.edu.dojo.contadigital.exception.SaldoInsuficienteException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;


class ContaTest {

    @Test
    public void naoDeveRealizarSaqueComSaldoInsuficiente() {
        Conta conta = new Conta("1234", UUID.randomUUID());
        Assertions.assertThrows(SaldoInsuficienteException.class, () -> {
            conta.debita(new BigDecimal("10.0"));
        });
    }
}