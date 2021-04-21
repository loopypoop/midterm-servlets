create table users
(
    id       serial       not null
        constraint users_pkey
            primary key,
    password varchar(100) not null,
    name varchar (255),
    email varchar (100),
    teacher boolean
);

ALTER TABLE users
    ADD COLUMN group_id int;

ALTER TABLE users
    ADD CONSTRAINT fk_group
        FOREIGN KEY (group_id)
            REFERENCES groups (id);
