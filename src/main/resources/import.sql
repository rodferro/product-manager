INSERT INTO product (id, name, description, parent_product_id) VALUES (1, 'Smartphone', 'A smartphone is a mobile phone with an advanced mobile operating system that combines features of a personal computer operating system with other features useful for mobile or handheld use.', null);
INSERT INTO product (id, name, description, parent_product_id) VALUES (2, 'iPhone', 'iPhone is a line of smartphones designed and marketed by Apple Inc.', 1);
INSERT INTO product (id, name, description, parent_product_id) VALUES (3, 'Pixel', 'Pixel is an Android smartphone designed and marketed by Google.', 1);
INSERT INTO product (id, name, description, parent_product_id) VALUES (4, 'Samsung Galaxy S7', 'Samsung Galaxy S7 is an Android smartphone manufactured and marketed by Samsung Electronics.', 1);

INSERT INTO image (id, type, url, product_id) VALUES (1, 'png', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/IPhone_7_Jet_Black.svg/299px-IPhone_7_Jet_Black.svg.png', 2);
INSERT INTO image (id, type, url, product_id) VALUES (2, 'png', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/IPhone_7_Jet_Black.svg/383px-IPhone_7_Jet_Black.svg.png', 2);
INSERT INTO image (id, type, url, product_id) VALUES (3, 'png', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/IPhone_7_Jet_Black.svg/511px-IPhone_7_Jet_Black.svg.png', 2);
INSERT INTO image (id, type, url, product_id) VALUES (4, 'png', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Pixel_%28smartphone%29_5_inch_silver_mock.png/296px-Pixel_%28smartphone%29_5_inch_silver_mock.png', 3);
INSERT INTO image (id, type, url, product_id) VALUES (5, 'png', 'https://upload.wikimedia.org/wikipedia/commons/8/88/Pixel_%28smartphone%29_5_inch_silver_mock.png', 3);
INSERT INTO image (id, type, url, product_id) VALUES (6, 'png', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Samsung_Galaxy_S7_and_S7_Edge.png/234px-Samsung_Galaxy_S7_and_S7_Edge.png', 4);