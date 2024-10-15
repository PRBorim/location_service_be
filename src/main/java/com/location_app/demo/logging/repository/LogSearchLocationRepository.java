package com.location_app.demo.logging.repository;

import com.location_app.demo.logging.domain.LogSearchLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface LogSearchLocationRepository
        extends JpaRepository<LogSearchLocation, BigInteger> {
}
