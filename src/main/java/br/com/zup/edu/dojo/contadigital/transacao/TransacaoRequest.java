package br.com.zup.edu.dojo.contadigital.transacao;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class TransacaoRequest {

    @NotBlank
    @JsonProperty
    private String numeroDaConta;
    @NotNull
    @JsonProperty
    private TipoTransacao tipoDaTransacao;
    @NotNull
    @Positive
    @JsonProperty
    private BigDecimal valor;


    public TransacaoRequest(String numeroDaConta, TipoTransacao tipoDaTransacao, BigDecimal valor) {
        this.numeroDaConta = numeroDaConta;
        this.tipoDaTransacao = tipoDaTransacao;
        this.valor = valor;
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public TipoTransacao getTipoDaTransacao() {
        return tipoDaTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
