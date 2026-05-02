package com.services.state;

import com.domains.Pedido;
import org.springframework.stereotype.Component;

@Component
public class EnviadoState implements PedidoState {

    @Override
    public void pagar(Pedido pedido) {
        throw new IllegalStateException("Pedido já foi enviado");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido enviado não pode ser cancelado");
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new IllegalStateException("Pedido já foi enviado");
    }
}
