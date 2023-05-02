-- Table: user
CREATE TABLE user
(
    id                BIGINT          NOT NULL AUTO_INCREMENT,
    username          VARCHAR(255) NOT NULL,
    email             VARCHAR(255) NOT NULL,
    password          VARCHAR(255) NOT NULL,
    -- role_id           INT          NOT NULL,
    created_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_updated_by   VARCHAR(255),
    PRIMARY KEY (id)
    -- FOREIGN KEY (role_id) REFERENCES role (id)
);
/*-- Table: permission
CREATE TABLE permission
(
    id                INT          NOT NULL AUTO_INCREMENT,
    name              VARCHAR(255) NOT NULL,
    created_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_updated_by   VARCHAR(255),
    PRIMARY KEY (id)
);

-- Table: role_permission
CREATE TABLE role_permission
(
    role_id           INT NOT NULL,
    permission_id     INT NOT NULL,
    created_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_updated_by   VARCHAR(255),
    PRIMARY KEY (role_id, permission_id),
    FOREIGN KEY (role_id) REFERENCES role (id),
    FOREIGN KEY (permission_id) REFERENCES permission (id)
);

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
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id)
);

-- Table: audit
CREATE TABLE audit
(
    id                INT          NOT NULL AUTO_INCREMENT,
    user_id           BIGINT          NOT NULL,
    action            VARCHAR(255) NOT NULL,
    created_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_updated_by   VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id)
);

-- Table: password_reset
CREATE TABLE password_reset
(
    id                INT          NOT NULL AUTO_INCREMENT,
    email             VARCHAR(255) NOT NULL,
    reset_code        VARCHAR(255) NOT NULL,
    created_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_updated_by   VARCHAR(255),
    PRIMARY KEY (id)
);
CREATE TABLE refresh_token
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    user_id           BIGINT          NOT NULL,
    token             VARCHAR(255) NOT NULL,
    expiry_date       DATETIME     NOT NULL,
    created_date      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_updated_date DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX             idx_refresh_token_user_id (user_id),
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE
);*/
