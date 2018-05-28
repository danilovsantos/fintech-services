package org.fintech.bank.entity;

import javax.persistence.*;

/**
 * @author Danilo Valente
 */

@Entity
@Table(name = "TB_STATUS_CONTA")
public class StatusContaBancariaEntity {

    @Id
    @Column(name = "ID_STATUS_CONTA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRICAO", nullable = false, unique = true)
    private String descricao;

    public StatusContaBancariaEntity(){}

    public StatusContaBancariaEntity(Long id){
        this.id = id;
    }

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
