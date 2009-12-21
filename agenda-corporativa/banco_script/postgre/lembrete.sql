CREATE TABLE tb_lembrete (
  lem_id serial NOT NULL,
  lem_titulo character varying(50),
  lem_corpo character varying(150),
  CONSTRAINT pk_lem_id PRIMARY KEY (lem_id)
)

CREATE TABLE tb_lembretes_datas (
  lem_id serial NOT NULL,
  dat_data date,
  CONSTRAINT fk_lem_id FOREIGN KEY (lem_id)
  	REFERENCES tb_lembrete (lem_id) MATCH SIMPLE
  	ON UPDATE NO ACTION ON DELETE NO ACTION
)