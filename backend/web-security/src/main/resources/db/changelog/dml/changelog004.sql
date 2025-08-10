CREATE TABLE role_control (
    role_control_id BIGINT NOT NULL AUTO_INCREMENT,
    role_id BIGINT,
    control_id BIGINT,
    from_date DATETIME,
    to_date DATETIME,
    role_control_type VARCHAR(255),
	created_by VARCHAR(255),
    created_date datetime,
    updated_by VARCHAR(255),
    updated_date datetime,
    status VARCHAR(50),
    PRIMARY KEY (role_control_id)
);