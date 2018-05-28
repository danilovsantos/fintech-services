package org.fintech.bank.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Danilo Valente
 */

public abstract class ContaPessoaDTO {

    private Long idConta;
    private Long idContaPai;

    @NotNull(message = "Tipo de conta não informado.")
    private Long idTipoConta;

    private LocalDate dataCriacao;

    @NotNull
    @Digits(integer = 12, fraction = 12, message = "Saldo ultrapassou valor máximo de 12 dígitos.")
    private BigDecimal saldo;

    @NotNull(message = "Status da conta não pode ser Nulo.")
    private Long idStatusConta;

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public Long getIdContaPai() {
        return idContaPai;
    }

    public void setIdContaPai(Long idContaPai) {
        this.idContaPai = idContaPai;
    }

    public Long getIdTipoConta() {
        return idTipoConta;
    }

    public void setIdTipoConta(Long idTipoConta) {
        this.idTipoConta = idTipoConta;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Long getIdStatusConta() {
        return idStatusConta;
    }

    public void setIdStatusConta(Long idStatusConta) {
        this.idStatusConta = idStatusConta;
    }
}
