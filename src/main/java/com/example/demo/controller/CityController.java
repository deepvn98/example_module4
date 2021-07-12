package com.example.demo.controller;

import com.example.demo.model.City;

import com.example.demo.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
@CrossOrigin(origins = "*")
public class CityController {
    @Autowired
    ICityService cityService;

    @PostMapping("/create")
    public ResponseEntity<?> createCity(@RequestBody City city) {
        return new ResponseEntity<>(cityService.save(city), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCity(){
        List<City> cities = (List<City>) cityService.getAll();
        return new ResponseEntity<>(cities,HttpStatus.OK);

    }


    @PutMapping("/{id}/edit")
    public ResponseEntity<?> updateCity(@PathVariable Long id,@RequestBody City city){
        Optional<City> city1 = cityService.getByID(id);
        if (!city1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            city.setId(city1.get().getId());
            return new ResponseEntity<>(cityService.save(city),HttpStatus.OK);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable Long id){
        Optional<City> city = cityService.getByID(id);
        if (!city.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            cityService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
}
