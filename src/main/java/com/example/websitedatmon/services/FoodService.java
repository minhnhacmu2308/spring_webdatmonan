package com.example.websitedatmon.services;

import com.example.websitedatmon.domain.Food;
import com.example.websitedatmon.domain.Post;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodService {
    Food findFoodById(int id);
    List<Food> findAll();
//    List<Food> findAll(Sort sort);
    Food save(Food food);
    void deleteById(int id);
}
