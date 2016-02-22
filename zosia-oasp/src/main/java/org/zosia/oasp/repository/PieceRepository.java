package org.zosia.oasp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zosia.oasp.entity.PieceEntity;
import org.zosia.oasp.entity.SetEntity;

import java.util.List;


public interface PieceRepository extends CrudRepository<PieceEntity, Long> {

}
