CREATE TABLE tb_datas (
  lem_id serial NOT NULL,
  dat_data date,
  CONSTRAINT fk_lem_id FOREIGN KEY (lem_id)
  	REFERENCES tb_lembrete (lem_id) MATCH SIMPLE
  	ON UPDATE NO ACTION ON DELETE NO ACTION
)