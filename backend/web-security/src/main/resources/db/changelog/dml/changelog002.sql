CREATE TABLE form (
    form_id BIGINT NOT NULL AUTO_INCREMENT,
    form_code VARCHAR(255),
    form_name VARCHAR(255),
    parent_id BIGINT,
    form_type VARCHAR(255),
    path VARCHAR(255),
    PRIMARY KEY (form_id)
);