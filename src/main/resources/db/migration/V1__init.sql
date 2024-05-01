CREATE TABLE IF NOT EXISTS agricultor (
    id SERIAL,
    nickname VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phonenumber VARCHAR(20),
    age INT,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS agricultural_sector (
    id SERIAL,
    sector_name VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL,
    hectares VARCHAR(50),
    agricultor_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (agricultor_id) REFERENCES agricultor(id)
    );
