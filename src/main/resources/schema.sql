create table if not exists bookningsUser(
    id int auto_increment,
    name varchar(255),
    email varchar(255),
    password varchar(255)
                                        );
INSERT INTO bookningsUser (name, email, password) VALUES ('admin', 'admin', 'admin');
