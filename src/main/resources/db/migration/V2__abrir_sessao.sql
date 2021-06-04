CREATE TABLE ass_assembleia.ass_sessao (
	id serial NOT NULL,
	pauta_id int8 NOT NULL,
	data_abertura timestamp(0) NOT NULL,
	data_finalizacao timestamp(0) NOT NULL,
	CONSTRAINT ass_sessao_pk PRIMARY KEY (id, pauta_id)
);

ALTER TABLE ass_assembleia.ass_sessao ADD CONSTRAINT ass_sessao_fk FOREIGN KEY (pauta_id) REFERENCES ass_assembleia.ass_pauta(id);