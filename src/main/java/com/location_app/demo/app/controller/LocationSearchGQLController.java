package com.location_app.demo.app.controller;

import com.location_app.demo.app.domain.Location;
import com.location_app.demo.app.service.LocationSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Set;

@Controller
@RequiredArgsConstructor
public class LocationSearchGQLController {

    private final LocationSearchService locationSearchService;

    @QueryMapping
    public Set<Location> locations() {
        return locationSearchService.getLocations();
    }

    @QueryMapping
    public Set<Location> locationsByPostcode(@Argument Set<String> postcodeList) {
        return locationSearchService.getLocations(postcodeList);
    }

    @QueryMapping
    public Set<Location> postcodeByLocation(@Argument String country, @Argument String state,
                                            @Argument String city, @Argument String street) {
        return locationSearchService.getPostcode(country, state, city, street);
    }

}
