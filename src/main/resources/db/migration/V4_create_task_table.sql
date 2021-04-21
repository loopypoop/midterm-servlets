create table tasks
(
    id       serial       not null
        constraint tasks_pkey
            primary key,
    topic varchar(100) not null,
    description varchar (255),
    subject_id int,
    CONSTRAINT fk_subject
        FOREIGN KEY(subject_id)
            REFERENCES subjects(id)
);
