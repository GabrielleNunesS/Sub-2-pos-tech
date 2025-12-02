CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE usuario
(
    email        VARCHAR(50) PRIMARY KEY,
    nome         VARCHAR(100) NOT NULL,
    telefone    VARCHAR(15) NOT NULL
);