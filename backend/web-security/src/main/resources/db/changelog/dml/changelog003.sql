CREATE TABLE role (
    role_id BIGINT NOT NULL AUTO_INCREMENT,
    role_name VARCHAR(255),
    role_code VARCHAR(255),
    description VARCHAR(255),
	created_by VARCHAR(255),
    created_date datetime,
    updated_by VARCHAR(255),
    updated_date datetime,
    status VARCHAR(50),
    PRIMARY KEY (role_id)
);