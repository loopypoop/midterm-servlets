create table tasks
(
    id       serial       not null
        constraint users_pkey
            primary key,
    topic varchar(100) not null,
    description varchar (255)
);
