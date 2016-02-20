package org.zosia.oasp.repository;

import org.springframework.data.repository.CrudRepository;
import org.zosia.oasp.entity.AuthorEntity;

public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
}
