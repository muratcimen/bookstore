package com.muratcimen.bookstore.service;

import com.muratcimen.bookstore.entity.Order;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface OrderService {

    public List<Order> getOrdersByUserId(@PathVariable Integer userId);

    public Order save(Order order);

}
