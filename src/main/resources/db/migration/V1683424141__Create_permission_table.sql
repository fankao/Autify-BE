-- Table: permission
CREATE TABLE permission
(
    id                BIGINT          NOT NULL AUTO_INCREMENT,
    name              VARCHAR(255) NOT NULL,
    created_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_updated_by   VARCHAR(255),
    PRIMARY KEY (id)
);

-- Create predefined permissions for application
INSERT INTO permission (name, created_date, last_updated_date, last_updated_by)
VALUES
    ('CREATE_USER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('UPDATE_USER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('DELETE_USER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('VIEW_USER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('CREATE_ROLE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('UPDATE_ROLE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('DELETE_ROLE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('VIEW_ROLE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('ASSIGN_PERMISSION', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('REMOVE_PERMISSION', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('VIEW_ASSIGNED_PERMISSIONS', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('TRACK_USER_LOGIN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('TRACK_USER_LOGOUT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('VIEW_USER_SESSION_DETAILS', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('TRACK_USER_DATA_CHANGES', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('VIEW_USER_ACTIVITY_LOG', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('INITIATE_PASSWORD_RESET', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('VERIFY_PASSWORD_RESET_TOKEN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('IMPLEMENT_JWT_AUTHENTICATION', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('AUTHENTICATE_USER_USING_JWT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('GENERATE_FRESH_TOKEN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN'),
    ('REFRESH_USER_TOKEN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ADMIN');