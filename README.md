# fintech-services

Tecnologias e Frameworks Utilizados:

- Java 8
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Data Rest
- Hibernate
- ModelMapper
- MySQL
- Swagger UI

### Configurando e Executando o Projeto

Passo a passo sobre como instalar e rodar o projeto.

```
- Instale o banco de dados MySQL.
- Execute o script DDL localizado na pasta "artefatos".
- Execute o script "carga-inicial" localizado na pasta "artefatos".
- Altere o arquivo "application.properties" em "src/main/resources" informando os parâmetros corretos de conexão ao banco.
- Execute o comando "mvn install" no diretório raiz do projeto onde se encontra o arquivo "pom.xml".
- Execute a classe "SpringBootApplication.java" localizada na raiz do pacote "org.fintech.bank".
```

### Acessando Serviços via Swagger

```
exemplo:
http://localhost:8080/swagger-ui.html#
```

### Exemplos Funcionais:

```
(Cadastro de Conta e Pessoa)
http://localhost:8080/api/conta/pessoa-fisica
{
	"idConta": null,
	"idContaPai": null,
        "saldo": 500.00,
        "idTipoConta": 1,
        "idStatusConta": 1,
        "pessoaFisica": {
        "nome": "Fulano da Silva",
        "cpf": 12356987123,
        "idTipoPessoa": 1,
        "dataNascimento": "1986-04-25"
    }
}

{
	"idConta": null,
	"idContaPai": null,
        "saldo": 500.00,
        "idTipoConta": 1,
        "idStatusConta": 1,
        "pessoaFisica": {
        "nome": "Siclano da Silva ",
        "cpf": 12569999999,
        "idTipoPessoa": 1,
        "dataNascimento": "1986-04-25"
    }
}
```

```
Exemplo (Transferencia de valores entre contas Matriz)
http://localhost:8080/api/transacao-financeira
{
  "idTransacao": null,
  "codigoAporte": "KNDID789",
  "descricao": "Transferencia Bancária",
  "idContaOrigem": 5,
  "idContaDestino": 6,
  "idTipoTransacao": 1,
  "valor": 100.00
}

```
```
Exemplo (Estorno de valores)
http://localhost:8080/api/transacao-financeira-estorno/1
```
