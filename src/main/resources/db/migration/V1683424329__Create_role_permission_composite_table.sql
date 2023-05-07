-- Table: role_permission
CREATE TABLE role_permission
(
    role_id           BIGINT NOT NULL,
    permission_id     BIGINT NOT NULL,
    created_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_updated_by   VARCHAR(255),
    PRIMARY KEY (role_id, permission_id)
);
ALTER TABLE role_permission
    ADD CONSTRAINT FK_role_permission_role FOREIGN KEY (role_id) REFERENCES role(id),
    ADD CONSTRAINT FK_role_permission_permission FOREIGN KEY (permission_id) REFERENCES permission(id);