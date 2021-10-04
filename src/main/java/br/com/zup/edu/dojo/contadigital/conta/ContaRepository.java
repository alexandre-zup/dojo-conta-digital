package br.com.zup.edu.dojo.contadigital.conta;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
