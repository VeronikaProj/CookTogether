
INSERT INTO Dish_type (type) VALUES  'суп';
INSERT INTO Dish_type (type) VALUES  'напиток';
INSERT INTO Dish_type (type) VALUES  'салат';
INSERT INTO Dish_type (type) VALUES  'десерт';
INSERT INTO Dish_type (type) VALUES  'основное блюдо';
INSERT INTO Dish_type (type) VALUES  'гарнир';

INSERT INTO Product (name) VALUES ('картофель');
INSERT INTO Product (name) VALUES ('молоко');
INSERT INTO Product (name) VALUES ('вода');
INSERT INTO Product (name) VALUES ('мука');
INSERT INTO Product (name) VALUES ('соль');
INSERT INTO Product (name) VALUES ('перец');
INSERT INTO Product (name) VALUES ('свинина');

INSERT INTO User (first_name, last_name, date_of_birth, lang_Ru, email, password_hash)
VALUES ('Наталья','Иванова','1989-03-04',TRUE,'ivanova@tamtam.com','qwerty');
INSERT INTO User (first_name, last_name, date_of_birth, lang_Ru, email, password_hash)
VALUES ('Ирина','Васильева','1970-02-11',TRUE,'ir_vas@tamtam.com','asdfgh');
INSERT INTO User (first_name, last_name, date_of_birth, lang_Ru, email, password_hash)
VALUES ('Лариса','ЗЗЗЗЗ','1969-11-21',TRUE,'lar3@tamtam.com','zxcvbn');


INSERT INTO Recipe (id_user, name, date, id_type,
                    number_of_portions, period, recipe, likes)
VALUES (1,'жареная картошка','2017-02-11',6,4,'30 минут',
        'Почистить. Помыть. Порезать. Пожарить Посолить',0);

INSERT INTO Recipe (id_user, name, date, id_type,
                    number_of_portions, period, recipe, likes)
VALUES (2,'Картошка с мясом','2016-12-15',5,4,'1  час 10 мин.',
        'Почистить картошку. Помыть картошку, мясо. Порезать кубиками, посолить, поперчить.' ||
        ' Выложить на протвень. Запекать 1 час',1);

INSERT INTO Recipe (id_user, name, date, id_type,
                    number_of_portions, period, recipe, likes)
VALUES (3,'Картофельное пюре','2017-03-03',6,4,'40 минут',
        'Почистить. Помыть. Порезать. Отварить в подсолёной воде. Слить воду, растолочь картофкль и добавить молоко',2);

INSERT INTO Ingredient (id_product, id_recipe, amount) VALUES (1,1,'пол килограмма');
INSERT INTO Ingredient (id_product, id_recipe, amount) VALUES (5,1,'пол столовой ложки');


INSERT INTO Ingredient (id_product, id_recipe, amount) VALUES (1,2,'4 шт покрупнее');
INSERT INTO Ingredient (id_product, id_recipe, amount) VALUES (7,2,'400 гр.');
INSERT INTO Ingredient (id_product, id_recipe) VALUES (5,2);
INSERT INTO Ingredient (id_product, id_recipe) VALUES (6,2);

INSERT INTO Ingredient (id_product, id_recipe, amount) VALUES (1,3,'пол килограмма');
INSERT INTO Ingredient (id_product, id_recipe, amount) VALUES (5,3,'пол столовой ложки');
INSERT INTO Ingredient (id_product, id_recipe, amount) VALUES (2,3,'200 мл');


