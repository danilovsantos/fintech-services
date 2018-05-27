package org.fintech.bank.repository;

import org.fintech.bank.entity.TransacaoFinanceiraEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoFinanceiraRepository extends CrudRepository<TransacaoFinanceiraEntity, Long> {
}
