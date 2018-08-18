
SELECT 
P.NOME AS "PRODUTO",
P.PRECO,
C.NOME AS "CATEGORIA"
FROM PRODUTO P
JOIN CATEGORIA C  
JOIN PRODUTO_CATEGORIA PC  ON P.ID =  PC.PRODUTO_ID 
AND C.ID = PC.CATEGORIA_ID
-- ------------------------------
SELECT 
C.NOME AS "CIDADE",
E.NOME AS "ESTADO"
FROM CIDADE C
JOIN ESTADO E ON C.ESTADO_ID = E.ID