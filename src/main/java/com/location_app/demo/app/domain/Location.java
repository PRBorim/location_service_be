package com.location_app.demo.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private String postcode;
    private String city;
    private String country;
    private String state;
    private String street;
}
