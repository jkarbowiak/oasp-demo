-- authors
insert into author (id, type, birth_date, first_name, last_name, nick_name, literary_genre, version) values (2, 'WRITER', DATE('1622-01-15'), 'Jean', 'Poquelin', 'Molier', 'COMEDY', 0);

-- books
insert into book (id, title, version) values (5, 'Rogacz z urojenia', 0);
insert into book (id, title, version) values (6, 'Szkoła mężów', 0);
insert into book (id, title, version) values (7, 'Szkoła żon', 0);
insert into book (id, title, version) values (8, 'Świętoszek', 0);

-- book_exemplar
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (14, 'ISBN-0014', 5, 'HARD', 322, 'A_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (15, 'ISBN-0015', 5, 'HARD', 254, 'B_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (16, 'ISBN-0016', 5, 'SOFT', 443, 'A_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (17, 'ISBN-0017', 5, 'HARD', 342, 'B_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (18, 'ISBN-0018', 6, 'SOFT', 132, 'B_4');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (19, 'ISBN-0019', 6, 'SOFT', 245, 'A_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (20, 'ISBN-0020', 6, 'HARD', 523, 'A_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (21, 'ISBN-0021', 7, 'SOFT', 234, 'B_4');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (22, 'ISBN-0022', 7, 'HARD', 411, 'B_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (23, 'ISBN-0023', 7, 'SOFT', 312, 'B_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (24, 'ISBN-0024', 7, 'SOFT', 98, 'A_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (25, 'ISBN-0025', 7, 'SOFT', 56, 'B_4');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (26, 'ISBN-0026', 8, 'HARD', 333, 'A_4');

-- book_author
insert into book_author (author_id, book_id) values (2, 5);
insert into book_author (author_id, book_id) values (2, 6);
insert into book_author (author_id, book_id) values (2, 7);
insert into book_author (author_id, book_id) values (2, 8);
