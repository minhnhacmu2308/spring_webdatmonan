package com.example.websitedatmon.repositorys;

import com.example.websitedatmon.domain.Order;
import com.example.websitedatmon.domain.Post;
import com.example.websitedatmon.domain.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    Order findOrderById(int id);
    List<Order> findAll();
    List<Order> findOrderByUser(User user);
    List<Order> findAll(Sort sort);
    Order save(Order order);
    void deleteById(int id);
}
