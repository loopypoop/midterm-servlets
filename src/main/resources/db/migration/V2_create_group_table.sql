create table users
(
    id       serial       not null
        constraint users_pkey
            primary key,
    name varchar(100) not null,
    user_id number,
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
            REFERENCES users(id)
);
