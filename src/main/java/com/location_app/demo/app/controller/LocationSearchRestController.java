package com.location_app.demo.app.controller;

import com.location_app.demo.app.domain.Location;
import com.location_app.demo.app.service.LocationSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class LocationSearchRestController {

    private final LocationSearchService locationSearchService;

    @GetMapping("/locations")
    public Set<Location> getLocations() {
        return locationSearchService.getLocations();
    }

    @GetMapping("/locations/search")
    public Set<Location> getLocationsByPostcode(@RequestParam("cep") Set<String> postcodeList) {
        return locationSearchService.getLocations(postcodeList);
    }

    @GetMapping("/postcode/search")
    public Set<Location> getPostcodeByLocation(@RequestParam(name = "country", required = false) String country,
                                               @RequestParam(name = "state", required = false) String state,
                                               @RequestParam(name = "city", required = false) String city,
                                               @RequestParam(name = "street", required = false) String street) {
        return locationSearchService.getPostcode(country, state, city, street);
    }

}
