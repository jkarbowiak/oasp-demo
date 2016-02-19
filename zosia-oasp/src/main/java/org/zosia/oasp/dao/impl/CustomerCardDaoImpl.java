package org.zosia.oasp.dao.impl;

import org.springframework.stereotype.Repository;
import org.zosia.oasp.dao.CustomerCardDao;
import org.zosia.oasp.entity.CustomerCardEntity;

@Repository
public class CustomerCardDaoImpl extends AbstractDao<CustomerCardEntity, Long> implements CustomerCardDao {

}
