-- Tabell för City
CREATE TABLE city
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    city_name VARCHAR(255) NOT NULL
);

-- Tabell för CarCategory
CREATE TABLE car_category
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    category_name  VARCHAR(255) NOT NULL,
    description    VARCHAR(255),
    category_image VARCHAR(255),
    city_id        INT          NOT NULL,
    FOREIGN KEY (city_id) REFERENCES city (id) ON DELETE CASCADE
);

-- Tabell för Car
CREATE TABLE car
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    brand           VARCHAR(255) NOT NULL,
    model           VARCHAR(255) NOT NULL,
    color           VARCHAR(255),
    seats           INT          NOT NULL,
    image           VARCHAR(255),
    car_category_id INT          NOT NULL,
    city_id         INT          NOT NULL,
    FOREIGN KEY (car_category_id) REFERENCES car_category (id) ON DELETE CASCADE,
    FOREIGN KEY (city_id) REFERENCES city (id) ON DELETE CASCADE
);

-- Tabell för UserInformation
CREATE TABLE user_information
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email     VARCHAR(255) NOT NULL UNIQUE,
    username  VARCHAR(255) NOT NULL UNIQUE,
    password  VARCHAR(255) NOT NULL,
    address   VARCHAR(255)
);
-- Fyller tabellen 'city' med exempelstäder
INSERT INTO city (city_name)
VALUES ('Stockholm'),
       ('Malmo'),
       ('Gothenburg'),
       ('Uppsala'),
       ('Lund');
INSERT INTO car_category (category_name, description, category_image, city_id)
VALUES
    -- Stockholm
    ('Economy', 'Prisvärda och bränsleeffektiva bilar', 'economy.jpg', 1),
    ('SUV', 'Rymliga och robusta bilar', 'suv.jpg', 1),
    ('Luxury', 'Lyxbilar för en exklusiv körupplevelse', 'luxury.jpg', 1),

    -- Göteborg
    ('Electric', 'Miljövänliga elbilar', 'electric.jpg', 2),
    ('Convertible', 'Sportbilar med öppet tak', 'convertible.jpg', 2),

    -- Malmö
    ('Economy', 'Prisvärda och bränsleeffektiva bilar', 'economy_malmo.jpg', 3),
    ('SUV', 'Rymliga och robusta bilar', 'suv_malmo.jpg', 3),

    -- Uppsala
    ('Luxury', 'Lyxbilar för en exklusiv körupplevelse', 'luxury_uppl.jpg', 4),
    ('Electric', 'Miljövänliga elbilar', 'electric_uppl.jpg', 4),

    -- Lund
    ('Convertible', 'Sportbilar med öppet tak', 'convertible_lund.jpg', 5),
    ('SUV', 'Rymliga och robusta bilar', 'suv_lund.jpg', 5);

INSERT INTO car (brand, model, color, image, seats, car_category_id, city_id)
VALUES
    -- Stockholm
    ('Toyota', 'Corolla', 'Silver', 'corolla.png', 5, 1, 1),
    ('Toyota', 'RAV4', 'Blue', 'rav4.png', 5, 1, 1),
    ('Tesla', 'Model S', 'Red', 'model_s.png', 5, 2, 1),
    ('Volvo', 'S90', 'Gray', 's90.jpg', 5, 2, 1),
    ('Volvo', 'V60', 'Black', 'v60.jpg', 5, 3, 1),
    ('Tesla', 'Model 3', 'Black', 'model_3.jpg', 5, 3, 1),

    -- Göteborg
    ('Tesla', 'Model X', 'White', 'model_x.jpg', 7, 4, 2),
    ('Volvo', 'XC60', 'Blue', 'xc60.jpg', 5, 4, 2),

    -- Malmö
    ('Toyota', 'RAV4', 'Blue', 'rav4.png', 5, 6, 3),
    ('Toyota' , 'Corolla', 'Silver', 'corolla.png', 5, 6, 3),
    ('Tesla', 'Model S', 'Red', 'model_s.png', 5, 7, 3),
    ('Volvo', 'S90', 'Gray', 's90.jpg', 5, 7, 3),

    -- Uppsala
    ('Tesla', 'Model 3', 'Black', 'model_3.jpg', 5, 8, 4),
    ('Volvo', 'V60', 'Black', 'v60.jpg', 5, 8, 4),
    ('Volvo', 'XC90', 'Silver', 'xc90.jpg', 7, 9, 4),

    -- Lund
    ('Toyota', 'Hilux', 'Black', 'hilux.png', 7, 10, 5),
    ('Volvo', 'XC60', 'Blue', 'xc60.jpg', 5, 10, 5),
    ('Volvo', 'V90', 'White', 'v90.jpg', 5, 11, 5),
    ('Tesla', 'Model S', 'Red', 'model_s.png', 5, 11, 5);



-- Fyller tabellen 'user_information' med exempeldata för användare
INSERT INTO user_information (name, last_name, email, username, password, address)
VALUES ('John', 'Doe', 'john.doe@example.com', 'johndoe', 'password123', '123 Main St');
