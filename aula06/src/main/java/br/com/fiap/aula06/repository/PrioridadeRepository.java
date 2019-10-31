package br.com.fiap.aula06.repository;

import br.com.fiap.aula06.model.Prioridade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrioridadeRepository extends JpaRepository<Prioridade, Integer> {

    // buscar por nível
    List<Prioridade> findByNivel(int nivel);

}
