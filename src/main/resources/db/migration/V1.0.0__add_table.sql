create table books
(
    id        int auto_increment,
    title     varchar(200) charset utf8 not null,
    author    varchar(100) charset utf8 not null,
    published date null,
    constraint books_id_uindex
        unique (id)
);

-- alter table books add constraint unique (id);

alter table books
    add primary key (id);

create table users
(
    id        int auto_increment,
    email     varchar(255) charset utf8 not null,
    password  varchar(1000) charset utf8 not null,
    name      varchar(255) charset utf8 not null,
    role_type varchar(20) charset utf8 not null,
    constraint users_id_uindex
        unique (id)
);

create table categories
(
    id   int auto_increment,
    name varchar(100),
    primary key (id)
);

create table book_categories
(
    book_id     integer not null,
    category_id integer not null
);

alter table book_categories
    add constraint foreign key (category_id)
        references categories (id);

alter table book_categories
    add constraint foreign key (book_id)
        references books (id);
