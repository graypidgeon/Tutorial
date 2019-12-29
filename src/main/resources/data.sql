INSERT INTO house (id, name, description, image_path) VALUES (1, 'Pierwszaczek', 'Niby ladny ale jednak', '1.jpg');
INSERT INTO house (id, name, description, image_path) VALUES (2, 'Dwujniak', 'O chollllera', '2.jpg');
INSERT INTO house (id, name, description, image_path) VALUES (3, 'Ostry', 'Wiadomo jak jest', '3.jpg');
INSERT INTO house (id, name, description, image_path) VALUES (4, 'Dziaslak', 'Osz kurka flaqo', '4.jpg');
INSERT INTO house (id, name, description, image_path) VALUES (5, 'Wigwam', 'Będzie szła tam i tu a potem jeszcze w lewo', '5.jpg');
INSERT INTO house (id, name, description, image_path) VALUES (6, 'Warna', 'Lalo', '6.jpg');
INSERT INTO house (id, name, description, image_path) VALUES (7, 'Sarna', 'Kako', '7.jpg');
INSERT INTO house (id, name, description, image_path) VALUES (8, 'Laszlo', 'Waska', '8.jpg');
INSERT INTO house (id, name, description, image_path) VALUES (9, 'Benek', 'Lelum polelum', '9.jpg');
INSERT INTO house (id, name, description, image_path) VALUES (10, 'Wienio', 'Supcio', '10.jpg');
ALTER SEQUENCE HOUSE_SEQ RESTART WITH 11;

INSERT INTO authority (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authority (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO user (id, username, password) VALUES (1,'ironman','tajne');
INSERT INTO user (id, username, password) VALUES (2,'hulk','poufne');
ALTER SEQUENCE USER_SEQ RESTART WITH 3;

INSERT INTO user_authority (authority_id, user_id) VALUES (1, 1);
INSERT INTO user_authority (authority_id, user_id) VALUES (2, 2);