package com.domains;

import com.domains.enums.StatusPedido;
import com.domains.enums.TipoFrete;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pedido")
@SequenceGenerator(name = "seq_pedido", sequenceName = "seq_pedido", allocationSize = 1)
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido")
    private Long id;

    @NotNull(message = "Valor é obrigatório")
    @Positive(message = "Valor deve ser maior que zero")
    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private BigDecimal frete;

    @Convert(converter = com.infra.StatusPedidoConverter.class)
    @Column(nullable = false)
    private StatusPedido status;

    @NotNull(message = "Tipo de frete é obrigatório")
    @Convert(converter = com.infra.TipoFreteConverter.class)
    @Column(nullable = false)
    private TipoFrete tipoFrete;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    private LocalDate criadoEm = LocalDate.now();

    public Pedido() {
        this.valor = new BigDecimal(0);
        this.status = StatusPedido.AGUARDANDO;

    }

    public Pedido(Long id, BigDecimal valor, BigDecimal frete, StatusPedido status, TipoFrete tipoFrete, LocalDate criadoEm) {
        this.id = id;
        this.valor = valor;
        this.frete = frete;
        this.status = status;
        this.tipoFrete = tipoFrete;
        this.criadoEm = criadoEm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getFrete() {
        return frete;
    }

    public void setFrete(BigDecimal frete) {
        this.frete = frete;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public TipoFrete getTipoFrete() {
        return tipoFrete;
    }

    public void setTipoFrete(TipoFrete tipoFrete) {
        this.tipoFrete = tipoFrete;
    }

    public LocalDate getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDate criadoEm) {
        this.criadoEm = criadoEm;
    }
}
