package br.com.fiap.ps.exercicio.repository;

import br.com.fiap.ps.exercicio.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

    List<Chamado> findByTituloContains (String titulo);

    List<Chamado> findByPrioridade_Codigo (int codigo);
}
