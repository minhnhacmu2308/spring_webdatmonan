package com.example.websitedatmon.controllers;

import com.example.websitedatmon.domain.Food;
import com.example.websitedatmon.domain.Menu;
import com.example.websitedatmon.serviceImpls.FoodServiceImpl;
import com.example.websitedatmon.serviceImpls.MenuServiceImpl;
import com.example.websitedatmon.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class MenuController {
    @Autowired
    MenuServiceImpl menuService;

    @Autowired
    FoodServiceImpl foodService;

    @GetMapping({ "/menu"})
    public ModelAndView index(String msg)
    {
        List<Menu> list = menuService.getToday();
        List<Food> listF = foodService.findAll();
        ModelAndView mv = new ModelAndView("menu");
        mv.addObject("msg",msg);
        mv.addObject("list",list);
        mv.addObject("listF",listF);
        return mv;
    }

    @PostMapping(value = "/menu-add")
    public ModelAndView add(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:menu");
        int id = Integer.parseInt(request.getParameter("idfood"));
        Food food = foodService.findFoodById(id);
        String date = request.getParameter("date");
        Menu menu = new Menu();
        menu.setFood(food);
        menu.setDate(java.time.LocalDate.now().toString());
        menu.setStatus(1);
        menuService.save(menu);
        mv.addObject("msg","success");
        return mv;
    }
}