create table tasks_students
(
    id       serial       not null
        constraint tasks_students_pkey
            primary key,
    grade int,
    task_topic varchar(255),
    user_id int,
    task_id int,
    subject_id int,
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
            REFERENCES users(id),
    CONSTRAINT fk_task
        FOREIGN KEY(task_id)
            REFERENCES tasks(id),
    CONSTRAINT fk_subject
        FOREIGN KEY (subject_id)
            REFERENCES subjects(id)
);
