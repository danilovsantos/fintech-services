package org.fintech.bank.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author Danilo Valente
 */

public class PessoaFisicaDTO {

    private Long idPessoa;

    @NotNull(message = "Nome não pode ser Nulo.")
    @Size(min=1, max = 45, message = "Nome deve ter tamanho entre 1 e 45 caracteres.")
    private String nome;

    @NotNull(message = "CPF não pode ser Nulo.")
    @Digits(integer=11, fraction=11, message = "CPF deve conter no máximo 11 dígitos.")
    private Long cpf;

    @NotNull(message = "Data de Nascimento não pode ser Nula.")
    @PastOrPresent(message = "Data de Nascimento deve ser menor ou igual a data atual.")
    private LocalDate dataNascimento;

    @NotNull(message = "Tipo de Pessoa não pode ser Nulo.")
    private Long idTipoPessoa;

    public PessoaFisicaDTO(){}

    public PessoaFisicaDTO(Long idPessoa, String nome, Long cpf, LocalDate dataNascimento){
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getIdTipoPessoa() {
        return idTipoPessoa;
    }

    public void setIdTipoPessoa(Long idTipoPessoa) {
        this.idTipoPessoa = idTipoPessoa;
    }
}
