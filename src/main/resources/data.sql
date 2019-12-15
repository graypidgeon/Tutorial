INSERT INTO house (id, name, description, url) VALUES (1, 'Pierwszaczek', 'Niby ladny ale jednak', 'https://die4ukv54j92t.cloudfront.net/fit-in/331x187/filters:quality(72)/images/project_view/351/15317307946DSPN.jpg');
INSERT INTO house (id, name, description, url) VALUES (2, 'Dwujniak', 'O chollllera', 'https://die4ukv54j92t.cloudfront.net/fit-in/331x187/filters:quality(72)/images/project_view/356/14685034722S36P.jpg');
INSERT INTO house (id, name, description, url) VALUES (3, 'Ostry', 'Wiadomo jak jest', 'https://die4ukv54j92t.cloudfront.net/fit-in/331x187/filters:quality(72)/images/project_view/36298/1564741499L0UEX.jpg');
INSERT INTO house (id, name, description, url) VALUES (4, 'Dziaslak', 'Osz kurka flaqo', 'https://die4ukv54j92t.cloudfront.net/fit-in/331x187/filters:quality(72)/images/project_view/720/1468503658SVOFA.jpg');
INSERT INTO house (id, name, description, url) VALUES (5, 'Wigwam', 'Będzie szła tam i tu a potem jeszcze w lewo', 'https://die4ukv54j92t.cloudfront.net/fit-in/331x187/filters:quality(72)/images/project_view/1106/146850390263274.jpg');
INSERT INTO house (id, name, description, url) VALUES (6, 'Warna', 'Lalo', 'https://die4ukv54j92t.cloudfront.net/fit-in/331x187/filters:quality(72)/images/project_view/856/1468503749421B1.jpg');
INSERT INTO house (id, name, description, url) VALUES (7, 'Sarna', 'Kako', 'https://die4ukv54j92t.cloudfront.net/fit-in/331x187/filters:quality(72)/images/project_view/36347/15647412708XX81.jpg');
INSERT INTO house (id, name, description, url) VALUES (8, 'Laszlo', 'Waska', 'https://die4ukv54j92t.cloudfront.net/fit-in/331x187/filters:quality(72)/images/project_view/793/1519802558BJJP3.jpg');
INSERT INTO house (id, name, description, url) VALUES (9, 'Benek', 'Lelum polelum', 'https://die4ukv54j92t.cloudfront.net/fit-in/331x187/filters:quality(72)/images/project_view/26003/1527503998HYAY6.jpg');
INSERT INTO house (id, name, description, url) VALUES (10, 'Wienio', 'Supcio', 'https://die4ukv54j92t.cloudfront.net/fit-in/331x187/filters:quality(72)/images/project_view/25930/1521477784KPIJX.jpg');

INSERT INTO authority (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authority (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO user (id, username, password) VALUES (1,'ironman','tajne');
INSERT INTO user (id, username, password) VALUES (2,'hulk','poufne');
ALTER SEQUENCE HIBERNATE_SEQUENCE RESTART WITH 3;

INSERT INTO user_authority (authority_id, user_id) VALUES (1, 1);
INSERT INTO user_authority (authority_id, user_id) VALUES (2, 2);