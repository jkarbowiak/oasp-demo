
create table audio_book (
    format varchar(255) not null,
    book_ex_id bigint not null,
    primary key (book_ex_id)
);

create table author (
    type varchar(6) not null,
    id bigint generated by default as identity,
    nick_name varchar(30),
    birth_date DATE not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    version bigint not null,
    literary_genre varchar(255),
    primary key (id)
);

create table book (
    id bigint generated by default as identity,
    title varchar(50) not null,
    version bigint not null,
    primary key (id)
);

create table book_author (
    book_id bigint not null,
    author_id bigint not null,
    primary key (book_id, author_id)
);

create table book_exemplar (
    id bigint generated by default as identity,
    serial_number varchar(15) not null,
    book_fk bigint not null,
    loan_fk bigint,
    primary key (id)
);

create table book_spoiler (
    id bigint generated by default as identity,
    content clob not null,
    book_fk bigint not null,
    primary key (id)
);

create table customer (
    id bigint generated by default as identity,
    email varchar(35) not null,
    birth_date DATE not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    phone_number varchar(15) not null,
    primary key (id)
);

create table loan (
    id bigint generated by default as identity,
    loan_date timestamp not null,
    customer_fk bigint,
    primary key (id)
);

create table paper_book (
    book_cover varchar(255) not null,
    pages_count integer not null,
    paper_size varchar(255) not null,
    book_ex_id bigint not null,
    primary key (book_ex_id)
);

create table customer_card (
    id bigint generated by default as identity,
    expiration_date date not null,
    serial_number varchar(30) not null,
    customer_fk bigint,
    primary key (id)
);

alter table book_exemplar
    add constraint UK_q1vdbj5iwa03t5gql2e9f4fln  unique (serial_number);

alter table audio_book
    add constraint FK_g3p0e2brkdj8ass285bspwx3d
    foreign key (book_ex_id)
    references book_exemplar;

alter table book_author
    add constraint FK_6cmg2roopa9a4c97uxetgf2e9
    foreign key (author_id)
    references author;

alter table book_author
    add constraint FK_q37qkj7serxg0bh56m450uigs
    foreign key (book_id)
    references book;

alter table book_exemplar
    add constraint FK_6xjdyconq4lm332wdhhln9e80
    foreign key (book_fk)
    references book;

alter table book_exemplar
    add constraint FK_hp46sikojivt1quj4ybeu3sau
    foreign key (loan_fk)
    references loan;

alter table book_spoiler
    add constraint FK_g620l27y4bdinx1gdoah630of
    foreign key (book_fk)
    references book;

alter table loan
    add constraint FK_1r3cl8gspam5pvkukjhqma556
    foreign key (customer_fk)
    references customer;

alter table paper_book
    add constraint FK_g118bplwt41nseg340hy1g5vf
    foreign key (book_ex_id)
    references book_exemplar;

alter table customer_card
    add constraint FK_customer_customer_card
    foreign key (customer_fk)
    references customer;
