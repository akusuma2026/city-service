package com.akaws.connect.repository;

import com.akaws.connect.model.City;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * CityRepository - holds list of City objects
 * which are connected and acts as a repository
 * @Author @akusuma20206
 * created on 07/10/2020
 */

@Component
public class CityRepository  {

    private List<City> cityList = new ArrayList<>();

    public  void deleteAll(){
        cityList.clear();
    }

    public void save(City city){
        cityList.add(city);
    }

    public List<City> findAll(){
        return cityList;
    }

}