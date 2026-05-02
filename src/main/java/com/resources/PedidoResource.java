package com.resources;

import com.domains.Pedido;
import com.domains.dtos.PedidoDTO;
import com.services.PedidoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

    private final PedidoService service;

    public PedidoResource(PedidoService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Pedido> criar(
            @Validated(PedidoDTO.Create.class)
            @RequestBody PedidoDTO dto) {

        Pedido pedido = service.criar(dto);
        return ResponseEntity.ok(pedido);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping("/{id}/pagar")
    public ResponseEntity<Void> pagar(@PathVariable Long id) {
        service.pagar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        service.cancelar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/enviar")
    public ResponseEntity<Void> enviar(@PathVariable Long id) {
        service.enviar(id);
        return ResponseEntity.noContent().build();
    }
}
