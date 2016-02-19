package org.zosia.oasp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zosia.oasp.dao.CustomerDao;
import org.zosia.oasp.entity.CustomerEntity;
import org.zosia.oasp.mapper.CustomerMapper;
import org.zosia.oasp.service.CustomerService;
import org.zosia.oasp.to.CustomerTo;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerDao customerDao) {
        this.customerMapper = customerMapper;
        this.customerDao = customerDao;
    }

    @Override
    public CustomerTo createCustomer(CustomerTo customerTo) {
        CustomerEntity customerEntity = customerMapper.mapTarget(customerTo);
        customerDao.save(customerEntity);
        return customerMapper.mapSource(customerEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerTo> findAllCustomers() {
        List<CustomerEntity> customerEntities = customerDao.findAll();
        return new ArrayList<>(customerMapper.mapSourceCollection(customerEntities));
    }

    @Override
    public void deleteCustomer(long customerId) {
        CustomerEntity customerEntity = customerDao.find(customerId);
        customerEntity.getLoans().forEach(loan -> loan.getBookExemplars().forEach(bookExemplar -> bookExemplar.setLoan(null)));
        customerDao.delete(customerEntity);
    }
}
