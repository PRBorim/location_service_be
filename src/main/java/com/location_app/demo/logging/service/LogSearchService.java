package com.location_app.demo.logging.service;

import com.location_app.demo.app.domain.Location;
import com.location_app.demo.logging.domain.LogSearchLocation;
import com.location_app.demo.logging.repository.LogSearchLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class LogSearchService {

    private final LogSearchLocationRepository logSearchLocationRepository;

    public void logSearch(Collection<String> search, Collection<Location> result) {
        LogSearchLocation logEntry = LogSearchLocation.builder()
                .date(LocalDateTime.now())
                .search(search)
                .result(result)
                .build();

        logSearchLocationRepository.save(logEntry);
    }

}
