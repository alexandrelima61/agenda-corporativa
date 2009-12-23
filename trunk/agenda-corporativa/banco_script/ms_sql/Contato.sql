CREATE TABLE tb_contato (
	con_id int IDENTITY(1,1) primary key NOT NULL,
	con_nome varchar(60),
	con_endereco varchar(100),
	con_ativo bit NOT NULL
);

CREATE TABLE tb_contato_telefones (
	con_id int NOT NULL,
	con_telefone varchar(8),
	
	CONSTRAINT tb_contato_tel_fk 
		FOREIGN KEY (con_id)
		REFERENCES tb_contato (con_id),
);

CREATE TABLE tb_contato_emails (
	con_id int NOT NULL,
	con_email varchar(30),
	
	CONSTRAINT tb_contato_email_fk 
		FOREIGN KEY (con_id)
		REFERENCES tb_contato (con_id),
);


CREATE TABLE tb_agenda_contato (
	age_con_id int IDENTITY(1,1) primary key NOT NULL,
	con_id int NOT NULL,
	age_id int NOT NULL,

	CONSTRAINT tb_agenda_contato_age_fk 
		FOREIGN KEY (age_id)
		REFERENCES tb_agenda (age_id),
	CONSTRAINT tb_agenda_contato_con_fk 
		FOREIGN KEY (con_id)
		REFERENCES tb_contato (con_id)
);


//polulação da tb_contato
INSERT INTO tb_contato ( con_id,con_nome, con_endereco,con_ativo)values(1,'Henrique Pinto Paiva', 'Rua Joao Rodrigues, 887', 1);
INSERT INTO tb_contato ( con_id,con_nome, con_endereco,con_ativo)values(2,'Francicso Oliveira', 'Rua da Mangueira , 001', 1);
INSERT INTO tb_contato ( con_id,con_nome, con_endereco,con_ativo)values(3,'João Pereira', 'Rua da Goiabeira, 002', 1);
INSERT INTO tb_contato ( con_id,con_nome, con_endereco,con_ativo)values(4,'Maria Tereza', 'Rua da Mata, 003', 1);
INSERT INTO tb_contato ( con_id,con_nome, con_endereco,con_ativo)values(5,'Beatriz Souto', 'Av. Cap-Mor Gouveia, 004', 1);
INSERT INTO tb_contato ( con_id,con_nome, con_endereco,con_ativo)values(6,'Joaquim Pereira Mata', 'Rua Trairi, 006', 1);
INSERT INTO tb_contato ( con_id,con_nome, con_endereco,con_ativo)values(7,'Dalva Pereira Soares', 'Rua Apodi, 007', 1);
INSERT INTO tb_contato ( con_id,con_nome, con_endereco,con_ativo)values(8,'Daniela Almeida', 'Rua Larga, 009', 1);
INSERT INTO tb_contato ( con_id,con_nome, con_endereco,con_ativo)values(9,'Tereza Vasconcelos', 'Av. Salgado Filho, 1588', 1);
INSERT INTO tb_contato ( con_id,con_nome, con_endereco,con_ativo)values(10,'Mariza Ramos', 'Rua Alcateia, 8975', 1);

//população da tb_contato_telefones
INSERT INTO tb_contato_telefones (con_id, con_telefone)values(1, '3200-0001');
INSERT INTO tb_contato_telefones (con_id, con_telefone)values(2, '3200-0002');
INSERT INTO tb_contato_telefones (con_id, con_telefone)values(3, '3200-0003');
INSERT INTO tb_contato_telefones (con_id, con_telefone)values(4, '3200-0004');
INSERT INTO tb_contato_telefones (con_id, con_telefone)values(5, '3200-0005');
INSERT INTO tb_contato_telefones (con_id, con_telefone)values(8, '3200-0006');
INSERT INTO tb_contato_telefones (con_id, con_telefone)values(9, '3200-0007');
INSERT INTO tb_contato_telefones (con_id, con_telefone)values(5, '3200-0010');
INSERT INTO tb_contato_telefones (con_id, con_telefone)values(5, '3200-0012');
INSERT INTO tb_contato_telefones (con_id, con_telefone)values(8, '3200-0013');
INSERT INTO tb_contato_telefones (con_id, con_telefone)values(7, '3200-0014');


//população da tb_contato_emails

INSERT INTO tb_contato_emails (con_id, con_email)values(1, '001@gmail.com');
INSERT INTO tb_contato_emails (con_id, con_email)values(2, '002@gmail.com');
INSERT INTO tb_contato_emails (con_id, con_email)values(3, '003@gmail.com');
INSERT INTO tb_contato_emails (con_id, con_email)values(4, '004@gmail.com');
INSERT INTO tb_contato_emails (con_id, con_email)values(5, '005@gmail.com');
INSERT INTO tb_contato_emails (con_id, con_email)values(6, '006@gmail.com');
INSERT INTO tb_contato_emails (con_id, con_email)values(2, '022@gmail.com');
INSERT INTO tb_contato_emails (con_id, con_email)values(3, '003@gmail.com');
INSERT INTO tb_contato_emails (con_id, con_email)values(7, '007@gmail.com');
INSERT INTO tb_contato_emails (con_id, con_email)values(8, '008@gmail.com');
INSERT INTO tb_contato_emails (con_id, con_email)values(9, '009@gmail.com');
INSERT INTO tb_contato_emails (con_id, con_email)values(10, '010@gmail.com');
