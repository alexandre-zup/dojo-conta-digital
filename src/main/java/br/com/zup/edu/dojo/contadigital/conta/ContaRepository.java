package br.com.zup.edu.dojo.contadigital.conta;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    Optional <Conta> findByIdCliente(UUID idCliente);
}
