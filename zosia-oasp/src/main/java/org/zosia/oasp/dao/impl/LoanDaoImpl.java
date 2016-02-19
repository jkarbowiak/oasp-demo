package org.zosia.oasp.dao.impl;

import org.springframework.stereotype.Repository;
import org.zosia.oasp.dao.LoanDao;
import org.zosia.oasp.entity.LoanEntity;

@Repository
public class LoanDaoImpl extends AbstractDao<LoanEntity, Long> implements LoanDao {
}
