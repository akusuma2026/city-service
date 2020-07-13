package com.akaws.connect.controller;

import com.akaws.connect.model.City;
import com.akaws.connect.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author @akusuma20206
 * created on 07/10/2020
 */

@RestController
public class ConnectController {

    @Autowired
    private CityRepository repository;


    @RequestMapping("/")
    public String index() {
        return "Welcome to My App";
    }


    /**
     * method accepts origin city and destination city as input
     *
     * @param origin
     * @param destination
     * @return
     */


    @GetMapping("/connected")
    public String cityConnected(@RequestParam(name = "origin") String origin, @RequestParam(name = "destination") String destination) {

        City result =  repository.findAll().stream()
                .filter(c -> origin.equals(c.getOrigin()))
                .filter(c -> destination.equals(c.getDestination()))
                .findAny()
                .orElse(null);

           return  (result != null ? "Yes" : "No");

    }


    /**
     * List of end points which tells
     * connected cities
     * @return
     */
    @GetMapping("/cities")
    @ResponseBody
    public List<City> listOfCities() {
        return repository.findAll();
    }

}
