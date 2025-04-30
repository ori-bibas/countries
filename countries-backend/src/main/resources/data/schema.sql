
CREATE TABLE countries (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(255) NOT NULL,
    country_code VARCHAR(3) NULL,
    UNIQUE (country_code)
);

CREATE TABLE country_alias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fk_country_id BIGINT NOT NULL,
    alias_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (fk_country_id) REFERENCES countries(id) ON DELETE CASCADE
);