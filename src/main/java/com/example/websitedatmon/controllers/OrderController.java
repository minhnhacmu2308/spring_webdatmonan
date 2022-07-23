package com.example.websitedatmon.controllers;

import com.example.websitedatmon.domain.Food;
import com.example.websitedatmon.domain.Menu;
import com.example.websitedatmon.domain.Order;
import com.example.websitedatmon.domain.Post;
import com.example.websitedatmon.serviceImpls.OrderServiceImpl;
import com.example.websitedatmon.utils.FileUtil;
import com.example.websitedatmon.utils.Middleware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    Middleware middleware = new Middleware();

    @GetMapping({ "/order"})
    public ModelAndView index(String msg)
    {
        ModelAndView mv = new ModelAndView("order");
        Sort sort = Sort.by("id").descending();
        List<Order> list = orderService.findAll(sort);
        mv.addObject("msg",msg);
        mv.addObject("list",list);
        return mv;
    }

    @GetMapping({ "/history"})
    public ModelAndView history(String msg)
    {
        ModelAndView mv = new ModelAndView("history");
        Sort sort = Sort.by("id").descending();
        List<Order> list = orderService.findAll(sort);
        mv.addObject("msg",msg);
        mv.addObject("list",list);
        return mv;
    }

    @PostMapping(value = "/order-edit")
    public ModelAndView update(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:order");
        int status = Integer.parseInt(request.getParameter("status"));
        int id = Integer.parseInt(request.getParameter("id"));
        Order order = orderService.findOrderById(id);
        order.setStatus(status);
        orderService.save(order);
        mv.addObject("msg","success");
        return mv;
    }
}
