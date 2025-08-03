CREATE TABLE role_control (
    id BIGINT NOT NULL AUTO_INCREMENT,
    role_id BIGINT,
    control_id BIGINT,
    from_date DATETIME,
    to_date DATETIME,
    is_active BOOLEAN,
    PRIMARY KEY (id)
);