package com.example.websitedatmon.serviceImpls;

import com.example.websitedatmon.domain.Order;
import com.example.websitedatmon.domain.Post;
import com.example.websitedatmon.domain.User;
import com.example.websitedatmon.repositorys.OrderRepository;
import com.example.websitedatmon.repositorys.PostRepository;
import com.example.websitedatmon.services.OrderService;
import com.example.websitedatmon.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order findOrderById(int id) {
        return orderRepository.findOrderById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findOrderByUser(User user) {
        return orderRepository.findOrderByUser(user);
    }

    @Override
    public List<Order> findAll(Sort sort) {
        return orderRepository.findAll(sort);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }
}
