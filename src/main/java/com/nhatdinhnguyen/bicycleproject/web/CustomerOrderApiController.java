package com.nhatdinhnguyen.bicycleproject.web;

import com.nhatdinhnguyen.bicycleproject.db.domain.Customer;
import com.nhatdinhnguyen.bicycleproject.db.domain.Order;
import com.nhatdinhnguyen.bicycleproject.db.domain.OrderItem;
import com.nhatdinhnguyen.bicycleproject.db.repo.CustomerRepository;
import com.nhatdinhnguyen.bicycleproject.db.repo.OrderItemRepository;
import com.nhatdinhnguyen.bicycleproject.db.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/CustOrders")
public class CustomerOrderApiController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/{custId}")
    public List<CustomerOrderDto> getOrderByCustomerId(@PathVariable("custId") Integer custId) {
        if (this.customerRepository.findById(custId).isPresent()) {
            return this.orderRepository.findByCustomer_Id(custId).stream().map(el -> toCustomerOrderDto(el)).collect(Collectors.toList());
        }
        else
            throw new NoSuchElementException("Customer not found with id: " + custId);
    }

    private CustomerOrderDto toCustomerOrderDto(Order order) {
        double result = averageListPriceByOrderId(order.getId());
        return new CustomerOrderDto(order.getCustomer().getId(), order.getId(), order.getStatus(), order.getOrderDate(), result);
    }

    public double averageListPriceByOrderId(int orderId) {
        List<OrderItem> orderItemList = this.orderItemRepository.findByOrder_Id(orderId);
        OptionalDouble average = orderItemList.stream().mapToDouble(OrderItem::getListPrice).average();
        return average.isPresent() ? average.getAsDouble() : null;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }


}
