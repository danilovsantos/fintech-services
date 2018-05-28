package org.fintech.bank.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Danilo Valente
 */

@Entity
@Table(name = "TB_CONTA")
public class ContaBancariaEntity {

    @Id
    @Column(name = "ID_CONTA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SALDO")
    private BigDecimal saldo;

    @Column(name = "DATA_CRIACAO", nullable = false)
    private LocalDate dataCriacao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PESSOA")
    private PessoaEntity pessoa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_TIPO_CONTA")
    private TipoContaBancariaEntity tipoContaBancaria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_STATUS_CONTA")
    private StatusContaBancariaEntity statusContaBancaria;

    @ManyToOne
    @JoinColumn(name = "ID_CONTA_PAI")
    private ContaBancariaEntity contaBancariaPai;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public PessoaEntity getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaEntity pessoa) {
        this.pessoa = pessoa;
    }

    public TipoContaBancariaEntity getTipoContaBancaria() {
        return tipoContaBancaria;
    }

    public void setTipoContaBancaria(TipoContaBancariaEntity tipoContaBancaria) {
        this.tipoContaBancaria = tipoContaBancaria;
    }

    public StatusContaBancariaEntity getStatusContaBancaria() {
        return statusContaBancaria;
    }

    public void setStatusContaBancaria(StatusContaBancariaEntity statusContaBancaria) {
        this.statusContaBancaria = statusContaBancaria;
    }

    public ContaBancariaEntity getContaBancariaPai() {
        return contaBancariaPai;
    }

    public void setContaBancariaPai(ContaBancariaEntity contaBancariaPai) {
        this.contaBancariaPai = contaBancariaPai;
    }
}
