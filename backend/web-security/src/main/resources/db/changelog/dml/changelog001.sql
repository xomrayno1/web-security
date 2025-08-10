CREATE TABLE control (
    control_id BIGINT NOT NULL AUTO_INCREMENT,
    control_code VARCHAR(255),
    control_name VARCHAR(255),
    control_element VARCHAR(255),
    description VARCHAR(255),
    form_id BIGINT,
    created_by VARCHAR(255),
    created_date datetime,
    updated_by VARCHAR(255),
    updated_date datetime,
    status VARCHAR(50),
    PRIMARY KEY (control_id)
);