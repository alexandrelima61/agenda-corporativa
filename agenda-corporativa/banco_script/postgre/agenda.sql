CREATE TABLE tb_agenda (
  age_id serial NOT NULL,
  age_titulo character varying(50),
  age_descricao character varying(200),
  age_ativado boolean NOT NULL,

  CONSTRAINT tb_agenda_pk PRIMARY KEY (age_id)
);

CREATE TABLE tb_agenda_usuario (
	age_usu_id serial NOT NULL,
	age_id integer NOT NULL,
	usu_id integer NOT NULL,

	CONSTRAINT tb_adenda_usuario_pk PRIMARY KEY (age_usu_id),
	CONSTRAINT tb_adenda_usuario_age_fk FOREIGN KEY (age_id)
		REFERENCES tb_agenda (age_id) 
		MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT tb_adenda_usuario_usu_fk FOREIGN KEY (usu_id)
		REFERENCES tb_usuario (usu_id) 
		MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION
);