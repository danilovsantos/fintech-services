package org.fintech.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "TB_TIPO_CONTA")
public class TipoContaBancariaEntity {

    @Id
    @Column(name ="ID_TIPO_CONTA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRICAO", nullable = false, unique = true)
    private String descricao;

    public TipoContaBancariaEntity(){}

    public TipoContaBancariaEntity(Long id){
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
