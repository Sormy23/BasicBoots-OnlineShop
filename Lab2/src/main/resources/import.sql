INSERT INTO product (name, desc, price, img, gueltigAb, gueltigBis) VALUES ('Laufschuhe', 'Schuhe für jede Lebenssituation, egal ob Schmall, Regen oder Sonnenschein diese Schuhelassen sie niemals im stich!', 27.50, '/assets/images/shop_img1.png', '2021-03-03', '2024-03-03');
INSERT INTO product (name, desc, price, img, gueltigAb, gueltigBis) VALUES ('Winterstiefel', 'Besonders gut für die kalten Jahreszeiten bis in den tiefsten Winter! Auf diese Schuhe ist immer verlass!', 16.50, '/assets/images/shop_img2.png', '2022-03-03', '2024-03-03');
INSERT INTO product (name, desc, price, img, gueltigAb, gueltigBis) VALUES ('Moomboots', 'Schuhe von der bekannten Marke Moomboots am besten geeignet für das schnelle an- und ausziehen damit sie auch im Winter bei Müll entsorgen keine kalten Füße bekommen', 127.50,'/assets/images/shop_img3.png', '2022-03-03', '2024-03-03');
INSERT INTO product (name, desc, price, img, gueltigAb, gueltigBis) VALUES ('Converse', 'Unter anderem die Schuhe von Marco deshalb ein gutes Produkt um es zu kaufen.......mehrmals', 200.50,'/assets/images/shop_img4.png', '2022-03-03', '2024-03-03');
INSERT INTO product (name, desc, price, img, gueltigAb, gueltigBis) VALUES ('Gucci Slides', 'Besonders gut für die Schnee und Eis im kältesten Winter!', 4300.99,'/assets/images/shop_img5.png', '2022-03-03', '2024-03-03');
INSERT INTO product (name, desc, price, img, gueltigAb, gueltigBis) VALUES ('Big Red Boots', 'Die bekannten Mario Schuhe aus dem Internet! Sehr guter PReise chef!', 22344.55,'/assets/images/shop_img6.png', '2022-03-03', '2024-03-03');
INSERT INTO product (name, desc, price, img, gueltigAb, gueltigBis) VALUES ('Adiletten', 'Die Adiletten perfekt wenn du schlecht deutsch kannst und ein kleiner kanake bist!', 1.75,'/assets/images/shop_img7.png', '2022-03-03', '2024-03-03');
INSERT INTO product (name, desc, price, img, gueltigAb, gueltigBis) VALUES ('Fish Flops', 'Mögen sie Fische? Mögen Sie Schlapfen? AHHHHHHH Fish flops !!!!!', 38.90,'/assets/images/shop_img8.png', '2022-03-03', '2024-03-03');


INSERT INTO productOrder (anrede, name, street, zipCode, city, date, price) VALUES ('Herr', 'Müller', 'Gasse', '2700', 'Neustadt', '2023-05-01', 270.99);
INSERT INTO productOrder (anrede, name, street, zipCode, city, date, price) VALUES ('Herr', 'Dreck', 'Gasse', '2700', 'Neustadt', '2023-05-01', 7.99);
INSERT INTO productOrder (anrede, name, street, zipCode, city, date, price) VALUES ('Frau', 'Wesba', 'Gasse', '2700', 'Neustadt', '2023-05-01', 37065.99);

--Password alex123
INSERT INTO User (id, firstname, lastname, username, password, salary, age) VALUES (-1, 'Sven','Oberwalder', 'sven','$2a$04$4vwa/ugGbBVDvbWaKUVZBuJbjyQyj6tqntjSmG8q.hi97.xSdhj/2', 3456, 33);
