package com.muratcimen.bookstore.controller;

import com.muratcimen.bookstore.entity.Order;
import com.muratcimen.bookstore.service.OrderService;
import com.muratcimen.config.RateLimited;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @RateLimited
    @GetMapping("/{userId}")
    public ResponseEntity<Object> getOrdersByUserId(@PathVariable Integer userId) {
        try {
            List<Order> orders = orderService.getOrdersByUserId(userId);
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while receiving orders: " + e.getMessage());
        }
    }
    @RateLimited
    @GetMapping("/details/{orderId}")
    public List<Order> getOrdersDetailsByUserId(@PathVariable Integer orderId) {
        throw new BookStoreNotFoundException("Hata oluştu 😅");
    }

    @PostMapping
    public ResponseEntity<Object> placeOrder(@RequestBody Order order) {
        try {
            if (order.getTotal_price() < 25.0) {
                throw new BookStoreNotFoundException("Minimum order price is $25! 💰");
            }

            Order newOrder = orderService.save(order);
            return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
        } catch (BookStoreNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while saving the order: " + e.getMessage());
        }
    }
}