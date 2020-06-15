package com.nhatdinhnguyen.bicycleproject.web;

import com.nhatdinhnguyen.bicycleproject.db.domain.Customer;
import com.nhatdinhnguyen.bicycleproject.db.domain.Person;
import com.nhatdinhnguyen.bicycleproject.db.repo.CustomerRepository;
import org.hibernate.loader.custom.NonScalarResultColumnProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerApiController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/showLimit5")
    public Iterable<Customer> showLimit5Customers(){
        return this.customerRepository.getTheFirst10Customer();
    }

    @GetMapping(path = "/{lastName}")
    public List<Customer> getByLastName(@PathVariable("lastName") String lastName) throws NoSuchElementException {
        List<Customer> customerList = customerRepository.findAll(Example.of(new Customer(new Person(lastName))));
        if(customerList.size() > 0)
            return customerList;
        else
            throw new NoSuchElementException("Customer does not exist with this last name " + lastName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody Customer customer) {
        this.customerRepository.save(customer);
    }

//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(NoSuchElementException.class)
//    public String return400(NoSuchElementException ex) {
//        return ex.getMessage();
//    }

}
