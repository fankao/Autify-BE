-- Table: session
CREATE TABLE session
(
    id                INT          NOT NULL AUTO_INCREMENT,
    user_id           BIGINT          NOT NULL,
    session_id        VARCHAR(255) NOT NULL,
    login_time        TIMESTAMP    NOT NULL,
    ip_address        VARCHAR(255) NOT NULL,
    created_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_updated_by   VARCHAR(255),
    PRIMARY KEY (id)
);