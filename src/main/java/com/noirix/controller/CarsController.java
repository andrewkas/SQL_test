package com.noirix.controller;

import com.noirix.controller.request.CarsCreateRequest;
import com.noirix.controller.request.SearchAtribute;
import com.noirix.domain.Cars;
import com.noirix.service.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarsController {
    private final CarsService carsService;
    private static final String CARS_PAGE = "cars";
    private static final String CARS_CREATE="createcars";
    private static final String CARS_DELETED="deletedcars";
    private static final String CARS_ATTRIBUTE = "cars";

    @GetMapping
    public ModelAndView getAllCars(){
        ModelAndView result =new ModelAndView();
        result.setViewName(CARS_PAGE);
        result.addObject(CARS_ATTRIBUTE,carsService.findAll());
        return result;

    }
    @GetMapping(value = "/search")
    public ModelAndView searchCars(@ModelAttribute SearchAtribute searchAtribute){
        ModelAndView result = new ModelAndView();
        result.setViewName(CARS_PAGE);
        result.addObject(CARS_ATTRIBUTE,carsService.search(searchAtribute.getQuery()).stream().limit(searchAtribute.getLimit())
                .collect(Collectors.toList()));
        return result;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView findByIdCars(@PathVariable("id") Long carsId){
        ModelAndView result = new ModelAndView();
        result.setViewName(CARS_PAGE);
        result.addObject(CARS_ATTRIBUTE,Collections.singletonList(carsService.findById(carsId)));
        return result;
    }
    @GetMapping(value = "/create")
    public ModelAndView getCreateRequest(){
        ModelAndView result = new ModelAndView();
        result.setViewName(CARS_CREATE);
        result.addObject("carsCreateRequest", new CarsCreateRequest());
        return result;
    }



    @PostMapping
    public ModelAndView createCars(@ModelAttribute CarsCreateRequest carsCreateRequest) {

        //converters
        Cars cars = new Cars();
        cars.setModel(carsCreateRequest.getModel());
        cars.setCreationYear(carsCreateRequest.getCreationYear());
        cars.setUserId(carsCreateRequest.getUserId());
        cars.setPrice(carsCreateRequest.getPrice());
        cars.setColor(carsCreateRequest.getColor());
        carsService.save(cars);

        ModelAndView result = new ModelAndView();

        result.setViewName(CARS_PAGE);
        result.addObject(CARS_ATTRIBUTE, carsService.findAll());

        return result;
    }

    @GetMapping (value = "/delete/{id}")
    public ModelAndView deleteCars(@PathVariable("id") Long carsId){

        carsService.delete(carsService.findById(carsId));

        ModelAndView result = new ModelAndView();
        result.setViewName(CARS_DELETED);
        result.addObject("id",carsId);
        return result;
    }



}
