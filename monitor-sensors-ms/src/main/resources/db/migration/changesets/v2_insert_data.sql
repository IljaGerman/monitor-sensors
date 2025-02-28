--liquibase formatted sql
--changeset i.german:v2_insert_data

insert into sensor_type (type)
values ('Pressure'),
       ('Voltage'),
       ('Temperature'),
       ('Humidity');

insert into sensor_unit (unit)
values ('bar'),
       ('voltage'),
       ('°С'),
       ('%');

insert into users (name, password, role)
values ('viewer', '$2y$10$U6FuRq47gL9jLpdnIOUQpewJFtsb2IharkuKYn.32His4hBcmMK7C', 'ROLE_VIEWER'),
       ('admin', '$2y$10$U6FuRq47gL9jLpdnIOUQpewJFtsb2IharkuKYn.32His4hBcmMK7C', 'ROLE_ADMIN');