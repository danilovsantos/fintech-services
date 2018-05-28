package org.fintech.bank.repository;

import org.fintech.bank.entity.PessoaEntity;
import org.springframework.data.repository.CrudRepository;
/**
 * @author Danilo Valente
 */
public interface PessoaRespository extends CrudRepository<PessoaEntity, Long> {

}
