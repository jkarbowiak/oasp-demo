package org.oasp.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.oasp.demo.entity.PieceEntity;


public interface PieceRepository extends CrudRepository<PieceEntity, Long> {

}
