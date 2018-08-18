--TESTES DE INSERT
insert into Categoria (id, nome) values (null, 'Infomárica');
insert into Categoria (id, nome) values (null, 'Escritório');

-- -------------------------------------------------------------
insert into Produto (id, nome, preco) values (null, 'Computador', 2000.00);
insert into Produto (id, nome, preco) values (null, 'Impressoa', 800.00);
insert into Produto (id, nome, preco) values (null, 'Mouse', 80.00);
-- -------------------------------------------------------------
insert into Produto_Categoria (produto_id, categoria_id) values (1,1);
insert into Produto_Categoria (produto_id, categoria_id) values (2,1);
insert into Produto_Categoria (produto_id, categoria_id) values (3,1);
insert into Produto_Categoria (produto_id, categoria_id) values (2,2);
-- -------------------------------------------------------------
insert into Estado (id, nome) values (null,'Rio de Janeiro');
insert into Estado (id, nome) values (null,'São Paulo');
-- -------------------------------------------------------------
insert into Cidade (id, nome, estado_id) values (null,'São Gonçalo', 1);
insert into Cidade (id, nome, estado_id) values (null,'Rio de Janeiro', 1);
insert into Cidade (id, nome, estado_id) values (null,'Volta Redonda', 1);
insert into Cidade (id, nome, estado_id) values (null,'São Paulo', 2);
insert into Cidade (id, nome, estado_id) values (null,'Campinas', 2);
-- ----------------------------------------------------------------
insert into Cliente (id, nome, email, cpf_ou_cnpj, tipo) values (null,'Luiz Paulo Aureliano',  'lp-32@hotmail.com', '011.689.257-97', 1);
insert into Cliente (id, nome, email, cpf_ou_cnpj, tipo) values (null,'Andréa Aureliano','andrea-aureliano@hotmail.com', '000.000.000-00', 1);
insert into Cliente (id, nome, email, cpf_ou_cnpj, tipo) values (null,'ASM ASSET', 'asm@hotmail.com', '02.678.955/0002-09', 2);
-- ----------------------------------------------------------------
insert into Telefone (cliente_id, telefones) values (1,'9876-76144');
insert into Telefone (cliente_id, telefones) values (2,'9948-09275');
insert into Telefone (cliente_id, telefones) values (3,'NAO DISPONIVEL');
-- -----------------------------------------------------------------
insert into Endereco (id, logradouro, numero, complemento, bairro, cep, cliente_id, cidade_id ) values (null,'Avenida Joaquim Oliveira', '4876', 'casa 02','Boa Vista', '24462-142', 1, 1);
insert into Endereco (id, logradouro, numero, complemento, bairro, cep, cliente_id, cidade_id ) values (null,'Avenida Joaquim Oliveira', '4876', 'casa 02','Boa Vista', '24462-142', 2, 1);
insert into Endereco (id, logradouro, numero, complemento, bairro, cep, cliente_id, cidade_id ) values (null,'Rua 93A', '162', 'Parte','Vila Santa Cecília', '27261-200', 3, 3);
-- ------------------------------------------------------------------



