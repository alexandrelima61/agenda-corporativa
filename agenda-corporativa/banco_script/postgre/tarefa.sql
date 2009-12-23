CREATE TABLE tb_tarefa (
	tar_id serial NOT NULL,
	age_id integer NOT NULL,
	usu_id integer NOT NULL,
	tar_titulo character varying(70),
	tar_data timestamp,
	tar_local character varying(40),
	tar_prioridade integer,
	tar_descricao character varying(250),
	tar_estado integer,
	tar_ativo boolean NOT NULL,

	CONSTRAINT tb_tarefa_pk 
		PRIMARY KEY (tar_id),
	CONSTRAINT 
		FOREIGN KEY(age_id) REFERENCES tb_agenda(age_id),
	CONSTRAINT 
		FOREIGN KEY(usu_id) REFERENCES tb_usuario(usu_id)
);