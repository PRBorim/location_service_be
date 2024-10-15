package com.location_app.demo.app.repository;

import com.location_app.demo.app.domain.Location;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
@Profile("Profile1")
public class LocationProviderMock implements LocationProvider {
    private final RestClient restClient;

    @Autowired
    public LocationProviderMock(@Value("${location.provider.mock.url}") String mockUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(mockUrl)
                .build();
    }

    @Override
    public Set<Location> getAll() {
        return restClient.get()
                .uri("/v1/locations")
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }

    @Override
    public Set<Location> getAllByPostcode(Set<String> postcodeList) {
        return getAll().stream()
                .filter(location -> CollectionUtils.emptyIfNull(postcodeList).contains(location.getPostcode()))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Location> getAllByCity(String city) {
        return getAll().stream()
                .filter(location -> location.getCity().equals(city))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Location> getAllByCountry(String country) {
        return getAll().stream()
                .filter(location -> location.getCountry().equals(country))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Location> getAllByState(String state) {
        return getAll().stream()
                .filter(location -> location.getState().equals(state))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Location> getAllByStreet(String street) {
        return getAll().stream()
                .filter(location -> location.getStreet().equals(street))
                .collect(Collectors.toSet());
    }

    @Override
    public Location getByPostcode(String postcode) {
        return getAll().stream()
                .filter(location -> location.getPostcode().equals(postcode))
                .findAny()
                .orElse(null);
    }

}
