INSERT INTO USER_DATA (name, password, email, username, genre, birthdate, user_privilege, status, inactive_date) VALUES ('Administrador do WorkProject01', 'e2f4f4cb32b69241007752f1cc261863316af9b8376abd29ade6569ec3a0b237c5f7454e6141e9d91217004b6419f4aeoD7ldljD3BDFqiDYgmajJQ==', 'admin@workproject01.com.br', 'admin', 'none', '2023-05-01', 'Admin', 'Active', null);
INSERT INTO USER_DATA (name, password, email, username, genre, birthdate, user_privilege, status, inactive_date) VALUES ('Técnico do WorkProject01', 'e2f4f4cb32b69241007752f1cc261863316af9b8376abd29ade6569ec3a0b237c5f7454e6141e9d91217004b6419f4aeoD7ldljD3BDFqiDYgmajJQ==', 'support@workproject01.com.br', 'support', 'none', '2023-05-01', 'Support', 'Active', null);
INSERT INTO USER_DATA (name, password, email, username, genre, birthdate, user_privilege, status, inactive_date) VALUES ('Cliente Teste do WorkProject01', 'e2f4f4cb32b69241007752f1cc261863316af9b8376abd29ade6569ec3a0b237c5f7454e6141e9d91217004b6419f4aeoD7ldljD3BDFqiDYgmajJQ==', 'clienttest@workproject01.com.br', 'clienttest', 'none', '2023-05-01', 'Client', 'Active', null);

INSERT INTO ADDRESS (user_id, building_number, city, complement, district, region, street_ADDRESS, zip_code) VALUES (null, 10, 'São Paulo', 'Apto 101', 'Centro', 'SP', 'Rua A', '12345-678');
INSERT INTO CONTACT (ADDRESS_id, user_id, cellphone, email, name) VALUES (1, 1, '(91)98765-4321', 'joao.silva@example.com', 'João Silva');

INSERT INTO ADDRESS (user_id, building_number, city, complement, district, region, street_ADDRESS, zip_code) VALUES (null, 20, 'Rio de Janeiro', 'Casa 2', 'Jardins', 'RJ', 'Rua B', '23456-789');
INSERT INTO CONTACT (ADDRESS_id, user_id, cellphone, email, name) VALUES (2, 1, '(91)99988-8777', 'maria.souza@example.com', 'Maria Souza');

INSERT INTO ADDRESS (user_id, building_number, city, complement, district, region, street_ADDRESS, zip_code) VALUES (null, 30, 'São Paulo', 'Sala 3', 'Vila Mariana', 'SP', 'Rua C', '34567-890');
INSERT INTO CONTACT (ADDRESS_id, user_id, cellphone, email, name) VALUES (3, 1, '(51)95544-4333', 'pedro.santos@example.com', 'Pedro Santos');

INSERT INTO ADDRESS (user_id, building_number, city, complement, district, region, street_ADDRESS, zip_code) VALUES (null, 40, 'Porto Alegre', 'Loja 4', 'Centro', 'RS', 'Rua D', '45678-901');
INSERT INTO CONTACT (ADDRESS_id, user_id, cellphone, email, name) VALUES (4, 1, '(11)91122-2333', 'ana.oliveira@example.com', 'Ana Oliveira');

INSERT INTO ADDRESS (user_id, building_number, city, complement, district, region, street_ADDRESS, zip_code) VALUES (null, 50, 'Rio de Janeiro', 'Apto 5', 'Copacabana', 'RJ', 'Rua E', '56789-012');
INSERT INTO CONTACT (ADDRESS_id, user_id, cellphone, email, name) VALUES (5, 1, '(71)97788-8999', 'lucas.fernandes@example.com', 'Lucas Fernandes');

INSERT INTO ADDRESS (user_id, building_number, city, complement, district, region, street_ADDRESS, zip_code) VALUES (null, 60, 'Rio de Janeiro', 'Casa 6', 'Barra da Tijuca', 'RJ', 'Rua F', '67890-123');
INSERT INTO CONTACT (ADDRESS_id, user_id, cellphone, email, name) VALUES (6, 1, '(31)93344-4555', 'mariana.costa@example.com', 'Mariana Costa');

