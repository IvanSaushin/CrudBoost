create table if not exists "adresses" (
    id            bigint generated by default as identity
    constraint adresses_pkey
    primary key,

    country         varchar(255)    not null,
    city            varchar(255),
    street          varchar(255),
    house           varchar(255),
    apartment       varchar(255),
    date_start      timestamp       not null,
    user_id         bigint,
    FOREIGN KEY (user_id) REFERENCES users (id)
    );