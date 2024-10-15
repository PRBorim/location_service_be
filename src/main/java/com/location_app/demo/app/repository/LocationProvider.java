package com.location_app.demo.app.repository;

import com.location_app.demo.app.domain.Location;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LocationProvider {

    Set<Location> getAll();
    Set<Location> getAllByPostcode(Set<String> postcodeList);
    Set<Location> getAllByCity(String city);
    Set<Location> getAllByCountry(String country);
    Set<Location> getAllByState(String state);
    Set<Location> getAllByStreet(String street);
    Location getByPostcode(String postcode);
}
