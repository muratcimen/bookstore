package com.muratcimen.bookstore.dao;

import com.muratcimen.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
