INSERT INTO house (id, name, description, image_path, usage_area, width, height) VALUES (1, 'Pierwszaczek', 'Niby ladny ale jednak', '1.jpg', 62, 8, 9);
INSERT INTO house (id, name, description, image_path, usage_area, width, height) VALUES (2, 'Dwujniak', 'O chollllera', '2.jpg', 86, 11, 8);
INSERT INTO house (id, name, description, image_path, usage_area, width, height) VALUES (3, 'Ostry', 'Wiadomo jak jest', '3.jpg', 130, 11, 15);
INSERT INTO house (id, name, description, image_path, usage_area, width, height) VALUES (4, 'Dziaslak', 'Osz kurka flaqo', '4.jpg', 122, 9, 15);
INSERT INTO house (id, name, description, image_path, usage_area, width, height) VALUES (5, 'Wigwam', 'Będzie szła tam i tu a potem jeszcze w lewo', '5.jpg', 74, 8, 11);
INSERT INTO house (id, name, description, image_path, usage_area, width, height) VALUES (6, 'Warna', 'Lalo', '6.jpg', 90, 12, 12);
INSERT INTO house (id, name, description, image_path, usage_area, width, height) VALUES (7, 'Sarna', 'Kako', '7.jpg', 88, 9, 13);
INSERT INTO house (id, name, description, image_path, usage_area, width, height) VALUES (8, 'Laszlo', 'Waska', '8.jpg', 103, 10, 15);
INSERT INTO house (id, name, description, image_path, usage_area, width, height) VALUES (9, 'Benek', 'Lelum polelum', '9.jpg', 170, 17, 15);
INSERT INTO house (id, name, description, image_path, usage_area, width, height) VALUES (10, 'Wienio', 'Supcio', '10.jpg', 154, 9, 19);
ALTER SEQUENCE HOUSE_SEQ RESTART WITH 11;

INSERT INTO authority (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authority (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO user (id, username, password) VALUES (1,'ironman','tajne');
INSERT INTO user (id, username, password) VALUES (2,'hulk','poufne');
ALTER SEQUENCE USER_SEQ RESTART WITH 3;

INSERT INTO user_authority (authority_id, user_id) VALUES (1, 1);
INSERT INTO user_authority (authority_id, user_id) VALUES (2, 2);