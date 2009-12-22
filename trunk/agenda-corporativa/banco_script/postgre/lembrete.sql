CREATE TABLE tb_lembrete (
  lem_id serial NOT NULL,
  lem_titulo character varying(50),
  lem_corpo character varying(150),
  ativado boolean NOT NULL,
  
  CONSTRAINT tb_lembrete_pk PRIMARY KEY (lem_id)
);

CREATE TABLE tb_lembretes_datas (
  lem_id serial NOT NULL,
  dat_data timestamp,
  CONSTRAINT tb_lembretes_datas_lem_fk FOREIGN KEY (lem_id)
  	REFERENCES tb_lembrete (lem_id) MATCH SIMPLE
  	ON UPDATE NO ACTION ON DELETE NO ACTION
);