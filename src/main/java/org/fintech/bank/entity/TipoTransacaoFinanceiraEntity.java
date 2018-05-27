package org.fintech.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "TB_TIPO_TRANSACAO_FIN")
public class TipoTransacaoFinanceiraEntity {

    @Id
    @Column(name = "ID_TIPO_TRANS_FIN")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRICAO", nullable = false, unique = true)
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
