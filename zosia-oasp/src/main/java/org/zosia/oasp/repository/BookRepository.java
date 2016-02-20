package org.zosia.oasp.repository;

import org.springframework.data.repository.CrudRepository;
import org.zosia.oasp.entity.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity, Long>, BookRepositoryCustom {
}
