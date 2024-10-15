package com.location_app.demo.app.repository;

import com.location_app.demo.app.domain.LocationCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface RedisRepository
        extends CrudRepository<LocationCache, BigInteger> {
}
