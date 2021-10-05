package br.com.zup.edu.dojo.contadigital.transacao;

import br.com.zup.edu.dojo.contadigital.conta.Conta;
import br.com.zup.edu.dojo.contadigital.conta.ContaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.net.URI;
import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
class TransacaoControllerTest {

    private UUID idCliente = UUID.randomUUID();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ContaRepository contaRepository;

    @Test
    public void deveRealizarCreditoComSucessoERetornar200() throws Exception {

        Conta conta = new Conta("1234", idCliente);
        contaRepository.save(conta);
        URI uri = new URI("/api/conta/" + idCliente + "/transacao");

        TransacaoRequest transacaoRequest = new TransacaoRequest("1234", TipoTransacao.CREDITO, new BigDecimal("100.0"));
        String request = objectMapper.writeValueAsString(transacaoRequest);
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    public void naoDeveRealizarCreditoComIdClienteInexistenteEDeveRetornar404() throws Exception {

        URI uri = new URI("/api/conta/" + idCliente + "/transacao");
        TransacaoRequest transacaoRequest = new TransacaoRequest("1234", TipoTransacao.CREDITO, new BigDecimal("100.0"));
        String request = objectMapper.writeValueAsString(transacaoRequest);
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is(404));
    }

    @Test
    public void naoDeveRealizarCreditoComValorNegativoEDeveRetornar400() throws Exception {

        Conta conta = new Conta("1234", idCliente);
        contaRepository.save(conta);
        URI uri = new URI("/api/conta/" + idCliente + "/transacao");
        TransacaoRequest transacaoRequest = new TransacaoRequest("1234", TipoTransacao.CREDITO, new BigDecimal("-100.0"));
        String request = objectMapper.writeValueAsString(transacaoRequest);
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    public void naoDeveRealizarCreditoComIdClienteFormatoInvalidoEDeveRetornar400() throws Exception {

        URI uri = new URI("/api/conta/abc1234/transacao");
        TransacaoRequest transacaoRequest = new TransacaoRequest("1234", TipoTransacao.CREDITO, new BigDecimal("100.0"));
        String request = objectMapper.writeValueAsString(transacaoRequest);
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    public void deveRealizarDebitoComSucessoEDeveRetornar200() throws Exception {

        Conta conta = new Conta("1234", idCliente);
        conta.credita(new BigDecimal("100.0"));
        contaRepository.save(conta);
        URI uri = new URI("/api/conta/" + idCliente + "/transacao");
        TransacaoRequest transacaoRequest = new TransacaoRequest("1234", TipoTransacao.DEBITO, new BigDecimal("10.0"));
        String request = objectMapper.writeValueAsString(transacaoRequest);
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    public void naoDeveRealizarDebitoComSaldoInsuficienteEDeveRetornar422() throws Exception {

        Conta conta = new Conta("1234", idCliente);
        conta.credita(new BigDecimal("100.0"));
        contaRepository.save(conta);
        URI uri = new URI("/api/conta/" + idCliente + "/transacao");
        TransacaoRequest transacaoRequest = new TransacaoRequest("1234", TipoTransacao.DEBITO, new BigDecimal("1000.0"));
        String request = objectMapper.writeValueAsString(transacaoRequest);
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is(422));
    }

}