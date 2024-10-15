package com.location_app.demo.app.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Profile("Profile2")
@SpringBootTest
class LocationProviderRedisTest {

    @Autowired
    private LocationProviderRedis locationProviderRedis;

    @Test
    void getAll() {
        assertNotNull(locationProviderRedis.getAll());
    }

    @Test
    void getAllByPostcode() {
        assertNotNull(locationProviderRedis.getAllByPostcode(Set.of("1234-1")));
    }

    @Test
    void getAllByCity() {
        assertNotNull(locationProviderRedis.getAllByCity("City 1"));
    }

    @Test
    void getAllByCountry() {
        assertNotNull(locationProviderRedis.getAllByCountry("Country 1"));
    }

    @Test
    void getAllByState() {
        assertNotNull(locationProviderRedis.getAllByState("State 1"));
    }

    @Test
    void getAllByStreet() {
        assertNotNull(locationProviderRedis.getAllByStreet("Street 1"));
    }

    @Test
    void getByPostcode() {
        assertNotNull(locationProviderRedis.getByPostcode("1234-1"));
    }
}
