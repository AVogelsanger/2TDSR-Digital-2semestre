package br.com.fiap.aula04.repository;

import br.com.fiap.aula04.model.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModalidadeRepository extends JpaRepository<Modalidade, Integer> {
}
