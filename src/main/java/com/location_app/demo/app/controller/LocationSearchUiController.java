package com.location_app.demo.app.controller;

import com.location_app.demo.app.service.LocationSearchService;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;


@Controller
@RequiredArgsConstructor
public class LocationSearchUiController {

    private final LocationSearchService locationSearchService;

    @RequestMapping({"/ui", "/ui/locations"})
    public String getLocations(Model model) {
        model.addAttribute("locations", locationSearchService.getLocations());
        return "locations";
    }

    @RequestMapping("/ui/locations/search")
    public String getLocationsByPostcode(Model model, @RequestParam Set<String> postcodeList){
        if (CollectionUtils.isEmpty(postcodeList)) {
            return "redirect:/ui/locations";
        }
        model.addAttribute("locations", locationSearchService.getLocations(postcodeList));
        return "locations";
    }

    @GetMapping("/ui/postcode/search")
    public String getPostcodeByLocation(Model model,
                                        @RequestParam String country,
                                        @RequestParam String state,
                                        @RequestParam String city,
                                        @RequestParam String street) {
        if (StringUtils.isBlank(country) && StringUtils.isBlank(state)
                && StringUtils.isBlank(city) && StringUtils.isBlank(street)) {
            return "redirect:/ui/locations";
        }
        model.addAttribute("locations", locationSearchService.getPostcode(country, state, city, street));
        return "locations";
    }

}
