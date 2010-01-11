Insert into tb_compromisso (usu_id, age_id, com_titulo, com_local, com_descricao, com_ativo) values(1, 2, 'Reunião DATINF', 'IFRN', 'Calendário 2010', 'true');
Insert into tb_compromisso (usu_id, age_id, com_titulo, com_local, com_descricao, com_ativo) values(3, 1, 'Festa Fim de Ano', 'Hotel', 'Reveillon', 'true');
Insert into tb_compromisso (usu_id, age_id, com_titulo, com_local, com_descricao, com_ativo) values(4, 1, 'Reunião escolar', 'CEI', 'Reajustes de mensalidade', 'true');
Insert into tb_compromisso (usu_id, age_id, com_titulo, com_local, com_descricao, com_ativo) values(1, 2, 'Provas finais', 'Lab 10', 'Marcar data', 'true');

Insert into tb_compromisso_data (com_id, com_dat_datainicio, com_dat_datafim, com_dat_ativo) values(1, '2010-12-01 08:00:00.000', '2010-12-01 12:00:00.000', 'true');
Insert into tb_compromisso_data (com_id, com_dat_datainicio, com_dat_datafim, com_dat_ativo) values(1, '2010-02-01 08:00:00.000', '2010-02-01 12:00:00.000', 'true');
Insert into tb_compromisso_data (com_id, com_dat_datainicio, com_dat_datafim, com_dat_ativo) values(2, '2009-12-31 22:00:00.000', '2009-12-31 12:00:00.000', 'true');
Insert into tb_compromisso_data (com_id, com_dat_datainicio, com_dat_datafim, com_dat_ativo) values(3, '2009-01-20 14:00:00.000', '2009-01-20 16:00:00.000', 'true');
Insert into tb_compromisso_data (com_id, com_dat_datainicio, com_dat_datafim, com_dat_ativo) values(4, '2009-05-01 14:00:00.000', '2009-05-01 16:00:00.000', 'true');

Insert into tb_compromisso_participantes (com_id, usu_id) values(1, 2);
Insert into tb_compromisso_participantes (com_id, usu_id) values(1, 3);
Insert into tb_compromisso_participantes (com_id, usu_id) values(1, 4);
Insert into tb_compromisso_participantes (com_id, usu_id) values(2, 4);
Insert into tb_compromisso_participantes (com_id, usu_id) values(2, 3);
