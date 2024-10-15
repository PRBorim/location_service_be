package com.location_app.demo.app.service;

import com.location_app.demo.app.domain.Location;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface LocationSearchService {

     Set<Location> getLocations();
     Set<Location> getLocations(Set<String> postcodeList);
     Set<Location> getPostcode(String country, String state, String city, String street);

}
