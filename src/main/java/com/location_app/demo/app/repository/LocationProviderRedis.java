package com.location_app.demo.app.repository;

import com.location_app.demo.app.domain.Location;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
@Profile("Profile2")
@RequiredArgsConstructor
public class LocationProviderRedis implements LocationProvider {

    private final RedisRepository redisRepository;

    @Override
    public Set<Location> getAll() {
        return StreamSupport.stream(redisRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
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
