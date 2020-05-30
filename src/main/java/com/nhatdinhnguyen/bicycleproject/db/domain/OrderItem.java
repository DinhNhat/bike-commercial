package com.nhatdinhnguyen.bicycleproject.db.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_items")
public class OrderItem implements Serializable {
    @EmbeddedId
    private OrderItemPk pk;

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "list_price")
    private Double listPrice;
    @Column(name = "discount")
    private Double discount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderItem() {}

    public OrderItem(OrderItemPk pk, Integer quantity, Double listPrice, Double discount, Product product) {
        this.pk = pk;
        this.quantity = quantity;
        this.listPrice = listPrice;
        this.discount = discount;
        this.product = product;
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
        return "OrderItem{" +
                "pk=" + pk +
                ", quantity=" + quantity +
                ", listPrice=" + listPrice +
                ", discount=" + discount +
                ", product=" + product +
                '}';
    }

    public OrderItemPk getPk() {
        return pk;
    }

    public void setPk(OrderItemPk pk) {
        this.pk = pk;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
