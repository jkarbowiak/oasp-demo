package org.zosia.oasp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zosia.oasp.dao.CustomerCardDao;
import org.zosia.oasp.entity.CustomerCardEntity;
import org.zosia.oasp.mapper.CustomerCardMapper;
import org.zosia.oasp.service.CustomerCardService;
import org.zosia.oasp.to.CustomerCardTo;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerCardServiceImpl implements CustomerCardService {

    private final CustomerCardDao customerCardDao;
    private final CustomerCardMapper customerCardMapper;

    @Autowired
    public CustomerCardServiceImpl(CustomerCardDao customerCardDao, CustomerCardMapper customerCardMapper) {
        this.customerCardDao = customerCardDao;
        this.customerCardMapper = customerCardMapper;
    }

    @Override
    public List<CustomerCardTo> getAllCustomerCards() {
        List<CustomerCardEntity> customerCards = customerCardDao.findAll();
        return new ArrayList<>(customerCardMapper.mapSourceCollection(customerCards));
    }
}
