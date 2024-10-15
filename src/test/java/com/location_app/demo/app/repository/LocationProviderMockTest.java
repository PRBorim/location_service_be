package com.location_app.demo.app.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Profile("Profile1")
@SpringBootTest
class LocationProviderMockTest {

    @Autowired
    private LocationProviderMock locationProviderMock;

    @Test
    void getAll() {
        assertNotNull(locationProviderMock.getAll());
    }

    @Test
    void getAllByPostcode() {
        assertNotNull(locationProviderMock.getAllByPostcode(Set.of("1234-1")));
    }

    @Test
    void getAllByCity() {
        assertNotNull(locationProviderMock.getAllByCity("City 1"));
    }

    @Test
    void getAllByCountry() {
        assertNotNull(locationProviderMock.getAllByCountry("Country 1"));
    }

    @Test
    void getAllByState() {
        assertNotNull(locationProviderMock.getAllByState("State 1"));
    }

    @Test
    void getAllByStreet() {
        assertNotNull(locationProviderMock.getAllByStreet("Street 1"));
    }

    @Test
    void getByPostcode() {
        assertNotNull(locationProviderMock.getByPostcode("1234-1"));
    }
}
