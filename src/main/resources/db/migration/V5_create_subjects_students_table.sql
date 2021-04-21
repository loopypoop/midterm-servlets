create table subjects_students
(
    id       serial       not null
        constraint subjects_students_pkey
            primary key,
    grade int,
    subject_name varchar(255),
    user_id int,
    subject_id int,
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
            REFERENCES users(id),
    CONSTRAINT fk_subject
        FOREIGN KEY(subject_id)
            REFERENCES subjects(id),
    CONSTRAINT fk_sbName
        FOREIGN KEY (subject_name)
            REFERENCES subjects(name)
);
