package org.zosia.oasp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.zosia.oasp.entity.BookExemplarEntity;

import java.util.Collection;

public interface BookExemplarRepository extends CrudRepository<BookExemplarEntity, Long> {

    @Query("select exemplar from BookExemplarEntity exemplar where exemplar.book.id = :bookId")
    Collection<BookExemplarEntity> findAllBookExemplars(@Param("bookId") long bookId);

}
