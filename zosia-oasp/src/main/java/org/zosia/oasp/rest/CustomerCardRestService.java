package org.zosia.oasp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zosia.oasp.service.CustomerCardService;
import org.zosia.oasp.to.CustomerCardTo;

import java.util.List;

@RestController
public class CustomerCardRestService {

    private final CustomerCardService customerCardService;

    @Autowired
    public CustomerCardRestService(CustomerCardService customerCardService) {
        this.customerCardService = customerCardService;
    }

    @RequestMapping(value = "/customer-cards", method = RequestMethod.GET)
    public List<CustomerCardTo> getAllCustomerCards() {
        return customerCardService.getAllCustomerCards();
    }
}
