package com.nhatdinhnguyen.bicycleproject.db.repo;

import com.nhatdinhnguyen.bicycleproject.db.domain.OrderItem;
import com.nhatdinhnguyen.bicycleproject.db.domain.OrderItemPk;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItem, OrderItemPk> {
    List<OrderItem> findByOrder_Id(Integer id);
}
