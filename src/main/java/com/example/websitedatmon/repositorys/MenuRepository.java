package com.example.websitedatmon.repositorys;

import com.example.websitedatmon.domain.Food;
import com.example.websitedatmon.domain.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {
    Menu findMenuById(int id);
    List<Menu> findAll();

    @Query(value = "SELECT * FROM `menu` WHERE date = CURDATE()",nativeQuery = true)
    List<Menu> getToday();

    Menu save(Menu menu);
    void deleteById(int id);
}
