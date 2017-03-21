
CREATE TABLE User (
  id          INT AUTO_INCREMENT PRIMARY KEY,
  first_name  VARCHAR(50)  NOT NULL,
  last_name   VARCHAR(50)  NOT NULL,
  date_of_birth         DATE,
  lang_Ru      BOOL,
  email       VARCHAR(100) NOT NULL,
  password_hash    VARCHAR(255) NOT NULL,
  is_male   BOOL,
  photo       BLOB,
  UNIQUE (email)
);
CREATE TABLE Product (
  id          INT AUTO_INCREMENT PRIMARY KEY,
  name        VARCHAR(100) NOT NULL,
    UNIQUE (name)
);
CREATE TABLE Picture (
  id          INT AUTO_INCREMENT PRIMARY KEY,
  picture        BLOB NOT NULL
);

CREATE TABLE Dish_type (
  id          INT AUTO_INCREMENT PRIMARY KEY,
  type         VARCHAR(100) NOT NULL ,
  UNIQUE (type)
);

CREATE TABLE Recipe (
  id                 INT AUTO_INCREMENT PRIMARY KEY,
  id_user            INT NOT NULL,
  name               VARCHAR(100) NOT NULL,
  date               DATETIME,
  id_type            INT NOT NULL,
  id_picture         INT,
  number_of_portions INT NOT NULL,
  time               INT,
  recipe              VARCHAR(600),
  likes                INT,
  FOREIGN KEY (id_type) REFERENCES Dish_type (id),
  FOREIGN KEY (id_picture) REFERENCES Picture (id),
  FOREIGN KEY (id_user) REFERENCES User (id),
);


CREATE TABLE Ingredient (
  id            INT AUTO_INCREMENT PRIMARY KEY,

  id_product    INT NOT NULL,
  id_recipe     INT NOT NULL,
  amount        VARCHAR(200) NOT NULL,
    FOREIGN KEY (id_product) REFERENCES Product (id),
    FOREIGN KEY (id_recipe) REFERENCES Recipe (id)
);

CREATE TABLE Followers(
  id            VARCHAR(50) PRIMARY KEY,
  id_user       INT NOT NULL,
  id_follower   INT NOT NULL,
  FOREIGN KEY (id_user) REFERENCES User (id),
  FOREIGN KEY (id_follower) REFERENCES User (id)
);

CREATE TABLE favorite (
  id            VARCHAR(50) PRIMARY KEY,
  id_user       INT NOT NULL,
  id_recipe   INT NOT NULL,
  FOREIGN KEY (id_user) REFERENCES User (id),
  FOREIGN KEY (id_recipe) REFERENCES Recipe (id)
);

