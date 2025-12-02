CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE emprestimo
(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,

    idLivro VARCHAR(13) NOT NULL,
    idUsuario VARCHAR(50) NOT NULL,
    dtIncEmprestimo   DATE NOT NULL,
    dtDevlcEmprestimo DATE NOT NULL,
    dataRealDevolucao DATE
);