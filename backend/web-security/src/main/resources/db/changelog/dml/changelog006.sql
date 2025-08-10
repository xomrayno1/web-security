CREATE TABLE staff (
    staff_id BIGINT NOT NULL AUTO_INCREMENT,
    phone VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
	created_by VARCHAR(255),
    created_date datetime,
    updated_by VARCHAR(255),
    updated_date datetime,
    status VARCHAR(50),
    PRIMARY KEY (staff_id)
);