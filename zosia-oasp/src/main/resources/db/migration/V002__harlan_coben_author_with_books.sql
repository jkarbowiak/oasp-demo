-- authors
insert into author (id, type, birth_date, first_name, last_name, literary_genre, version) values (1, 'WRITER', DATE('1962-01-04'), 'Harlan', 'Coben', 'CRIME', 0);

-- books
insert into book (id, title, version) values (1, 'Nie mów nikomu', 0);
insert into book (id, title, version) values (2, 'Wszyscy mamy tajemnice', 0);
insert into book (id, title, version) values (3, 'Schronienie', 0);
insert into book (id, title, version) values (4, 'Mistyfikacja', 0);

-- book_exemplar
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (1,  'ISBN-0001', 1, 'HARD', 322, 'A_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (2,  'ISBN-0002', 1, 'HARD', 254, 'B_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (3,  'ISBN-0003', 1, 'SOFT', 443, 'A_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (4,  'ISBN-0004', 1, 'HARD', 342, 'B_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (5,  'ISBN-0005', 2, 'SOFT', 132, 'B_4');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (6,  'ISBN-0006', 2, 'SOFT', 245, 'A_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (7,  'ISBN-0007', 2, 'HARD', 523, 'A_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (8,  'ISBN-0008', 3, 'SOFT', 234, 'B_4');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (9,  'ISBN-0009', 3, 'HARD', 411, 'B_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (10, 'ISBN-0010', 3, 'SOFT', 312, 'B_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (11, 'ISBN-0011', 3, 'SOFT', 98, 'A_5');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (12, 'ISBN-0012', 3, 'SOFT', 56, 'B_4');
insert into book_exemplar (id, serial_number, book_fk, book_cover, pages_count, paper_size) values (13, 'ISBN-0013', 4, 'HARD', 333, 'A_4');

-- book_author
insert into book_author (author_id, book_id) values (1, 1);
insert into book_author (author_id, book_id) values (1, 2);
insert into book_author (author_id, book_id) values (1, 3);
insert into book_author (author_id, book_id) values (1, 4);
