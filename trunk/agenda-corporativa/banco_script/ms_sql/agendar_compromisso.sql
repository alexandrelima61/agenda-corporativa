
CREATE TABLE tb_compromisso(
	com_id int IDENTITY(1,1) primary key NOT NULL,
	usu_id int NOT NULL,
	age_id int NOT NULL,
	com_titulo varchar(50) NULL,
	com_local varchar(50) NULL,
	com_descricao varchar(200) NULL,
	com_ativo bit NULL,
	

	CONSTRAINT fk_com_usu_id FOREIGN KEY (usu_id)
    REFERENCES tb_usuario(usu_id),
	CONSTRAINT fk_com_age_id FOREIGN KEY (age_id)
    REFERENCES tb_agenda(age_id)
    )



CREATE TABLE tb_compromisso_data(
	dat_id int IDENTITY(1,1) primary key NOT NULL,
	com_id int NOT NULL,
	dat_datainicio Datetime NULL,
	dat_datafim Datetime NULL,
	com_ativo bit NULL,
	CONSTRAINT fk_dat_com FOREIGN KEY (com_id)
    REFERENCES tb_dat_com(com_id)
    )