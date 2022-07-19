package com.example.websitedatmon.controllers;

import com.example.websitedatmon.domain.Food;
import com.example.websitedatmon.domain.Post;
import com.example.websitedatmon.serviceImpls.FoodServiceImpl;
import com.example.websitedatmon.serviceImpls.PostServiceImpl;
import com.example.websitedatmon.utils.FileUtil;
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
public class FoodController {
    @Autowired
    FoodServiceImpl foodService;

    @GetMapping({ "/food"})
    public ModelAndView index(String msg)
    {
        List<Food> list = foodService.findAll();
        ModelAndView mv = new ModelAndView("food");
        mv.addObject("msg",msg);
        mv.addObject("list",list);
        return mv;
    }

    @PostMapping(value = "/food-add")
    public ModelAndView add(HttpServletRequest request, @RequestParam("file") MultipartFile image){
        ModelAndView mv = new ModelAndView("redirect:food");
        String name = request.getParameter("name");
        String desciption = request.getParameter("description");
        Food post = new Food();
        post.setName(name);
        post.setDescription(desciption);
        post.setCreatedAt(java.time.LocalDate.now());
        String fileName = "";
        try {
            fileName = FileUtil.upload(image,request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        post.setImage(fileName);
        foodService.save(post);
        mv.addObject("msg","success");
        return mv;
    }
    @PostMapping(value = "/food-update")
    public ModelAndView update(HttpServletRequest request,@RequestParam("file") MultipartFile image){
        ModelAndView mv = new ModelAndView("redirect:food");
        String name = request.getParameter("name");
        String desciption = request.getParameter("description");
        int id = Integer.parseInt(request.getParameter("id"));
        String fileName = "";
        if(image.isEmpty()) {
            Food Food = foodService.findFoodById(id);
            fileName = Food.getImage();
        } else {
            try {
                fileName = FileUtil.upload(image,request);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Food postud = foodService.findFoodById(id);
        postud.setName(name);
        postud.setDescription(desciption);
        postud.setImage(fileName);
        foodService.save(postud);
        mv.addObject("msg","success");
        return mv;
    }
    @PostMapping(value = "/food-delete")
    public ModelAndView delete(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:food");
        String id = request.getParameter("id");
        int idc = Integer.parseInt(id);
        foodService.deleteById(idc);
        mv.addObject("msg", "success");
        return mv;
    }
}
