package com.nhatdinhnguyen.bicycleproject.web;

import com.nhatdinhnguyen.bicycleproject.db.domain.Customer;
import com.nhatdinhnguyen.bicycleproject.db.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerApiController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/showLimit5")
    public Iterable<Customer> showLimit5Customers(){
        return this.customerRepository.getTheFirst10Customer();
    }

}
