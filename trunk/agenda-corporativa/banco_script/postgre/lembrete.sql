CREATE TABLE tb_lembrete (
  lem_id serial NOT NULL,
  lem_titulo character varying(50),
  lem_corpo character varying(150),
  CONSTRAINT pk_lem_id PRIMARY KEY (lem_id)
)
