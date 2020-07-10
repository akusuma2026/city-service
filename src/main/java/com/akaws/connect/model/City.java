package com.akaws.connect.model;

import org.springframework.stereotype.Component;

/**
 * City - has origin and destination
 * @Author @akusuma20206
 * created on 07/10/2020
 */

@Component
public class City {
    private String origin;
    private String destination;

    public City(){

    }


    public City(String origin, String destination){
        this.origin = origin;
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "City{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
