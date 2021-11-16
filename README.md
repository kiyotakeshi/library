- TODO: migration

```sql
create table books
(
	id int,
	title nvarchar(200) not null,
	author nvarchar(100) not null,
	published date null
);

create unique index books_author_uindex
	on books (author);

create unique index books_id_uindex
	on books (id);

create unique index books_title_uindex
	on books (title);

alter table books
	add constraint books_pk
		primary key (id);

alter table books modify id int auto_increment;

INSERT INTO library.books (title, author, published) VALUES ('test2', 'test2', '2021-11-16')
```