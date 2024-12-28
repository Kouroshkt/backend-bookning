CREATE TABLE User_inform (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    username VARCHAR(255),
    password VARCHAR(255),
    address VARCHAR(255)
);
INSERT INTO User_inform (name, last_name, email, username, password, address) VALUES ('John', 'Doe', '8K6Tb@example.com', 'johndoe', 'password123', '123 Main St');
CREATE TABLE car_category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category_Name VARCHAR(255),
    description VARCHAR(255),
    category_Image VARCHAR(255)
);
INSERT INTO car_category (category_Name, description, category_Image) VALUES
                                                                        ('Economy', 'Bränslesnåla och prisvärda bilar för kortare resor', 'economy.jpg'),
                                                                        ('SUV', 'Rymliga och bekväma bilar med hög prestanda', 'suv.jpg'),
                                                                        ('Luxury', 'Premiumbilar för lyx och komfort', 'luxury.jpg'),
                                                                        ('Electric', 'Miljövänliga elbilar med modern teknik', 'electric.jpg'),
                                                                        ('Convertible', 'Stilfulla bilar med öppet tak för nöjeskörning', 'convertible.jpg');
