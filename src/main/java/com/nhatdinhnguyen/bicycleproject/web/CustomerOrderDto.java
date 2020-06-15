package com.nhatdinhnguyen.bicycleproject.web;

import java.util.Date;

public class CustomerOrderDto {
    private Integer custId;
    private Integer orderId;
    private Integer orderStatus;
    private Date orderDate;
    private Double aveListPrice;

    public CustomerOrderDto() {
        super();
    }

    public CustomerOrderDto(Integer custId, Integer orderId,
                            Integer orderStatus, Date orderDate, Double aveListPrice) {
        super();
        this.custId = custId;
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.aveListPrice = aveListPrice;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getAveListPrice() {
        return aveListPrice;
    }

    public void setAveListPrice(Double aveListPrice) {
        this.aveListPrice = aveListPrice;
    }
}
