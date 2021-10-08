package br.com.zup.edu.dojo.contadigital.transacao;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class TransacaoRequest {

    @NotBlank
    @JsonProperty
    private String numeroConta;
    @NotNull
    @JsonProperty
    private TipoTransacao tipoDaTransacao;
    @NotNull
    @Positive
    @JsonProperty
    private BigDecimal valor;


    public TransacaoRequest(String numeroConta, TipoTransacao tipoDaTransacao, BigDecimal valor) {
        this.numeroConta = numeroConta;
        this.tipoDaTransacao = tipoDaTransacao;
        this.valor = valor;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public TipoTransacao getTipoDaTransacao() {
        return tipoDaTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
