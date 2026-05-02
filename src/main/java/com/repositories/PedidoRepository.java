package com.repositories;

import com.domains.Pedido;
import com.domains.enums.StatusPedido;
import com.domains.enums.TipoFrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatus(StatusPedido status);

    List<Pedido> findByTipoFrete(TipoFrete tipoFrete);
}
