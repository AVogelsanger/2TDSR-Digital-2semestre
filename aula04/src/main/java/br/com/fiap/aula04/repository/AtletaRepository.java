package br.com.fiap.aula04.repository;

import br.com.fiap.aula04.model.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtletaRepository extends JpaRepository<Atleta, Integer> {

    // Pesquisar por parte do nome ignorando case sensitive
    List<Atleta> findByNomeContainsIgnoreCase(String name);

    // Pesquisar os atletas de uma modalidade
    List<Atleta> findByModalidade_Codigo(int codigo);
}
