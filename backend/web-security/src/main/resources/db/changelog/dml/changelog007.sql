CREATE TABLE staff_role (
    staff_role_id BIGINT NOT NULL AUTO_INCREMENT,
    staff_id BIGINT,
    role_id BIGINT,
    from_date DATETIME,
    to_date DATETIME,
    is_default bit,
	created_by VARCHAR(255),
    created_date datetime,
    updated_by VARCHAR(255),
    updated_date datetime,
    status VARCHAR(50),
    PRIMARY KEY (staff_role_id)
);