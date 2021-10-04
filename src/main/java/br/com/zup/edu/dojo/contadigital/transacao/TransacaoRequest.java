package br.com.zup.edu.dojo.contadigital.transacao;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class TransacaoRequest {

    @NotBlank @JsonProperty
    private String numeroDaConta;
    @NotBlank @JsonProperty
    private String tipoDaTransacao;
    @NotNull @Positive @JsonProperty
    private BigDecimal valor;

}
