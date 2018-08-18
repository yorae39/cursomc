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
insert into Cidade (id, nome, estado_id) values (null,'São Paulo', 2);
insert into Cidade (id, nome, estado_id) values (null,'Campinas', 2);
-- ----------------------------------------------------------------


