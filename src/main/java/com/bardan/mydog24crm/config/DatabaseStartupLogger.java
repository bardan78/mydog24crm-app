package com.bardan.mydog24crm.config;

import com.bardan.mydog24crm.domain.DogRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // Lombok will create the constructor for final fields
public class DatabaseStartupLogger implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseStartupLogger.class);

    private final DogRepository dogRepository;

    @Override
    public void run(String... args) throws Exception {
        long dogCount = dogRepository.count();
        logger.info("=================================================================");
        logger.info("Application successfully connected to the database.");
        logger.info("Number of records in the 'dog' table: {}", dogCount);
        logger.info("=================================================================");
    }
}
