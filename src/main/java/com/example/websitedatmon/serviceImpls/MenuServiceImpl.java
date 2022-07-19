package com.example.websitedatmon.serviceImpls;

import com.example.websitedatmon.domain.Menu;
import com.example.websitedatmon.domain.Post;
import com.example.websitedatmon.repositorys.MenuRepository;
import com.example.websitedatmon.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Override
    public Menu findMenuById(int id) {
        return menuRepository.findMenuById(id);
    }

    @Override
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public List<Menu> getToday() {
        return menuRepository.getToday();
    }


    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void deleteById(int id) {
        menuRepository.deleteById(id);
    }
}
