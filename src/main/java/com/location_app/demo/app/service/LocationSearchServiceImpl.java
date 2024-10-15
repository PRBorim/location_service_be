package com.location_app.demo.app.service;

import com.location_app.demo.app.domain.Location;
import com.location_app.demo.app.repository.LocationProvider;
import com.location_app.demo.logging.service.LogSearchService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LocationSearchServiceImpl implements LocationSearchService {

    private final LocationProvider locationProvider;
    private final LogSearchService logSearchService;

    public Set<Location> getLocations() {
        return loggingResult(List.of("all"), locationProvider.getAll());
    }

    public Set<Location> getLocations(Set<String> postcodeList) {
        return loggingResult(postcodeList, locationProvider.getAllByPostcode(postcodeList));
    }

    public Set<Location> getPostcode(String country, String state,
                                     String city, String street) {
        Set<Location> searchResult = new HashSet<>();

        if (StringUtils.isNotBlank(street)) {
            searchResult = locationProvider.getAllByStreet(street);
        } else if (StringUtils.isNotBlank(city)) {
            searchResult = locationProvider.getAllByCity(city);
        } else if (StringUtils.isNotBlank(state)) {
            searchResult = locationProvider.getAllByState(state);
        } else if (StringUtils.isNotBlank(country)) {
            searchResult = locationProvider.getAllByCountry(country);
        }

        return loggingResult(Arrays.asList(country, state, city, street), searchResult);
    }

    private Set<Location> loggingResult(Collection<String> search, Set<Location> result) {
        logSearchService.logSearch(search, result);
        return result;
    }

}
