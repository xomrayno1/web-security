--liquibase formatted sql

--changeset tam:insert_staff

INSERT INTO `web-security`.`staff`
(`phone`, `email`, `password`,`created_by`,`created_date`, `status` )
VALUES
('0332525777', '0332525777@gmail.com', '$2a$10$wednkkZqe6/g1KKTAvnZ4OLU1GoQxRurtxs2B5.HxdcgvEYosbwe2', 'SYS', now(), 'ACTIVE');

INSERT INTO `web-security`.`staff`
(
`phone`,
`email`,
`password`,
`created_by`,
`created_date`,
`status`
)
VALUES
(
'0332525666',
'0332525666@gmail.com',
'$2a$10$wednkkZqe6/g1KKTAvnZ4OLU1GoQxRurtxs2B5.HxdcgvEYosbwe2',
'SYS',
now(),
'ACTIVE'
);

INSERT INTO `web-security`.`staff_role`
( `staff_id`, `role_id`, `from_date`, `to_date`, `is_default`, `created_by`, `created_date`, `status` )
VALUES
(1, 1, now(), null, 1, 'SYS', now(), 'ACTIVE');

INSERT INTO `web-security`.`staff_role`
(
`staff_id`,
`role_id`,
`from_date`,
`to_date`,
`is_default`,
`created_by`,
`created_date`,
`status`
) VALUES ( 2, 2, now(), null, 1, 'SYS', now(), 'ACTIVE');


INSERT INTO `web-security`.`role`
(
`role_name`,
`role_code`,
`description`,
`created_by`,
`created_date`,
`status`)
VALUES
('Siêu quản trị viên', 'SUPPER_ADMIN', 'Siêu quản trị viên', 'SYS', now(), 'ACTIVE' );


INSERT INTO `web-security`.`role`
(
`role_name`,
`role_code`,
`description`,
`created_by`,
`created_date`,
`status`)
VALUES
('Nhân viên xem đơn', 'STAFF_VIEW_ORDER', 'Nhân viên xem đơn', 'SYS', now(), 'ACTIVE' );


INSERT INTO `web-security`.`form`
(
`form_code`,
`form_name`,
`parent_id`,
`form_type`,
`path`,`created_by`,
`created_date`,
`status`)
VALUES
(
'HOME', 'Trang chủ',null, 'MENU', null, 'SYS',now(), 'ACTIVE');

INSERT INTO `web-security`.`form`
(
`form_code`,
`form_name`,
`parent_id`,
`form_type`,
`path`,`created_by`,
`created_date`,
`status`)
VALUES
('ORDER_MANAGEMENT', 'Quản lý đơn hàng', 1, 'MENU', 'OrderManagement', 'SYS', now(), 'ACTIVE');


INSERT INTO `web-security`.`form`
(
`form_code`,
`form_name`,
`parent_id`,
`form_type`,
`path`,`created_by`,
`created_date`,
`status`)
VALUES
('ORDER', 'Đơn hàng lẻ', 2, 'FORM', null, 'SYS', now(), 'ACTIVE');

INSERT INTO `web-security`.`form`
(
`form_code`,
`form_name`,
`parent_id`,
`form_type`,`path`,`created_by`, `created_date`, `status`)
VALUES
( 'MANAGEMENT', 'Quản lý ', 1, 'MENU', null, 'SYS', now(), 'ACTIVE');

INSERT INTO `web-security`.`form`
(
`form_code`,
`form_name`,
`parent_id`,
`form_type`,
`path`,`created_by`, `created_date`, `status`)
VALUES
( 'STAFF_MANAGEMENT', 'Quản lý nhân viên ', 4, 'FORM', 'StaffManagement', 'SYS', now(), 'ACTIVE');


INSERT INTO `web-security`.`control`
( 
`control_code`,
`control_name`,
`control_element`,
`description`,
`form_id`,`created_by`, `created_date`, `status`)
VALUES
( 'ORDER_CANCEL',
'Hủy đơn',
'ORDER_CANCEL_IDX',
'Button hủy đơn hàng', 3, 'SYS', now(), 'ACTIVE');

INSERT INTO `web-security`.`control`
( 
`control_code`,
`control_name`,
`control_element`,
`description`,
`form_id`,`created_by`,
`created_date`,
`status`)
VALUES
( 'ORDER_CONFIRM',
'Xác nhận đơn',
'ORDER_CONFIRM_IDX',
'Button xác nhận đơn hàng',
3, 'SYS', now(), 'ACTIVE');


INSERT INTO `web-security`.`role_form`
(`role_id`, `form_id`, `from_date`, `to_date`,
`created_by`, `created_date`, `status`)
VALUES
(1, 1, now(), null, 'SYS', now(), 'ACTIVE');

INSERT INTO `web-security`.`role_form`
(`role_id`, `form_id`, `from_date`, `to_date`,
`created_by`, `created_date`, `status`)
VALUES
(1, 2, now(), null, 'SYS', now(), 'ACTIVE');

INSERT INTO `web-security`.`role_form`
(`role_id`, `form_id`, `from_date`, `to_date`,
`created_by`, `created_date`, `status`)
VALUES
(1, 3, now(), null,   'SYS', now(), 'ACTIVE');

INSERT INTO `web-security`.`role_form`
(`role_id`, `form_id`, `from_date`, `to_date`,
`created_by`, `created_date`, `status`)
VALUES
(1, 4, now(), null, 'SYS', now(), 'ACTIVE');

INSERT INTO `web-security`.`role_form`
(`role_id`, `form_id`, `from_date`, `to_date`,
`created_by`, `created_date`, `status`)
VALUES
(1, 5, now(), null, 'SYS', now(), 'ACTIVE');



INSERT INTO `web-security`.`role_form`
(`role_id`, `form_id`, `from_date`, `to_date`,
`created_by`, `created_date`, `status`)
VALUES
(2, 1, now(), null, 'SYS', now(), 'ACTIVE');

INSERT INTO `web-security`.`role_form`
(`role_id`, `form_id`, `from_date`, `to_date`,
`created_by`, `created_date`, `status`)
VALUES
(2, 2, now(), null,  'SYS', now(), 'ACTIVE');

INSERT INTO `web-security`.`role_form`
(`role_id`, `form_id`, `from_date`, `to_date`,
`created_by`, `created_date`, `status`)
VALUES
(2, 3, now(), null, 'SYS', now(), 'ACTIVE');


INSERT INTO `web-security`.`role_control`
(`role_id`, `control_id`, `role_control_type`, 
`from_date`, `to_date`,
 `created_by`, `created_date`, `status`)
VALUES
(
1,  1, 'ENABLE', now(), null, 'SYS', now(), 'ACTIVE');

INSERT INTO `web-security`.`role_control`
(`role_id`, `control_id`, `role_control_type`, 
`from_date`, `to_date`,
`created_by`, `created_date`, `status`)
VALUES
(
1,  2, 'ENABLE', now(), null, 'SYS', now(), 'ACTIVE');

INSERT INTO `web-security`.`role_control`
(`role_id`, `control_id`, `role_control_type`, 
`from_date`, `to_date`,
 `created_by`, `created_date`, `status`)
VALUES
(
2,  1, 'DISABLE', now(), null, 'SYS', now(), 'ACTIVE');

INSERT INTO `web-security`.`role_control`
(`role_id`, `control_id`, `role_control_type`, 
`from_date`, `to_date`,
`created_by`, `created_date`, `status`)
VALUES
(
2,  2, 'DISABLE', now(), null, 'SYS', now(), 'ACTIVE');

 





