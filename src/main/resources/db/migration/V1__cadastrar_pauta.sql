CREATE SCHEMA ass_assembleia AUTHORIZATION unicred;

CREATE TABLE ass_assembleia.ass_pauta (
	id serial NOT NULL,
	descricao varchar(255) NULL,
	nome varchar(100) NOT NULL,
	CONSTRAINT ass_pauta_pk PRIMARY KEY (id)
);