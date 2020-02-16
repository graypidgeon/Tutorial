INSERT INTO house (id, name, description, usage_area, garage_area, boiler_room_area, building_area, width, height, storey, garage) VALUES (1, 'Pierwszaczek', 'Niby ladny ale jednak', 62, 0, 10, 70, 8, 9, 'GROUND_FLOOR', 'NO');
INSERT INTO house (id, name, description, usage_area, garage_area, boiler_room_area, building_area, width, height, storey, garage) VALUES (2, 'Dwujniak', 'O chollllera', 86, 0, 12, 90, 11, 8, 'GROUND_FLOOR', 'NO');
INSERT INTO house (id, name, description, usage_area, garage_area, boiler_room_area, building_area, width, height, storey, garage) VALUES (3, 'Ostry', 'Wiadomo jak jest', 130, 15, 13, 148, 11, 15, 'ATTIC', 'ONE');
INSERT INTO house (id, name, description, usage_area, garage_area, boiler_room_area, building_area, width, height, storey, garage) VALUES (4, 'Dziaslak', 'Osz kurka flaqo', 122, 30, 14, 130, 9, 15, 'ATTIC', 'TWO');
INSERT INTO house (id, name, description, usage_area, garage_area, boiler_room_area, building_area, width, height, storey, garage) VALUES (5, 'Wigwam', 'Będzie szła tam i tu a potem jeszcze w lewo', 74, 0, 10, 88, 8, 11, 'STOREY_HOUSE', 'NO');
INSERT INTO house (id, name, description, usage_area, garage_area, boiler_room_area, building_area, width, height, storey, garage) VALUES (6, 'Warna', 'Lalo', 90, 0, 17, 102, 12, 12, 'ATTIC', 'NO');
INSERT INTO house (id, name, description, usage_area, garage_area, boiler_room_area, building_area, width, height, storey, garage) VALUES (7, 'Sarna', 'Kako', 88, 17, 17, 110, 9, 13, 'ATTIC', 'ONE');
INSERT INTO house (id, name, description, usage_area, garage_area, boiler_room_area, building_area, width, height, storey, garage) VALUES (8, 'Laszlo', 'Waska', 103, 0, 18, 112, 10, 15, 'GROUND_FLOOR', 'NO');
INSERT INTO house (id, name, description, usage_area, garage_area, boiler_room_area, building_area, width, height, storey, garage) VALUES (9, 'Benek', 'Lelum polelum', 170, 20, 10, 205, 17, 15, 'ATTIC', 'ONE');
INSERT INTO house (id, name, description, usage_area, garage_area, boiler_room_area, building_area, width, height, storey, garage) VALUES (10, 'Wienio', 'Supcio', 154, 0, 9, 162, 9, 19, 'STOREY_HOUSE', 'NO');
ALTER SEQUENCE HOUSE_SEQ RESTART WITH 11;

INSERT INTO image (id, image_path, image_section, house_id) VALUES (1, '1.jpg', 'MAIN', 1);
INSERT INTO image (id, image_path, image_section, house_id) VALUES (2, '2.jpg', 'MAIN', 2);
INSERT INTO image (id, image_path, image_section, house_id) VALUES (3, '3.jpg', 'MAIN', 3);
INSERT INTO image (id, image_path, image_section, house_id) VALUES (4, '4.jpg', 'MAIN', 4);
INSERT INTO image (id, image_path, image_section, house_id) VALUES (5, '5.jpg', 'MAIN', 5);
INSERT INTO image (id, image_path, image_section, house_id) VALUES (6, '6.jpg', 'MAIN', 6);
INSERT INTO image (id, image_path, image_section, house_id) VALUES (7, '7.jpg', 'MAIN', 7);
INSERT INTO image (id, image_path, image_section, house_id) VALUES (8, '8.jpg', 'MAIN', 8);
INSERT INTO image (id, image_path, image_section, house_id) VALUES (9, '9.jpg', 'MAIN', 9);
INSERT INTO image (id, image_path, image_section, house_id) VALUES (10, '10.jpg', 'MAIN', 10);
INSERT INTO image (id, image_path, image_section, house_id) VALUES (11, '9.jpg', 'GALLERY', 10);
ALTER SEQUENCE IMAGE_SEQ RESTART WITH 12;

INSERT INTO authority (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authority (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO user (id, username, password) VALUES (1,'ironman','tajne');
INSERT INTO user (id, username, password) VALUES (2,'hulk','poufne');
ALTER SEQUENCE USER_SEQ RESTART WITH 3;

INSERT INTO user_authority (authority_id, user_id) VALUES (1, 1);
INSERT INTO user_authority (authority_id, user_id) VALUES (2, 2);