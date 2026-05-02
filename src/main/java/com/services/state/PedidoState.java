package com.services.state;

import com.domains.Pedido;

public interface PedidoState {

    void pagar(Pedido pedido);

    void cancelar(Pedido pedido);

    void enviar(Pedido pedido);
}
