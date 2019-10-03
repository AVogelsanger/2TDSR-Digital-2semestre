package br.com.fiap.aula05.repository;

import br.com.fiap.aula05.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
