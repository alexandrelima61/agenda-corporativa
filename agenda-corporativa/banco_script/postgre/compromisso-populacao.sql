INSERT INTO tb_compromisso(usu_id, age_id, com_titulo, com_local, com_descricao, com_ativo)
    VALUES (1, 1, 'Reunião DATINF', 'IFRN', 'Calendário 2010', 'true');
    
INSERT INTO tb_compromisso(usu_id, age_id, com_titulo, com_local, com_descricao, com_ativo)
    VALUES (1, 1, 'Festa Fim de Ano', 'Hotel', 'Reveillon', 'true');

INSERT INTO tb_compromisso(usu_id, age_id, com_titulo, com_local, com_descricao, com_ativo)
    VALUES (1, 1, 'Reunião escolar', 'CEI', 'Reajustes de mensalidade', 'true');

INSERT INTO tb_compromisso(usu_id, age_id, com_titulo, com_local, com_descricao, com_ativo)
    VALUES (1, 1, 'Férias', 'Casa', 'Escolher destino da viagem', 'true');

INSERT INTO tb_compromisso(usu_id, age_id, com_titulo, com_local, com_descricao, com_ativo)
    VALUES (1, 1, 'Provas finais', 'Lab 10', 'Marcar data', 'true');

INSERT INTO tb_compromisso_data(com_id, com_dat_datainicio, com_dat_datafim, com_dat_ativo)
    VALUES (1, '2009-01-11 09:00:00.000', '2009-02-11 11:00:00.000', 'true');

INSERT INTO tb_compromisso_data(com_id, com_dat_datainicio, com_dat_datafim, com_dat_ativo)
    VALUES (2, '2009-03-12 22:00:00.000', '2010-01-01 12:00:00.000', 'true');

INSERT INTO tb_compromisso_data(com_id, com_dat_datainicio, com_dat_datafim, com_dat_ativo)
    VALUES (3, '2010-12-01 08:00:00.000', '2010-12-01 12:00:00.000', 'true');

INSERT INTO tb_compromisso_data(com_id, com_dat_datainicio, com_dat_datafim, com_dat_ativo)
    VALUES (3, '2010-04-01 08:00:00.000', '2010-05-01 12:00:00.000', 'true');

INSERT INTO tb_compromisso_data(com_id, com_dat_datainicio, com_dat_datafim, com_dat_ativo)
    VALUES (3, '2010-02-01 08:00:00.000', '2010-02-01 12:00:00.000', 'true');

INSERT INTO tb_compromisso_participantes(com_id, usu_id)
    VALUES (1, 2);
    
INSERT INTO tb_compromisso_participantes(com_id, usu_id)
    VALUES (1, 3);
    
INSERT INTO tb_compromisso_participantes(com_id, usu_id)
    VALUES (1, 4);

INSERT INTO tb_compromisso_participantes(com_id, usu_id)
    VALUES (2, 4);

INSERT INTO tb_compromisso_participantes(com_id, usu_id)
    VALUES (2, 3);
