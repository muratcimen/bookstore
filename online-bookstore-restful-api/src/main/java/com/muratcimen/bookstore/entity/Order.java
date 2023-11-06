package com.muratcimen.bookstore.entity;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;

    @Column(name = "user_id", insertable = false, updatable = false)
    private int user_id;

    @Column(name = "total_price")
    private Double total_price;

    @Column(name = "books")
    @ElementCollection
    private List<Book> listOfBooks;

    @Column(name = "order_date")
    private Date order_date;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated;

    public Order(){

    }

    public Order(int user_id, Double total_price, List<Book> listOfBooks, Date order_date, Date created_at, Date updated_at) {
        this.user_id = user_id;
        this.total_price = total_price;
        this.listOfBooks = listOfBooks;
        this.order_date = order_date;
        this.created_at = created_at;
        this.updated = updated_at;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated = updated_at;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", total_price=" + total_price +
                ", listOfBooks=" + listOfBooks +
                ", order_date=" + order_date +
                ", created_at=" + created_at +
                ", updated_at=" + updated +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
