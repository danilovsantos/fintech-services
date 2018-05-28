package org.fintech.bank.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Danilo Valente
 */

public class PessoaJuridicaDTO {

    private Long idPessoa;

    @NotNull(message = "CNPJ não pode ser Nulo.")
    @Digits(integer = 15, fraction = 15, message = "CNPJ deve conter no máximo 15 dígitos.")
    private Long CNPJ;

    @NotNull(message = "Razão Social não pode ser Nula.")
    @Size(max = 45, message = "Razão Social deve conter no máximo 45 caracteres.")
    private String razaoSocial;

    @NotNull(message = "Nome Fantasia não pode ser Nulo.")
    @Size(max = 45, message = "Nome Fantasia deve conter no máximo 45 caracteres.")
    private String nomeFantasia;

    @NotNull(message = "ID do Tipo de Conta não pode ser Nulo.")
    private Long idTipoPessoa;

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Long getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(Long CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Long getIdTipoPessoa() {
        return idTipoPessoa;
    }

    public void setIdTipoPessoa(Long idTipoPessoa) {
        this.idTipoPessoa = idTipoPessoa;
    }
}
