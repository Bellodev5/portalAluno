CREATE TABLE aluno (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    sexo CHAR(1),
    idade INTEGER,
    nota INTEGER,
    perguntas_acertadas INTEGER,
    total_calculos INTEGER
);
