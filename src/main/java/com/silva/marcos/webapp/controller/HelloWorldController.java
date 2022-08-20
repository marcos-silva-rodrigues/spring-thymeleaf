package com.silva.marcos.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloWorldController {

    @GetMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/hello");
        mv.addObject("name", "Fulano");
        return mv;
    }

    @GetMapping("/new")
    public String newPath(Model model) {
        List<String> list = new ArrayList<String>();
        list.add("Fulano 01");
        list.add("Fulano 02");
        list.add("Fulano 03");
        list.add("Fulano 04");
        list.add("Fulano 05");

        model.addAttribute("name", "Fulano");
        model.addAttribute("list", list);
        return "new";
    }


}
