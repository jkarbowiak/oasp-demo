package org.zosia.oasp.dao.impl;

import org.springframework.stereotype.Repository;
import org.zosia.oasp.dao.AuthorDao;
import org.zosia.oasp.entity.AuthorEntity;

@Repository
public class AuthorDaoImpl extends AbstractDao<AuthorEntity, Long> implements AuthorDao {
}
