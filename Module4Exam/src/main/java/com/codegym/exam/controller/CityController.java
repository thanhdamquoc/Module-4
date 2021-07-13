package com.codegym.exam.controller;

import com.codegym.exam.model.City;
import com.codegym.exam.service.city.CityService;
import com.codegym.exam.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ModelAndView showList() {
        return new ModelAndView("city/list", "cities", cityService.findAll());
    }

    @GetMapping("/{cityId}")
    public ModelAndView viewDetails(@PathVariable Long cityId) {
        Optional<City> cityOptional = cityService.findById(cityId);
        if (!cityOptional.isPresent()) {
            return new ModelAndView("404");
        }
        return new ModelAndView("city/view", "city", cityOptional.get());
    }

    @GetMapping("/{cityId}/edit")
    public ModelAndView showEditCityPage(@PathVariable Long cityId) {
        Optional<City> cityOptional = cityService.findById(cityId);
        if (!cityOptional.isPresent()) {
            return new ModelAndView("404");
        }
        ModelAndView modelAndView = new ModelAndView("city/edit");
        modelAndView.addObject("city", cityOptional.get());
        modelAndView.addObject("countries", countryService.findAll());
        return modelAndView;
    }

    @PostMapping("/{cityId}/edit")
    public ModelAndView updateCity(@PathVariable Long cityId, @Validated @ModelAttribute City city, BindingResult bindingResult) {
        Optional<City> cityOptional = cityService.findById(cityId);
        if (!cityOptional.isPresent()) {
            return new ModelAndView("404");
        }
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("city/edit","countries", countryService.findAll());
        }
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("city/edit");
        modelAndView.addObject("city", cityOptional.get());
        modelAndView.addObject("countries", countryService.findAll());
        modelAndView.addObject("message", "Updated successfully!");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showAddCityPage() {
        ModelAndView modelAndView = new ModelAndView("city/add");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("countries", countryService.findAll());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addNewCity(@Validated @ModelAttribute City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("city/add", "countries", countryService.findAll());
        }
        cityService.save(city);
        return new ModelAndView("city/list", "cities", cityService.findAll());
    }

    @GetMapping("/{cityId}/remove")
    public ModelAndView removeCity(@PathVariable Long cityId) {
        cityService.deleteById(cityId);
        return new ModelAndView("city/list", "cities", cityService.findAll());
    }
}
