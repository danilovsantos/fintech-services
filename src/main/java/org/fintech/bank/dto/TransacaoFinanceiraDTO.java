package org.fintech.bank.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Danilo Valente
 */

public class TransacaoFinanceiraDTO {

    private Long idTransacao;

    @Digits(integer = 12, fraction = 12, message = "Valor deve conter no máximo 12 dígitos.")
    private BigDecimal valor;
    private String descricao;
    private String codigoAporte;
    private LocalDate dataTransacao;

    @NotNull(message = "ID da conta origem não pode ser Nulo.")
    private Long idContaOrigem;

    @NotNull(message = "ID da conta destino não pode ser Nulo.")
    private Long idContaDestino;

    @NotNull(message = "ID do tipo de transacao não pode ser Nulo.")
    private Long idTipoTransacao;

    public Long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoAporte() {
        return codigoAporte;
    }

    public void setCodigoAporte(String codigoAporte) {
        this.codigoAporte = codigoAporte;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Long getIdContaOrigem() {
        return idContaOrigem;
    }

    public void setIdContaOrigem(Long idContaOrigem) {
        this.idContaOrigem = idContaOrigem;
    }

    public Long getIdContaDestino() {
        return idContaDestino;
    }

    public void setIdContaDestino(Long idContaDestino) {
        this.idContaDestino = idContaDestino;
    }

    public Long getIdTipoTransacao() {
        return idTipoTransacao;
    }

    public void setIdTipoTransacao(Long idTipoTransacao) {
        this.idTipoTransacao = idTipoTransacao;
    }
}
