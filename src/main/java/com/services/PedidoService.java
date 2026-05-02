package com.services;

import com.domains.Pedido;
import com.domains.dtos.PedidoDTO;
import com.domains.enums.StatusPedido;
import com.repositories.PedidoRepository;
import com.services.state.PedidoState;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;


@Service
public class PedidoService {

        private final Map<StatusPedido, PedidoState> states;
        private final PedidoRepository repository;
        private final FreteService freteService;

        public PedidoService(Map<String, PedidoState> states,
                             PedidoRepository repository,
                             FreteService freteService) {

            this.repository = repository;
            this.freteService = freteService;

            this.states = Map.of(
                    StatusPedido.AGUARDANDO, states.get("aguardandoState"),
                    StatusPedido.PAGO, states.get("pagoState"),
                    StatusPedido.ENVIADO, states.get("enviadoState"),
                    StatusPedido.CANCELADO, states.get("canceladoState")
            );
        }

        public Pedido criar(PedidoDTO dto) {

            Pedido pedido = new Pedido();

            pedido.setValor(dto.getValor());
            pedido.setTipoFrete(dto.getTipoFrete());

            BigDecimal frete = freteService.calcular(
                    dto.getTipoFrete(),
                    dto.getValor()
            );

            pedido.setFrete(frete);
            pedido.setStatus(StatusPedido.AGUARDANDO);
            pedido.setCriadoEm(LocalDate.now());

            return repository.save(pedido);
        }


        public Pedido buscarPorId(Long id) {
            return repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        }

        public void pagar(Long id) {
            Pedido pedido = buscarPorId(id);

            states.get(pedido.getStatus()).pagar(pedido);

            repository.save(pedido);
        }

        public void cancelar(Long id) {
            Pedido pedido = buscarPorId(id);

            states.get(pedido.getStatus()).cancelar(pedido);

            repository.save(pedido);
        }

        public void enviar(Long id) {
            Pedido pedido = buscarPorId(id);

            states.get(pedido.getStatus()).enviar(pedido);

            repository.save(pedido);
        }

}
