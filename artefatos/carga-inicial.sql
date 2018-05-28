insert into tb_status_conta (descricao) values("Ativa");
insert into tb_status_conta (descricao) values("Bloqueada");
insert into tb_status_conta (descricao) values("Cancelada");

insert into tb_tipo_pessoa (descricao) values("Física");
insert into tb_tipo_pessoa (descricao) values("Jurídica");

insert into tb_tipo_conta (descricao) values("Matriz");
insert into tb_tipo_conta (descricao) values("Filial");

insert into tb_tipo_transacao_fin (descricao) values("Transferência");
insert into tb_tipo_transacao_fin (descricao) values("Estorno");
commit;
