package com.services.state;

import com.domains.Pedido;
import com.domains.enums.StatusPedido;
import org.springframework.stereotype.Component;

@Component
public class AguardandoState implements PedidoState {

    @Override
    public void pagar(Pedido pedido) {
        pedido.setStatus(StatusPedido.PAGO);
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setStatus(StatusPedido.CANCELADO);
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new IllegalStateException("Pedido precisa ser pago antes de enviar");
    }
}
