create table subjects
(
    id       serial       not null
        constraint users_pkey
            primary key,
    name varchar(100) not null
);
