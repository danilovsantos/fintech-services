package org.fintech.bank.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Danilo Valente
 */

@Entity
@Table(name = "TB_TRANSACAO_FIN")
public class TransacaoFinanceiraEntity {

    @Id
    @Column(name = "ID_TRANSACAO_FIN")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODIGO_APORTE")
    private String codigoAporte;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "DATA_TRANSACAO")
    private LocalDate dataTransacao;

    @OneToOne
    @JoinColumn(name = "ID_CONTA_ORIGEM", nullable = false)
    private ContaBancariaEntity contaOrigem;

    @OneToOne
    @JoinColumn(name = "ID_CONTA_DESTINO", nullable = false)
    private ContaBancariaEntity contaDestino;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_TRANS_FIN", nullable = false)
    private TipoTransacaoFinanceiraEntity tipoTansacaoFinanceira;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoAporte() {
        return codigoAporte;
    }

    public void setCodigoAporte(String codigoAporte) {
        this.codigoAporte = codigoAporte;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public ContaBancariaEntity getContaOrigem() {
        return contaOrigem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setContaOrigem(ContaBancariaEntity contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public ContaBancariaEntity getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(ContaBancariaEntity contaDestino) {
        this.contaDestino = contaDestino;
    }

    public TipoTransacaoFinanceiraEntity getTipoTansacaoFinanceira() {
        return tipoTansacaoFinanceira;
    }

    public void setTipoTansacaoFinanceira(TipoTransacaoFinanceiraEntity tipoTansacaoFinanceira) {
        this.tipoTansacaoFinanceira = tipoTansacaoFinanceira;
    }
}
