package br.com.agls.pizzariafuturoDev.Model.Repository;

import br.com.agls.pizzariafuturoDev.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
