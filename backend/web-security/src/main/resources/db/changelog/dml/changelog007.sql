CREATE TABLE staff_role (
    id BIGINT NOT NULL AUTO_INCREMENT,
    users_id BIGINT,
    role_id BIGINT,
    from_date DATETIME,
    to_date DATETIME,
    is_active BOOLEAN,
    PRIMARY KEY (id)
);