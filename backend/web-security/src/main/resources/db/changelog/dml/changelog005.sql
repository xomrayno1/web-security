CREATE TABLE role_form (
    role_form_id BIGINT NOT NULL AUTO_INCREMENT,
    role_id BIGINT,
    form_id BIGINT,
    from_date DATETIME,
    to_date DATETIME,
	created_by VARCHAR(255),
    created_date datetime,
    updated_by VARCHAR(255),
    updated_date datetime,
    status VARCHAR(50),
    PRIMARY KEY (role_form_id)
);