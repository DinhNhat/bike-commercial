package com.nhatdinhnguyen.bicycleproject.db.repo;

import com.nhatdinhnguyen.bicycleproject.db.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> findByCustomer_Id(@Param("id") int id);

    List<Order> findByCustomer_State(@Param("state") String state);

    List<Order> findByOrderDateGreaterThan(@Param("orderDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date orderDate);

    @Query("select od from Order od where od.customer.person.lastName = :lastName")
    List<Order> searchForCustomerLastName(@Param("lastName") String lastName);

    Page<Order> findByStatus(@Param("status") int status, Pageable pageable);

    @Query("select ord from Order ord where ord.orderDate between '2018-07-01' and '2018-12-01'")
    List<Order> searchForCertainOrderDate();
}