INSERT INTO ADDRESS (user_id, building_number, city, complement, district, region, street_ADDRESS, zip_code) VALUES (null, 70, 'São Paulo', 'Apartamento 7', 'Pinheiros', 'SP', 'Rua G', '78901-234');
INSERT INTO CONTACT (ADDRESS_id, user_id, cellphone, email, name) VALUES (7, 1, '(21)92233-3444', 'carlos.silveira@example.com', 'Carlos Silveira');

INSERT INTO ADDRESS (user_id, building_number, city, complement, district, region, street_ADDRESS, zip_code) VALUES (null, 80, 'Rio de Janeiro', 'Cobertura 8', 'Leblon', 'RJ', 'Rua H', '89012-345');
INSERT INTO CONTACT (ADDRESS_id, user_id, cellphone, email, name) VALUES (8, 1, '(61)96677-7888', 'ana.lima@example.com', 'Ana Lima');

INSERT INTO ADDRESS (user_id, building_number, city, complement, district, region, street_ADDRESS, zip_code) VALUES (null, 90, 'São Paulo', 'Loja 9', 'Moema', 'SP', 'Rua I', '90123-456');
INSERT INTO CONTACT (ADDRESS_id, user_id, cellphone, email, name) VALUES (9, 1, '(91)99900-0111', 'jose.santana@example.com', 'José Santana');

INSERT INTO ADDRESS (user_id, building_number, city, complement, district, region, street_ADDRESS, zip_code) VALUES (null, 100, 'Rio de Janeiro', 'Casa 10', 'Botafogo', 'RJ', 'Rua J', '01234-567');
INSERT INTO CONTACT (ADDRESS_id, user_id, cellphone, email, name) VALUES (10, 1, '(11)91122-2333', 'lucas.silva@example.com', 'Lucas Silva');

INSERT INTO ADDRESS (user_id, building_number, city, complement, district, region, street_ADDRESS, zip_code) VALUES (null, 110, 'São Paulo', 'Sala 11', 'Itaim Bibi', 'SP', 'Rua K', '12345-678');
INSERT INTO CONTACT (ADDRESS_id, user_id, cellphone, email, name) VALUES (11, 1, '(31)93344-4555', 'maria.martins@example.com', 'Maria Martins');

INSERT INTO ADDRESS (user_id, building_number, city, complement, district, region, street_ADDRESS, zip_code) VALUES (null, 120, 'Rio de Janeiro', 'Apto 12', 'Ipanema', 'RJ', 'Rua L', '23456-789');
INSERT INTO CONTACT (ADDRESS_id, user_id, cellphone, email, name) VALUES (12, 1, '(51)95566-6777', 'jose.rodrigues@example.com', 'José Rodrigues');

INSERT INTO ADDRESS (user_id, building_number, city, complement, district, region, street_ADDRESS, zip_code) VALUES (null, 130, 'São Paulo', 'Sala 13', 'Vila Olímpia', 'SP', 'Rua M', '34567-890');
INSERT INTO CONTACT (ADDRESS_id, user_id, cellphone, email, name) VALUES (13, 1, '(71)97788-8999', 'pedro.almeida@example.com', 'Pedro Almeida');

INSERT INTO ADDRESS (user_id, building_number, city, complement, district, region, street_ADDRESS, zip_code) VALUES (null, 150, 'Rio de Janeiro', 'Casa 15', 'Laranjeiras', 'RJ', 'Rua O', '56789-012');
INSERT INTO CONTACT (ADDRESS_id, user_id, cellphone, email, name) VALUES (14, 1, '(81)98899-9000', 'maria.silva@example.com', 'Maria Silva');

INSERT INTO ADDRESS (user_id, building_number, city, complement, district, region, street_ADDRESS, zip_code) VALUES (null, 150, 'Rio de Janeiro', 'Casa 15', 'Laranjeiras', 'RJ', 'Rua O', '56789-012');
INSERT INTO CONTACT (ADDRESS_id, user_id, cellphone, email, name) VALUES (15, 1, '(21)92233-3444', 'lucas.rodrigues@example.com', 'Lucas Rodrigues');
