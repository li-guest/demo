package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Edward Gavin
 * @Create: 2019-09-12 11:38
 */
@Controller
public class HelloController {
    @GetMapping("/index")
    public String index(@RequestParam(name = "name", defaultValue = "World")String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

}
