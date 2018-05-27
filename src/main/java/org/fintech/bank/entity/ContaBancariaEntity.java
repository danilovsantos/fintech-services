package org.fintech.bank.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

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

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PESSOA")
    private PessoaEntity pessoa;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_CONTA")
    private TipoContaBancariaEntity tipoContaEntity;

    @ManyToOne
    @JoinColumn(name = "ID_STATUS_CONTA")
    private StatusContaBancariaEntity statusContaEntity;

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

    public TipoContaBancariaEntity getTipoContaEntity() {
        return tipoContaEntity;
    }

    public void setTipoContaEntity(TipoContaBancariaEntity tipoContaEntity) {
        this.tipoContaEntity = tipoContaEntity;
    }

    public StatusContaBancariaEntity getStatusContaEntity() {
        return statusContaEntity;
    }

    public void setStatusContaEntity(StatusContaBancariaEntity statusContaEntity) {
        this.statusContaEntity = statusContaEntity;
    }

    public ContaBancariaEntity getContaBancariaPai() {
        return contaBancariaPai;
    }

    public void setContaBancariaPai(ContaBancariaEntity contaBancariaPai) {
        this.contaBancariaPai = contaBancariaPai;
    }
}
