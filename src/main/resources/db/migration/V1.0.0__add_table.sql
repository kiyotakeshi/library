create table books
(
    id        int auto_increment,
    title     varchar(200) charset utf8 not null,
    author    varchar(100) charset utf8 not null,
    published date                      null,
    constraint books_id_uindex
        unique (id)
);

alter table books
    add primary key (id);

create table users
(
    id        int auto_increment,
    email     varchar(255) charset utf8  not null,
    password  varchar(1000) charset utf8 not null,
    name      varchar(255) charset utf8  not null,
    role_type varchar(20) charset utf8   not null,
    constraint users_id_uindex
        unique (id)
);
