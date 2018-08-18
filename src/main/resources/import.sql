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

