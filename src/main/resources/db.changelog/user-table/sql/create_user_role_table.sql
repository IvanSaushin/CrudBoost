create table if not exists "users" (
    id            bigint generated by default as identity
    constraint users_pkey
    primary key,

    firstname       varchar(255),
    lastname        varchar(255),
    age             int,
    email           varchar(255),
    password        varchar(255)
    );

create table if not exists role (
    id            bigint generated by default as identity
    constraint roles_pkey
    primary key,
    role       varchar(255)
);

create table if not exists users_roles (
    user_id     bigint,
    role_id     bigint,
    CONSTRAINT fk_user_id
    FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_role_id
    FOREIGN KEY (role_id) REFERENCES role (id)
    );

create table if not exists "district" (
    id            bigint generated by default as identity
    constraint district_pkey
    primary key,

    name       varchar(255),
    user_id     bigint,
    CONSTRAINT fk_user_id
    FOREIGN KEY (user_id) REFERENCES users (id)
    );

