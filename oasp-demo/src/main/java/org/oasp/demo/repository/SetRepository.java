package org.oasp.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.oasp.demo.entity.SetEntity;

import java.util.List;


public interface SetRepository extends CrudRepository<SetEntity, Long> {

    @Query("SELECT S FROM SetEntity S WHERE S.owned = 1")
    List<SetEntity> findOwnedSets();

    @Query("SELECT S FROM SetEntity S WHERE S.wanted = 1")
    List<SetEntity> findWantedSets();

}
