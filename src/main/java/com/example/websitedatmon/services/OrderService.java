package com.example.websitedatmon.services;

import com.example.websitedatmon.domain.Order;
import com.example.websitedatmon.domain.Post;
import com.example.websitedatmon.domain.User;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order findOrderById(int id);
    List<Order> findAll();
    List<Order> findOrderByUser(User user);
    List<Order> findAll(Sort sort);
    Order save(Order order);
    void deleteById(int id);
}
