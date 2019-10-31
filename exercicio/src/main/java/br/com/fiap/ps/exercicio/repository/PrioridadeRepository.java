package br.com.fiap.ps.exercicio.repository;

import br.com.fiap.ps.exercicio.model.Prioridade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrioridadeRepository extends JpaRepository<Prioridade, Integer> {

    List<PrioridadeRepository> findByNivel (int nivel);
}
