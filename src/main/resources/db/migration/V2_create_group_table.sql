create table groups
(
    id       serial       not null
        constraint group_pkey
            primary key,
    name varchar(100) not null,
    teacher_id int,
    CONSTRAINT fk_user
        FOREIGN KEY(teacher_id)
            REFERENCES users(id)
);
