create table lego_piece
    (id bigint generated by default as identity,
    color varchar(35) not null,
    piece_number varchar(25) not null,
    version bigint not null,
    weight integer,
    piece_count integer not null,
    primary key (id));

create table lego_set
    (id bigint generated by default as identity,
    owned bigint,
    set_number varchar(50) not null,
    version bigint not null,
    wanted bigint,
    primary key (id));

create table lego_set_pieces
    (id bigint generated by default as identity,
    piece_count integer not null,
    version bigint not null,
    piece_id bigint,
    set_id bigint,
    primary key (id));

alter table lego_set_pieces add constraint
    FK_63qi6pp842tjrlfnesnwqwkw6 foreign key (piece_id) references lego_piece;

alter table lego_set_pieces add constraint
    FK_nnjk0pcu2xj1j11bm6kk4x6qd foreign key (set_id) references lego_set;

