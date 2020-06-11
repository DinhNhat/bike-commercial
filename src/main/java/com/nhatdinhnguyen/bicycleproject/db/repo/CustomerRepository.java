package com.nhatdinhnguyen.bicycleproject.db.repo;

import com.nhatdinhnguyen.bicycleproject.db.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.Max;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    // using JPQL for searching last name like
    @Query("select cus from Customer cus where cus.person.lastName like ':lastName'")
    List<Customer> searchForLastNameLike(@Param("lastName") String lastName);

    // using native Query with MySQL syntax
    @Query(value = "SELECT * FROM customers cus WHERE phone is not null", nativeQuery = true)
    List<Customer> searchPhoneIsNotNull();

    @Query(value = "SELECT * FROM customers WHERE state = 'CA' AND last_name like '%man%'", nativeQuery = true)
    List<Customer> searchForStateAndLastNameLike();

    @Query(value = "SELECT * FROM customers LIMIT 10, 5", nativeQuery = true)
    List<Customer> getTheFirst10Customer();
}
