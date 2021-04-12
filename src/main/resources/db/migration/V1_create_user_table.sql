create table users
(
    id       serial       not null
        constraint users_pkey
            primary key,
    username varchar(100) not null,
    password varchar(100) not null,
    name varchar (255),
    email varchar (100),
    group_id number,
    teacher boolean,
    CONSTRAINT fk_group
        FOREIGN KEY(group_id)
            REFERENCES groups(id)
);
