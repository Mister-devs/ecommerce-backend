package com.services.state;

import com.domains.Pedido;
import com.domains.enums.StatusPedido;
import org.springframework.stereotype.Component;

@Component
public class PagoState implements PedidoState {

    @Override
    public void pagar(Pedido pedido) {
        throw new IllegalStateException("Pedido já foi pago");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido pago não pode ser cancelado");
    }

    @Override
    public void enviar(Pedido pedido) {
        pedido.setStatus(StatusPedido.ENVIADO);
    }
}
