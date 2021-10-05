package br.com.zup.edu.dojo.contadigital.conta;

import br.com.zup.edu.dojo.contadigital.exception.SaldoInsuficienteException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Conta {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String numero;
    @NotNull
    @PositiveOrZero
    private BigDecimal saldo = BigDecimal.ZERO;
    @NotNull
    private UUID idCliente;

    @Deprecated
    public Conta() {
    }

    public Conta(String numero, UUID idCliente) {
        this.numero = numero;
        this.idCliente = idCliente;
    }

    public void credita(@NotNull @Positive BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }

    public void debita(@NotNull @Positive BigDecimal valor) {
        if (this.saldo.compareTo(valor) < 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        this.saldo = this.saldo.subtract(valor);
    }
}
