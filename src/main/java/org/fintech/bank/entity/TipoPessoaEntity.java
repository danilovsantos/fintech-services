package org.fintech.bank.entity;

import javax.persistence.*;

/**
 * @author Danilo Valente
 */

@Entity
@Table(name = "TB_TIPO_PESSOA")
public class TipoPessoaEntity {

    @Id
    @Column(name ="ID_TIPO_PESSOA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRICAO", nullable = false, unique = true)
    private String descricao;

    public TipoPessoaEntity(){}

    public TipoPessoaEntity(Long id){
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
