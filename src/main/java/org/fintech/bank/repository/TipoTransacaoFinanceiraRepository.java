package org.fintech.bank.repository;

import org.fintech.bank.entity.TipoContaBancariaEntity;
import org.springframework.data.repository.CrudRepository;

public interface TipoTransacaoFinanceiraRepository extends CrudRepository<TipoContaBancariaEntity, Long> {
}
