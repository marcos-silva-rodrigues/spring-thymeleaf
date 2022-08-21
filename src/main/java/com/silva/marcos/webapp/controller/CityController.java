package com.silva.marcos.webapp.controller;


import com.silva.marcos.webapp.model.City;
import com.silva.marcos.webapp.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityRepository repository;

    public CityController(CityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String index(Model model) {
        List<City> allCities = repository.findAll();
        model.addAttribute("cities", allCities);
        return "cities/index";
    }

    @GetMapping("/new")
    public String newCity(Model model) {
        model.addAttribute("city", new City());
        return "cities/new";
    }

    @PostMapping
    public String create(@ModelAttribute("city") City city,  Model model) {
        this.repository.save(city);
        return "redirect:/cities";
    }

    @GetMapping("/{id}")
    public String editCity(@PathVariable("id") Long id, Model model) {

        Optional<City> by = this.repository.findById(id);

        model.addAttribute("city", by.get());
        return "cities/edit";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute("city") City city, Model model) {
        Optional<City> byId = this.repository.findById(id);

        if (byId.isPresent()) {
            this.repository.save(city);
        }
        return "redirect:/cities";
    }

    @DeleteMapping("{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Optional<City> city = this.repository.findById(id);

        if (city.isPresent()) {
            this.repository.deleteById(id);
            return "redirect:/cities";
        }

        return "redirect:/cities";
    }
}
