package org.fintech.bank.mapper;

import org.fintech.bank.dto.TransacaoFinanceiraDTO;
import org.fintech.bank.entity.TransacaoFinanceiraEntity;
import org.springframework.stereotype.Component;

/**
 * @author Danilo Valente
 * Classe responsável pela conversão entre DTO e Entity.
 */

@Component
public class TransacaoFinanceiraMapper {

    public TransacaoFinanceiraDTO parseEntityToDto(TransacaoFinanceiraEntity entity){

        TransacaoFinanceiraDTO dto = new TransacaoFinanceiraDTO();

        dto.setCodigoAporte(entity.getCodigoAporte());
        dto.setDataTransacao(entity.getDataTransacao());
        dto.setDescricao(entity.getDescricao());
        dto.setIdContaDestino(entity.getContaDestino().getId());
        dto.setIdContaOrigem(entity.getContaOrigem().getId());
        dto.setIdTipoTransacao(entity.getTipoTansacaoFinanceira().getId());
        dto.setIdTransacao(entity.getId());
        dto.setValor(entity.getValor());

        return dto;
    }

}
