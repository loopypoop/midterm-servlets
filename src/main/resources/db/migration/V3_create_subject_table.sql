create table subjects
(
    id       serial       not null
        constraint subjects_pkey
            primary key,
    name varchar(100) not null unique
);
