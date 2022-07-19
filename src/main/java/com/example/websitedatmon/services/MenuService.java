package com.example.websitedatmon.services;

import com.example.websitedatmon.domain.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {
    Menu findMenuById(int id);
    List<Menu> findAll();
    Menu save(Menu menu);
    void deleteById(int id);
    List<Menu> getToday();
}
