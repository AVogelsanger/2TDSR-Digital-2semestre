package br.com.fiap.aula05.repository;

import br.com.fiap.aula05.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeContainsOrCpfContains (String nome, String cpf);
}
