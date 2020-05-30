package com.nhatdinhnguyen.bicycleproject.db.domain;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class OrderItemPk implements Serializable {

    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "item_id")
    private Integer itemId;

    public OrderItemPk() {}

    public OrderItemPk(Integer orderId, Integer itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "OrderItemPk{" +
                "orderId=" + orderId +
                ", itemId=" + itemId +
                '}';
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}
