--liquibase formatted sql
--changeset i.german:v2_insert_data

insert into sensor_statistics (total_count, created_date)
values (25, '2025-02-27'),
       (10, '2025-02-26'),
       (15, '2025-02-25'),
       (20, '2025-02-24');

insert into sensor_type_statistics (type, count, type_id)
values ('Temperature', 4, 1),
       ('Pressure', 3, 1),
       ('Humidity', 3, 1),
       ('Temperature', 6, 2),
       ('Pressure', 5, 2),
       ('Humidity', 4, 2),
       ('Temperature', 8, 3),
       ('Pressure', 7, 3),
       ('Humidity', 5, 3),
       ('Temperature', 10, 4),
       ('Pressure', 9, 4),
       ('Humidity', 6, 4);