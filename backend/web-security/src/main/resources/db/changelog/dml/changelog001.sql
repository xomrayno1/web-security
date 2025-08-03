CREATE TABLE control (
    control_id BIGINT NOT NULL AUTO_INCREMENT,
    control_code VARCHAR(255),
    control_name VARCHAR(255),
    control_element VARCHAR(255),
    form_id BIGINT,
    PRIMARY KEY (control_id)
);