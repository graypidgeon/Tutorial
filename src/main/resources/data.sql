INSERT INTO house (id, name, description, image_path, usage_area, building_area, width, height, storey) VALUES (1, 'Pierwszaczek', 'Niby ladny ale jednak', '1.jpg', 62, 70, 8, 9, 'GROUND_FLOOR');
INSERT INTO house (id, name, description, image_path, usage_area, building_area, width, height, storey) VALUES (2, 'Dwujniak', 'O chollllera', '2.jpg', 86, 90, 11, 8, 'GROUND_FLOOR');
INSERT INTO house (id, name, description, image_path, usage_area, building_area, width, height, storey) VALUES (3, 'Ostry', 'Wiadomo jak jest', '3.jpg', 130, 148, 11, 15, 'ATTIC');
INSERT INTO house (id, name, description, image_path, usage_area, building_area, width, height, storey) VALUES (4, 'Dziaslak', 'Osz kurka flaqo', '4.jpg', 122, 130, 9, 15, 'ATTIC');
INSERT INTO house (id, name, description, image_path, usage_area, building_area, width, height, storey) VALUES (5, 'Wigwam', 'Będzie szła tam i tu a potem jeszcze w lewo', '5.jpg', 74, 88, 8, 11, 'STOREY_HOUSE');
INSERT INTO house (id, name, description, image_path, usage_area, building_area, width, height, storey) VALUES (6, 'Warna', 'Lalo', '6.jpg', 90, 102, 12, 12, 'ATTIC');
INSERT INTO house (id, name, description, image_path, usage_area, building_area, width, height, storey) VALUES (7, 'Sarna', 'Kako', '7.jpg', 88, 110, 9, 13, 'ATTIC');
INSERT INTO house (id, name, description, image_path, usage_area, building_area, width, height, storey) VALUES (8, 'Laszlo', 'Waska', '8.jpg', 103, 112, 10, 15, 'GROUND_FLOOR');
INSERT INTO house (id, name, description, image_path, usage_area, building_area, width, height, storey) VALUES (9, 'Benek', 'Lelum polelum', '9.jpg', 170, 205, 17, 15, 'ATTIC');
INSERT INTO house (id, name, description, image_path, usage_area, building_area, width, height, storey) VALUES (10, 'Wienio', 'Supcio', '10.jpg', 154, 162, 9, 19, 'STOREY_HOUSE');
ALTER SEQUENCE HOUSE_SEQ RESTART WITH 11;

INSERT INTO authority (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authority (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO user (id, username, password) VALUES (1,'ironman','tajne');
INSERT INTO user (id, username, password) VALUES (2,'hulk','poufne');
ALTER SEQUENCE USER_SEQ RESTART WITH 3;

INSERT INTO user_authority (authority_id, user_id) VALUES (1, 1);
INSERT INTO user_authority (authority_id, user_id) VALUES (2, 2);