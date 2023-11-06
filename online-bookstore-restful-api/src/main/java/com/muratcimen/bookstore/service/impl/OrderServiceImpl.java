package com.muratcimen.bookstore.service.impl;

import com.muratcimen.bookstore.dao.OrderRepository;
import com.muratcimen.bookstore.entity.Order;
import com.muratcimen.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersByUserId(@PathVariable Integer userId) {
        return orderRepository.findByUserIdOrderByUpdatedDesc(userId);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
