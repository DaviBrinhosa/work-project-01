--INSERT INTO USER_DATA (name, password, email) VALUES ('admin', 'admin123', 'admin@admin.github.com.br');
INSERT INTO USER_DATA (id, name, password, email) VALUES (1, 'admin', 'e2f4f4cb32b69241007752f1cc261863316af9b8376abd29ade6569ec3a0b237c5f7454e6141e9d91217004b6419f4aeoD7ldljD3BDFqiDYgmajJQ==', 'admin@admin.github.com.br');
--INSERT INTO USER_DATA (name, password, email) VALUES ('admin', 'e2f4f4cb32b69241007752f1cc261863316af9b8376abd29ade6569ec3a0b237c5f7454e6141e9d91217004b6419f4aeoD7ldljD3BDFqiDYgmajJQ==', '48ff0baaf8adafaacbe382c34422c60c73948303aa41d4b70a2fe75cad45d450922836d6c620bb2a314786d24208d4acRqoLqM1w+nvavXWF/3S9QxMoZU80QRi4WpdUwGOAZS4=');

INSERT INTO address (id, user_id, building_number, city, complement, district, region, street_address, zip_code) VALUES (1, null, 10, 'São Paulo', 'Apto 101', 'Centro', 'SP', 'Rua A', '12345-678');
INSERT INTO contact (address_id, id, user_id, cellphone, email, name) VALUES (1, 1, 1, '987654321', 'joao.silva@example.com', 'João Silva');

INSERT INTO address (id, user_id, building_number, city, complement, district, region, street_address, zip_code) VALUES (2, null, 20, 'Rio de Janeiro', 'Casa 2', 'Jardins', 'RJ', 'Rua B', '23456-789');
INSERT INTO contact (address_id, id, user_id, cellphone, email, name) VALUES (2, 2, 1, '999888777', 'maria.souza@example.com', 'Maria Souza');

INSERT INTO address (id, user_id, building_number, city, complement, district, region, street_address, zip_code) VALUES (3, null, 30, 'São Paulo', 'Sala 3', 'Vila Mariana', 'SP', 'Rua C', '34567-890');
INSERT INTO contact (address_id, id, user_id, cellphone, email, name) VALUES (3, 3, 1, '555444333', 'pedro.santos@example.com', 'Pedro Santos');

INSERT INTO address (id, user_id, building_number, city, complement, district, region, street_address, zip_code) VALUES (4, null, 40, 'Porto Alegre', 'Loja 4', 'Centro', 'RS', 'Rua D', '45678-901');
INSERT INTO contact (address_id, id, user_id, cellphone, email, name) VALUES (4, 4, 1, '111222333', 'ana.oliveira@example.com', 'Ana Oliveira');

INSERT INTO address (id, user_id, building_number, city, complement, district, region, street_address, zip_code) VALUES (5, null, 50, 'Rio de Janeiro', 'Apto 5', 'Copacabana', 'RJ', 'Rua E', '56789-012');
INSERT INTO contact (address_id, id, user_id, cellphone, email, name) VALUES (5, 5, 1, '777888999', 'lucas.fernandes@example.com', 'Lucas Fernandes');



INSERT INTO address (id, user_id, building_number, city, complement, district, region, street_address, zip_code) VALUES (6, null, 60, 'Rio de Janeiro', 'Casa 6', 'Barra da Tijuca', 'RJ', 'Rua F', '67890-123');

INSERT INTO address (id, user_id, building_number, city, complement, district, region, street_address, zip_code) VALUES (7, null, 70, 'São Paulo', 'Apartamento 7', 'Pinheiros', 'SP', 'Rua G', '78901-234');

INSERT INTO address (id, user_id, building_number, city, complement, district, region, street_address, zip_code) VALUES (8, null, 80, 'Rio de Janeiro', 'Cobertura 8', 'Leblon', 'RJ', 'Rua H', '89012-345');

INSERT INTO address (id, user_id, building_number, city, complement, district, region, street_address, zip_code) VALUES (9, null, 90, 'São Paulo', 'Loja 9', 'Moema', 'SP', 'Rua I', '90123-456');

INSERT INTO address (id, user_id, building_number, city, complement, district, region, street_address, zip_code) VALUES (10, null, 100, 'Rio de Janeiro', 'Casa 10', 'Botafogo', 'RJ', 'Rua J', '01234-567');

INSERT INTO address (id, user_id, building_number, city, complement, district, region, street_address, zip_code) VALUES (11, null, 110, 'São Paulo', 'Sala 11', 'Itaim Bibi', 'SP', 'Rua K', '12345-678');

INSERT INTO address (id, user_id, building_number, city, complement, district, region, street_address, zip_code) VALUES (12, null, 120, 'Rio de Janeiro', 'Apto 12', 'Ipanema', 'RJ', 'Rua L', '23456-789');

INSERT INTO address (id, user_id, building_number, city, complement, district, region, street_address, zip_code) VALUES (13, null, 130, 'São Paulo', 'Sala 13', 'Vila Olímpia', 'SP', 'Rua M', '34567-890');

INSERT INTO address (id, user_id, building_number, city, complement, district, region, street_address, zip_code) VALUES (14, null, 150, 'Rio de Janeiro', 'Casa 15', 'Laranjeiras', 'RJ', 'Rua O', '56789-012');

INSERT INTO address (id, user_id, building_number, city, complement, district, region, street_address, zip_code) VALUES (15, null, 150, 'Rio de Janeiro', 'Casa 15', 'Laranjeiras', 'RJ', 'Rua O', '56789-012');


INSERT INTO contact (address_id, id, user_id, cellphone, email, name) VALUES (6, 6, 1, '333444555', 'mariana.costa@example.com', 'Mariana Costa');
INSERT INTO contact (address_id, id, user_id, cellphone, email, name) VALUES (7, 7, 1, '222333444', 'carlos.silveira@example.com', 'Carlos Silveira');
INSERT INTO contact (address_id, id, user_id, cellphone, email, name) VALUES (8, 8, 1, '666777888', 'ana.lima@example.com', 'Ana Lima');
INSERT INTO contact (address_id, id, user_id, cellphone, email, name) VALUES (9, 9, 1, '999000111', 'jose.santana@example.com', 'José Santana');
INSERT INTO contact (address_id, id, user_id, cellphone, email, name) VALUES (10, 10, 1, '111222333', 'lucas.silva@example.com', 'Lucas Silva');
INSERT INTO contact (address_id, id, user_id, cellphone, email, name) VALUES (11, 11, 1, '333444555', 'maria.martins@example.com', 'Maria Martins');
INSERT INTO contact (address_id, id, user_id, cellphone, email, name) VALUES (12, 12, 1, '555666777', 'jose.rodrigues@example.com', 'José Rodrigues');
INSERT INTO contact (address_id, id, user_id, cellphone, email, name) VALUES (13, 13, 1, '777888999', 'pedro.almeida@example.com', 'Pedro Almeida');
INSERT INTO contact (address_id, id, user_id, cellphone, email, name) VALUES (14, 14, 1, '888999000', 'maria.silva@example.com', 'Maria Silva');
INSERT INTO contact (address_id, id, user_id, cellphone, email, name) VALUES (15, 15, 1, '222333444', 'lucas.rodrigues@example.com', 'Lucas Rodrigues');
