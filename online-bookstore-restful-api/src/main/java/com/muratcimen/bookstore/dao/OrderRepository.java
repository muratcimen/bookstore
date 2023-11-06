package com.muratcimen.bookstore.dao;

import com.muratcimen.bookstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findByUserIdOrderByUpdatedDesc(Integer userId);

  //  List<Order> findBy(Integer userId);

}
