package br.com.fiap.aula03.repository;

import br.com.fiap.aula03.entity.Gravadora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GravadoraRepository extends JpaRepository<Gravadora, Integer> {

    //Pesquisar a gravadora por nome
    List<Gravadora> findByNomeContains(String nome);

    //Pesquisar por gravadoras pelo atributo internacional
    List<Gravadora> findByInternacional(boolean internacional);

    //Pesquisar por parte do nome e faturamento maior que
    List<Gravadora> findByNomeContainsAndFaturamentoGreaterThan(String nome, double faturamento);


}
