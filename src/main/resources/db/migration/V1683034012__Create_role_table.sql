-- Table: role
CREATE TABLE role
(
    id                INT          NOT NULL AUTO_INCREMENT,
    name              VARCHAR(255) NOT NULL,
    created_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_updated_by   VARCHAR(255),
    PRIMARY KEY (id)
);