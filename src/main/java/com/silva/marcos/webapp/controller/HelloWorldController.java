package com.silva.marcos.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HelloWorldController {

    @GetMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/hello");
        return mv;
    }

    @GetMapping("/new")
    public String newPath(Model model) {
        return "new";
    }


}
