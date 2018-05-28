package org.fintech.bank.repository;

import org.fintech.bank.entity.TransacaoFinanceiraEntity;
import org.springframework.data.repository.CrudRepository;
/**
 * @author Danilo Valente
 */
public interface TransacaoFinanceiraRepository extends CrudRepository<TransacaoFinanceiraEntity, Long> {
}
