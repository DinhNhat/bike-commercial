package com.nhatdinhnguyen.bicycleproject.db.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stocks")
public class Stock {
    @EmbeddedId
    private StockPk pk;

    @ManyToOne
    @MapsId("store_id")
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    public Stock() {}

    public Stock(StockPk pk, Integer quantity) {
        this.pk = pk;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "pk=" + pk +
                ", quantity=" + quantity +
                '}';
    }

    public StockPk getPk() {
        return pk;
    }

    public void setPk(StockPk pk) {
        this.pk = pk;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
