package com.location_app.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.location_app.demo.app.domain.LocationCache;
import com.location_app.demo.app.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	@Profile("Profile2")
	public CommandLineRunner loadRedisData(@Value("${location.provider.mock.file}") String locationsMockFileName,
										   RedisRepository redisRepository) {
		return (args) -> {
			try (InputStream inputStream = getClass().getResourceAsStream(locationsMockFileName)) {
				if (Objects.nonNull(inputStream)) {
					redisRepository.deleteAll();

					ObjectMapper mapper = new ObjectMapper();
					JsonNode root = mapper.readTree(inputStream);

					List<LocationCache> locationCacheList =
							mapper.convertValue(root.get("response").get("body"), new TypeReference<>(){});
					redisRepository.saveAll(locationCacheList);
				}
			}
		};
	}

}
