package com.services.state;

import com.domains.Pedido;
import org.springframework.stereotype.Component;

@Component
public class CanceladoState implements PedidoState {

    @Override
    public void pagar(Pedido pedido) {
        throw new IllegalStateException("Pedido cancelado não pode ser pago");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está cancelado");
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new IllegalStateException("Pedido cancelado não pode ser enviado");
    }
}
