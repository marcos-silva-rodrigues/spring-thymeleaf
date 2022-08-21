package com.silva.marcos.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cities")
public class CityController {

    @GetMapping
    public String index(Model model) {
        return "cities/index";
    }

    @GetMapping("/new")
    public String newCity(Model model) {
        return "cities/new";
    }

    @GetMapping("/{id}")
    public String editCity(@PathVariable("id") Long id, Model model) {
        return "cities/edit";
    }
}
