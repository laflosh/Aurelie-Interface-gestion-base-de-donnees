-- =========================
-- Initial schema - V1
-- =========================

CREATE TABLE site (
    id INT AUTO_INCREMENT PRIMARY KEY,
    site_number VARCHAR(100) NOT NULL,
    region VARCHAR(100),
    department VARCHAR(100),
    ancient_name VARCHAR(100),
    modern_name VARCHAR(100),
    locality VARCHAR(100),
    latitude FLOAT,
    longitude FLOAT,
    tpq INT,
    taq INT,
    occupation VARCHAR(100),
    nature_of_the_excavation VARCHAR(100),
    total_number_sepultures INT,
    immature_sepulture_number INT,
    sepulture_number_vab INT,
    number_sepulture_studied INT,
    date_excavation VARCHAR(100),
    observation TEXT,
    reference TEXT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE mortuary_repository (
    id INT AUTO_INCREMENT PRIMARY KEY,
    site_id INT,
    site_number VARCHAR(100) NOT NULL,
    issue_number VARCHAR(100) NOT NULL,
    sepulture_type VARCHAR(100),
    burial_type VARCHAR(100),
    state_of_sepulture VARCHAR(100),
    timeline VARCHAR(100),
    age VARCHAR(100),
    gender VARCHAR(100),
    furniture VARCHAR(100),
    origin_furniture VARCHAR(100),
    publication TEXT,
    comment TEXT,
    picture VARCHAR(100),
    CONSTRAINT fk_mortuary_repository_site
        FOREIGN KEY (site_id)
        REFERENCES site(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE furniture (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mortuary_repository_id INT,
    issue_number VARCHAR(100) NOT NULL,
    furniture_number VARCHAR(100) NOT NULL,
    furniture_nature VARCHAR(100),
    feature VARCHAR(100),
    domain VARCHAR(100),
    designation VARCHAR(100),
    typology VARCHAR(100),
    material VARCHAR(100),
    color VARCHAR(100),
    dimension VARCHAR(100),
    origin VARCHAR(100),
    description TEXT,
    conservation VARCHAR(100),
    status VARCHAR(100),
    tpq VARCHAR(100),
    taq VARCHAR(100),
    reference TEXT,
    storage_location VARCHAR(100),
    picture VARCHAR(100),
    interpretation TEXT,
    CONSTRAINT fk_furniture_mortuary_repository
        FOREIGN KEY (mortuary_repository_id)
        REFERENCES mortuary_repository(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE app_user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(100),
    name VARCHAR(100),
    mail VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(100) NOT NULL,
    username VARCHAR(100),
    CONSTRAINT uq_app_user_mail UNIQUE (mail),
    CONSTRAINT uq_app_user_username UNIQUE (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;