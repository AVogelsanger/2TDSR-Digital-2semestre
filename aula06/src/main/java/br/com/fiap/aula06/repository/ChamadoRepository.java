package br.com.fiap.aula06.repository;

import br.com.fiap.aula06.model.Chamado;
import br.com.fiap.aula06.model.Prioridade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

    // Buscar por parte do título
    List<Chamado> findByTituloContains(String titulo);

    // Buscar por código da prioridade
    List<Prioridade> findByPrioridade_Codigo(int codigoPrioridade);

}
