package org.zosia.oasp.service;

import org.zosia.oasp.to.CustomerTo;

import java.util.List;

public interface CustomerService {

    CustomerTo createCustomer(CustomerTo customer);

    List<CustomerTo> findAllCustomers();

    void deleteCustomer(long customerId);
}
