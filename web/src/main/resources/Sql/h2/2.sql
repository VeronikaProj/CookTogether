
INSERT INTO Dish_type (type_code_name,type) VALUES  ('SOUP','суп');
INSERT INTO Dish_type (type_code_name,type) VALUES  ('DRINK','напиток');
INSERT INTO Dish_type (type_code_name,type) VALUES  ('SALAD','салат');
INSERT INTO Dish_type (type_code_name,type) VALUES  ('DESSERT','десерт');
INSERT INTO Dish_type (type_code_name,type) VALUES  ('MAIN_DISH','основное блюдо');
INSERT INTO Dish_type (type_code_name,type) VALUES  ('GARNISH','гарнир');

INSERT INTO Product (name) VALUES ('картофель');
INSERT INTO Product (name) VALUES ('молоко');
INSERT INTO Product (name) VALUES ('вода');
INSERT INTO Product (name) VALUES ('мука');
INSERT INTO Product (name) VALUES ('соль');
INSERT INTO Product (name) VALUES ('перец');
INSERT INTO Product (name) VALUES ('свинина');

INSERT INTO User (first_name, last_name, date_of_birth, lang_Ru, email, password_hash,is_male)
VALUES ('Наталья','Иванова','1989-03-04',TRUE,'ivanova@tamtam.com','qwerty',TRUE);
INSERT INTO User (first_name, last_name, date_of_birth, lang_Ru, email, password_hash,is_male)
VALUES ('Ирина','Васильева','1970-02-11',TRUE,'ir_vas@tamtam.com','asdfgh',TRUE);
INSERT INTO User (first_name, last_name, date_of_birth, lang_Ru, email, password_hash,is_male)
VALUES ('Лариса','ЗЗЗЗЗ','1969-11-21',TRUE,'lar3@tamtam.com','zxcvbn',TRUE);


INSERT INTO Recipe (id_user, name, date, id_type,
                    number_of_portions, time, recipe, likes)
VALUES (1,'жареная картошка','2017-02-11',6,4,30,
        'Почистить. Помыть. Порезать. Пожарить Посолить',0);

INSERT INTO Recipe (id_user, name, date, id_type,
                    number_of_portions, time, recipe, likes)
VALUES (2,'Картошка с мясом','2016-12-15',5,4,70,
        'Почистить картошку. Помыть картошку, мясо. Порезать кубиками, посолить, поперчить.' ||
        ' Выложить на протвень. Запекать 1 час',1);

INSERT INTO Recipe (id_user, name, date, id_type,
                    number_of_portions, time, recipe, likes)
VALUES (3,'Картофельное пюре','2017-03-03',6,4,40,
        'Почистить. Помыть. Порезать. Отварить в подсолёной воде. Слить воду, растолочь картофкль и добавить молоко',2);

INSERT INTO Ingredient (id_product, id_recipe, amount) VALUES (1,1,'пол килограмма');
INSERT INTO Ingredient (id_product, id_recipe, amount) VALUES (5,1,'пол столовой ложки');


INSERT INTO Ingredient (id_product, id_recipe, amount) VALUES (1,2,'4 шт покрупнее');
INSERT INTO Ingredient (id_product, id_recipe, amount) VALUES (7,2,'400 гр.');
INSERT INTO Ingredient (id_product, id_recipe, amount) VALUES (5,2,'по вкусу');
INSERT INTO Ingredient (id_product, id_recipe, amount) VALUES (6,2,'');

INSERT INTO Ingredient (id_product, id_recipe, amount) VALUES (1,3,'пол килограмма');
INSERT INTO Ingredient (id_product, id_recipe, amount) VALUES (5,3,'пол столовой ложки');
INSERT INTO Ingredient (id_product, id_recipe, amount) VALUES (2,3,'200 мл');


