package org.zosia.oasp.dao.impl;

import org.springframework.stereotype.Repository;
import org.zosia.oasp.dao.CustomerDao;
import org.zosia.oasp.entity.CustomerEntity;

@Repository
public class CustomerDaoImpl extends AbstractDao<CustomerEntity, Long> implements CustomerDao {
}
