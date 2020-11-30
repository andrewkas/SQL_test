package com.noirix.controller;

import com.noirix.controller.request.CarsChangeRequest;
import com.noirix.controller.request.CarsCreateRequest;
import com.noirix.controller.request.SearchAtribute;
import com.noirix.domain.Cars;
import com.noirix.service.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/cars")
@RequiredArgsConstructor
public class CarsRestController {
    public final CarsService carsService;

    @GetMapping
    public ResponseEntity<List<Cars>> getAllCars(){
        return new ResponseEntity<>(carsService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cars getCarsById(@PathVariable Long id){
        return carsService.findById(id);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<Cars> searchCars (@ModelAttribute SearchAtribute atribute){
        return carsService.search(atribute.getQuery());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cars createCars(@RequestBody CarsCreateRequest carsCreateRequest){
        Cars cars =new Cars();
        cars.setModel(carsCreateRequest.getModel());
        cars.setCreationYear(carsCreateRequest.getCreationYear());
        cars.setUserId(carsCreateRequest.getUserId());
        cars.setPrice(carsCreateRequest.getPrice());
        cars.setColor(carsCreateRequest.getColor());
        return carsService.save(cars);
    }

    @PutMapping ("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cars updateCarsById(@PathVariable long id, @RequestBody CarsCreateRequest carsCreateRequest){
        Cars cars = carsService.findById(id);

        cars.setModel(carsCreateRequest.getModel());
        cars.setCreationYear(carsCreateRequest.getCreationYear());
        cars.setUserId(carsCreateRequest.getUserId());
        cars.setPrice(carsCreateRequest.getPrice());
        cars.setColor(carsCreateRequest.getColor());

        return carsService.update(cars);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Cars updateCars (@RequestBody CarsChangeRequest carsChangeRequest){
        Cars cars = carsService.findById(carsChangeRequest.getId());

        cars.setModel(carsChangeRequest.getModel());
        cars.setCreationYear(carsChangeRequest.getCreationYear());
        cars.setUserId(carsChangeRequest.getUserId());
        cars.setPrice(carsChangeRequest.getPrice());
        cars.setColor(carsChangeRequest.getColor());

        return carsService.update(cars);
    }




}
